package io.qualitymatters.bdd.service.booking;


import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/*

 */


public class BookingService {

    public BookingService() {

    }

    public HttpResponse<String> getBookings() throws IOException, InterruptedException {

        // HTTP Client
        HttpClient client = HttpClient
                .newBuilder()
                .connectTimeout(Duration.ofMillis(1000))
                .build();



        // Request - GET HTTP
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create("https://restful-booker.herokuapp.com/booking"))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        // Response - Store Response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.printf("Status %s \n", response.statusCode());
        System.out.printf("Response %s \n", response.body());

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();



        return response;


    }

}