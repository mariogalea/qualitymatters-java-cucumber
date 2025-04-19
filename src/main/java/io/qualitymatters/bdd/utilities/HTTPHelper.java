package io.qualitymatters.bdd.utilities;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HTTPHelper {

    private static final OkHttpClient client = new OkHttpClient();
    private static final MediaType JSON = MediaType.get("application/json");

    public static String get(String BASE_URL) throws IOException {

        Request request = new Request.Builder()
            .url(BASE_URL)
            .build();
        
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static String post(String BASE_URL, String jsonBody) throws IOException {

        RequestBody body = RequestBody.create(jsonBody, JSON);
        Request request = new Request.Builder()
            .url(BASE_URL)
            .post(body)
            .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static String put(String BASE_URL, String jsonBody) throws IOException {

        RequestBody body = RequestBody.create(jsonBody, JSON);
        Request request = new Request.Builder()
            .url(BASE_URL)
            .put(body)
            .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static String delete(String BASE_URL) throws IOException {

        Request request = new Request.Builder()
            .url(BASE_URL)
            .delete()
            .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static void logResponseTime(String BASE_URL) throws IOException {

        OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(new LoggingInterceptor())
            .build();

        Request request = new Request.Builder()
            .url(BASE_URL)
            .header("User-Agent", "Booking Endpoint")
            .build();

        Response response = client.newCall(request).execute();

        response.body().close();

    }


}