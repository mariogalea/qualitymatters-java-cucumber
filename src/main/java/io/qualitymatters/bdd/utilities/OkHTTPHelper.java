package io.qualitymatters.bdd.utilities;

import java.io.IOException;
import java.util.Base64;

import okhttp3.*;

public class OkHTTPHelper implements HTTPHelper {

    private final OkHttpClient client;
    private final MediaType JSON = MediaType.get("application/json");

    private String globalBearerToken;

    public OkHTTPHelper() {
        this.client = new OkHttpClient();
    }

    public OkHTTPHelper(String bearerToken) {
        this.client = new OkHttpClient();
        this.globalBearerToken = bearerToken;
    }

    public void setGlobalBearerToken(String token) {
        this.globalBearerToken = token;
    }

    // Encodes username:password in base64
    private String basicAuthHeader(String username, String password) {
        String credentials = username + ":" + password;
        return "Basic " + Base64.getEncoder().encodeToString(credentials.getBytes());
    }

    // Creates the request builder with correct Authorization header
    private Request.Builder createRequestBuilder(String url, String username, String password, String bearerToken) {
        Request.Builder builder = new Request.Builder().url(url);

        if (username != null && password != null) {
            builder.header("Authorization", basicAuthHeader(username, password));
        } else if (bearerToken != null) {
            builder.header("Authorization", "Bearer " + bearerToken);
        } else if (globalBearerToken != null) {
            builder.header("Authorization", "Bearer " + globalBearerToken);
        }

        return builder;
    }

    // GET
    public String get(String url) {
        return get(url, null, null, null);
    }

    public String get(String url, String username, String password) {
        return get(url, username, password, null);
    }

    public String get(String url, String username, String password, String bearerToken) {
        Request request = createRequestBuilder(url, username, password, bearerToken).build();
        return executeRequest(request, "GET", url);
    }

    // POST
    public String post(String url, String jsonBody) {
        return post(url, jsonBody, null, null, null);
    }

    public String post(String url, String jsonBody, String username, String password) {
        return post(url, jsonBody, username, password, null);
    }

    public String post(String url, String jsonBody, String username, String password, String bearerToken) {
        RequestBody body = RequestBody.create(jsonBody, JSON);
        Request request = createRequestBuilder(url, username, password, bearerToken)
            .post(body)
            .build();
        return executeRequest(request, "POST", url);
    }

    // PUT
    public String put(String url, String jsonBody) {
        return put(url, jsonBody, null, null, null);
    }

    public String put(String url, String jsonBody, String username, String password) {
        return put(url, jsonBody, username, password, null);
    }

    public String put(String url, String jsonBody, String username, String password, String bearerToken) {
        RequestBody body = RequestBody.create(jsonBody, JSON);
        Request request = createRequestBuilder(url, username, password, bearerToken)
            .put(body)
            .build();
        return executeRequest(request, "PUT", url);
    }

    // DELETE
    public String delete(String url) {
        return delete(url, null, null, null);
    }

    public String delete(String url, String username, String password) {
        return delete(url, username, password, null);
    }

    public String delete(String url, String username, String password, String bearerToken) {
        Request request = createRequestBuilder(url, username, password, bearerToken)
            .delete()
            .build();
        return executeRequest(request, "DELETE", url);
    }

    // LOGGING
    public void logResponseTime(String url) {
        OkHttpClient timedClient = new OkHttpClient.Builder()
            .addInterceptor(new LoggingInterceptor())
            .build();

        Request.Builder builder = new Request.Builder()
            .url(url)
            .header("User-Agent", "Booking Endpoint");

        if (globalBearerToken != null) {
            builder.header("Authorization", "Bearer " + globalBearerToken);
        }

        Request request = builder.build();

        try (Response response = timedClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected response code: " + response.code());
            }
            System.out.println("Response time: " + response.protocol() + " " + response.code());
        } catch (IOException e) {
            System.err.println("Error logging response time: " + e.getMessage());
            throw new RuntimeException("Error logging response time for " + url, e);
        }
    }

    
    // Shared executor
    private String executeRequest(Request request, String method, String url) {
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected response code: " + response.code());
            }

            ResponseBody body = response.body();
            if (body == null) {
                throw new IOException("Response body is null");
            }

            return body.string();

        } catch (IOException e) {
            System.err.println(method + " request failed for " + url + ": " + e.getMessage());
            throw new RuntimeException("Error during " + method + " request to " + url, e);
        }
    }

    public Response getRawResponse(String url) {
        Request request = createRequestBuilder(url, null, null, null).build();
        return executeRequestRaw(request, "GET", url); 
    }

    private Response executeRequestRaw(Request request, String method, String url) {
        try {
            Response response = client.newCall(request).execute();
            return response; // Let caller handle response code
        } catch (IOException e) {
            System.err.println(method + " request failed for " + url + ": " + e.getMessage());
            throw new RuntimeException("Error during " + method + " request to " + url, e);
        }
    }

}