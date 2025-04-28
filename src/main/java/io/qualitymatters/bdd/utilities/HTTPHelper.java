package io.qualitymatters.bdd.utilities;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class HTTPHelper {

    private static final OkHttpClient client = new OkHttpClient();
    private static final MediaType JSON = MediaType.get("application/json");

    public static String get(String BASE_URL) {
        
        Request request = new Request.Builder()
            .url(BASE_URL)
            .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected response code: " + response.code() + " - " + response.message());
            }

            ResponseBody responseBody = response.body();
            if (responseBody == null) {
                throw new IOException("Response body is null");
            }

            return responseBody.string();

        } catch (IOException e) {
            throw new RuntimeException("Failed to make GET request to " + BASE_URL + ": " + e.getMessage(), e);
        }
    }

    public static String post(String BASE_URL, String jsonBody) {
        RequestBody body = RequestBody.create(jsonBody, JSON);
        Request request = new Request.Builder()
            .url(BASE_URL)
            .post(body)
            .build();
    
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected response code: " + response.code());
            }
            return response.body().string();

        } catch (IOException e) {
            // Log error with specific message
            System.err.println("Post request failed: " + e.getMessage());
            throw new RuntimeException("Error during POST request to " + BASE_URL, e);
        }
    }
    
    public static String put(String BASE_URL, String jsonBody) {
        RequestBody body = RequestBody.create(jsonBody, JSON);
        Request request = new Request.Builder()
            .url(BASE_URL)
            .put(body)
            .build();
    
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected response code: " + response.code());
            }
            return response.body().string();

        } catch (IOException e) {
            // Log error with specific message
            System.err.println("Put request failed: " + e.getMessage());
            throw new RuntimeException("Error during PUT request to " + BASE_URL, e);
        }
    }
    
    public static String delete(String BASE_URL) {
        Request request = new Request.Builder()
            .url(BASE_URL)
            .delete()
            .build();
    
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected response code: " + response.code());
            }
            return response.body().string();
            
        } catch (IOException e) {
            System.err.println("Delete request failed: " + e.getMessage());
            throw new RuntimeException("Error during DELETE request to " + BASE_URL, e);
        }
    }
    
    public static void logResponseTime(String BASE_URL) {
        OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(new LoggingInterceptor())
            .build();
    
        Request request = new Request.Builder()
            .url(BASE_URL)
            .header("User-Agent", "Booking Endpoint")
            .build();
    
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected response code: " + response.code());
            }
            // Log response time
            System.out.println("Response time: " + response.protocol() + " " + response.code());
        } catch (IOException e) {
            // Log error with specific message
            System.err.println("Error logging response time: " + e.getMessage());
            throw new RuntimeException("Error logging response time for " + BASE_URL, e);
        }
    }


}