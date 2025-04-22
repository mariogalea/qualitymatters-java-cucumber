package io.qualitymatters.bdd.booking.actions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.qualitymatters.bdd.booking.pojo.Booking;

//Serialization Imports - Enable to Test Serialization
//import java.util.ArrayList;
//import io.qualitymatters.bdd.booking.pojo.Booking;

import io.qualitymatters.bdd.booking.pojo.NestedBookingPojo;
import io.qualitymatters.bdd.utilities.HTTPHelper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;


public class BookingActions {

    private final String BASE_URL = "http://localhost:8080/bookings";
    private final ObjectMapper mapper = new ObjectMapper();

    public BookingActions() {

    }

    public NestedBookingPojo getBookings() throws IOException {

        String response = HTTPHelper.get(BASE_URL);

        //Serialization - Convert Response to POJO ie. Bookings (Root NestedBookingPojo)
        NestedBookingPojo bookings = mapper.readValue(response, NestedBookingPojo.class);

        /* Test Serialization
        ArrayList<Booking> fetchedBookings = bookings.get_embedded().getBookingList();
        for(Booking booking : fetchedBookings){
            System.out.println(booking.getId());
            System.out.println(booking.getFirstName());
            System.out.println(booking.getLastName());
            System.out.println("-------------------------------");
        }
        */



        return bookings;
      
    }

    public Booking getBookingById(int id) throws IOException {

        String response = HTTPHelper.get(BASE_URL + "/" + id);

        Booking booking = mapper.readValue(response, Booking.class);

        return booking;

    }

    public Booking addBooking(JSONObject json) throws IOException{

        /* 
        JSONObject json = new JSONObject();

        json.put("firstName", "Takeshi");
        json.put("lastName","Kitano");
        */

        String response = HTTPHelper.post(BASE_URL + "/new", json.toString());

        Booking booking = mapper.readValue(response, Booking.class);

        return booking;

    }

    public Booking updateBookingById(int id, JSONObject json) throws IOException {
        
        /* 
        JSONObject json = new JSONObject();

        json.put("firstName", "UpdatedFirstName");
        json.put("lastName","UpdatedLastName");
        */
        String response = HTTPHelper.put(BASE_URL + "/update/" + id, json.toString());

        Booking booking = mapper.readValue(response, Booking.class);

        return booking;

    }
    
    public void deleteBookingById(int id) throws IOException {

        HTTPHelper.delete(BASE_URL + "/delete/" + id);

    }

    public long captureResponseTime() {

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.SECONDS)
                .readTimeout(1, TimeUnit.SECONDS)
                .writeTimeout(1, TimeUnit.SECONDS)
                .build();

        Request request = new Request.Builder()
                .url(BASE_URL)
                .build();

        long startTime = System.currentTimeMillis();

        long duration;

        try (Response response = client.newCall(request).execute()) {
             duration = System.currentTimeMillis() - startTime;

            if (!response.isSuccessful()) {
                System.out.println("  > Request failed with code: " + response.code());
            } else {
                System.out.println("  > Request successful!");
            }

            System.out.println("  > Response time: " + duration + "ms");
            if (duration > 1000) {
                System.out.println("  > Response time exceeded 1 second!");
            } else {
                System.out.println("  > Response time is within limit.");
            }

        } catch (IOException e) {
            duration = System.currentTimeMillis() - startTime;
            System.out.println("  > Request failed: " + e.getMessage());
            System.out.println("  > Response time before failure: " + duration + "ms");
        }

        return duration;
    }

}