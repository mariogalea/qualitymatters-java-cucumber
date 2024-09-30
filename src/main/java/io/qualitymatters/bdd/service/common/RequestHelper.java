package io.qualitymatters.bdd.service.common;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class RequestHelper {

    public static HttpResponse<String> executeGetRequest(String uri) throws IOException, InterruptedException {

        // HTTP Client
        HttpClient client = HttpClient
                .newBuilder()
                .connectTimeout(Duration.ofMillis(10000))
                .build();

        // Request - GET HTTP
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        // Response - Store Response
       return  client.send(request, HttpResponse.BodyHandlers.ofString());
    }

}
