package io.qualitymatters.bdd.service.booking;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class BookingService {

    public BookingService() {

    }

    public HttpResponse<String> getBookings() throws IOException, InterruptedException {

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

        // Store the response in an object = deserialize JSON string into a Java object.
        // endpoint returns an array of BookingIds  ex:
        /*
            [
              {
                "bookingid": 231
              },
              {
                "bookingid": 614
              },
              {
                "bookingid": 508
              },
              {
                "bookingid": 473
              }
           ]
         */

        ObjectMapper mapper = new ObjectMapper();
        BookingId[] marketData = mapper.readValue(response.body(), BookingId[].class);

        for(BookingId i : marketData) {

            System.out.printf("Booking Id =  %s \n", i.getBookingid());

        }


        return response;


    }

}


// https://www.jsonschema2pojo.org/
class BookingId {

    @JsonProperty("bookingid")
    private int bookingId;

    public int getBookingid() {
        return this.bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
}

