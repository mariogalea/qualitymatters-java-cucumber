package io.qualitymatters.bdd.booking.actions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.qualitymatters.bdd.booking.pojo.Booking;

//Serialization Imports - Enable to Test Serialization
//import java.util.ArrayList;
//import io.qualitymatters.bdd.booking.pojo.Booking;

import io.qualitymatters.bdd.booking.pojo.NestedBookingPojo;
import io.qualitymatters.bdd.config.Config;
import io.qualitymatters.bdd.utilities.OkHTTPHelper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;


public class BookingActions {

    private final String BookingsUrl = "/bookings";
    private final ObjectMapper mapper = new ObjectMapper();
    private final OkHTTPHelper httpHelper = new OkHTTPHelper();

    Config config;

    public BookingActions(Config config) {
        this.config = config;
    }

    public String getBaseUrl() {
        return config.getBaseUrl();
    }

    public String getUsername() {
        return config.getBasicAuthenticationUsername();
    }

    public String getPassword() {
        return config.getBasicAuthenticationPassword();
    }

    public NestedBookingPojo getBookings() {
        try {
            String response = httpHelper.get(getBaseUrl() + BookingsUrl, getUsername(), getPassword());
            return mapper.readValue(response, NestedBookingPojo.class);
        } catch (IOException e) {
            System.err.println("Error deserializing response: " + e.getMessage());
            throw new RuntimeException("Failed to deserialize bookings data", e);
        }
    }
    
    public Booking getBookingById(int id) {
        try {
            String response = httpHelper.get(getBaseUrl() + BookingsUrl + "/" + id, getUsername(), getPassword());
            return mapper.readValue(response, Booking.class);
        } catch (IOException e) {
            System.err.println("Error deserializing response: " + e.getMessage());
            throw new RuntimeException("Failed to deserialize booking data for ID " + id, e);
        }
    }
    
    public Booking addBooking(JSONObject json) {
        try {
            String response = httpHelper.post(getBaseUrl() + BookingsUrl + "/new", json.toString(), getUsername(), getPassword());
            return mapper.readValue(response, Booking.class);
        } catch (IOException e) {
            System.err.println("Error deserializing response: " + e.getMessage());
            throw new RuntimeException("Failed to deserialize new booking data", e);
        }
    }
    
    public Booking updateBookingById(int id, JSONObject json) {
        try {
            String response = httpHelper.put(getBaseUrl() + BookingsUrl + "/update/" + id, json.toString(), getUsername(), getPassword());
            return mapper.readValue(response, Booking.class);
        } catch (IOException e) {
            System.err.println("Error deserializing response: " + e.getMessage());
            throw new RuntimeException("Failed to deserialize updated booking data for ID " + id, e);
        }
    }
    
    public void deleteBookingById(int id) {

        httpHelper.delete(getBaseUrl() + BookingsUrl + "/delete/" + id, getUsername(), getPassword());

    }

    public Long captureResponseTime() {

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.SECONDS)
                .readTimeout(1, TimeUnit.SECONDS)
                .writeTimeout(1, TimeUnit.SECONDS)
                .build();

        
        Request request = new Request.Builder()
                .url(getBaseUrl() + BookingsUrl)
                .build();

        Long startTime = System.currentTimeMillis();

        Long duration;

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