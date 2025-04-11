package io.qualitymatters.bdd.utilities;

import java.io.IOException;

import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HTTPHelper {

    private static final OkHttpClient client = new OkHttpClient();
    private static final String BASE_URL = "http://localhost:8080/bookings";
    private static final MediaType JSON = MediaType.get("application/json");

    public static String get() throws IOException {

        Request request = new Request.Builder()
            .url(BASE_URL)
            .build();
        
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static String post(JSONObject jsonObject) throws IOException {

        jsonObject = new JSONObject();
        String jsonBody = jsonObject.toString();

        System.out.println(jsonBody);

        RequestBody body = RequestBody.create(jsonBody, JSON);
        Request request = new Request.Builder()
            .url(BASE_URL + "/new")
            .post(body)
            .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

}