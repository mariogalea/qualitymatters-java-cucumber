package io.qualitymatters.bdd.service.booking;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import io.qualitymatters.bdd.pojo.BookingId;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookingService {

    public BookingService() {

    }

    public List<BookingId> getBookings() throws IOException, InterruptedException {

        // HTTP Client
        HttpClient client = HttpClient
                .newBuilder()
                .connectTimeout(Duration.ofMillis(10000))
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

        // Print it out for debugging purposes
        System.out.printf("Status %s \n", response.statusCode());
        System.out.printf("Response %s \n", response.body());

        ObjectMapper mapper = new ObjectMapper();

        // Deserialization - JSON Response converted into Java Object
        BookingId[] bookingIds = mapper.readValue(response.body(), BookingId[].class);
        // Convert Array to an ArrayList for further object mods.
        List<BookingId> bookingIdsList = new ArrayList<>(Arrays.asList(bookingIds));
        for(BookingId i : bookingIdsList) {
            System.out.printf("Booking Id =  %s \n", i.getBookingid());
        }

        return bookingIdsList;

    }

}




