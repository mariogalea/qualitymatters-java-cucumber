package io.qualitymatters.bdd.booking.actions;

import java.io.IOException;

import io.qualitymatters.bdd.booking.pojo.Booking;

//Serialization Imports - Enable to Test Serialization
//import java.util.ArrayList;
//import io.qualitymatters.bdd.booking.pojo.Booking;

import io.qualitymatters.bdd.booking.pojo.NestedBookingPojo;
import io.qualitymatters.bdd.config.Config;
import io.qualitymatters.bdd.utilities.OkHTTPHelper;
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

    public Long captureResponseTime(long expectedResponseTime) {

        Long startTime = System.currentTimeMillis();
        Long duration;
        String response = ""; // String to hold the response body

        // Getting the response as a string
        response = httpHelper.get(getBaseUrl() + BookingsUrl, getUsername(), getPassword());
        duration = System.currentTimeMillis() - startTime;

        // Checking if the response is empty or contains an error
        if (response.isEmpty()) {
            System.out.println("  > Request failed with no response body.");
        } else {
            System.out.println("  > Request successful!");
        }

        System.out.println("  > Response time: " + duration + "ms");
        if (duration > expectedResponseTime) {
            System.out.println("  > Response time exceeded " + expectedResponseTime + " ms!");
        } else {
            System.out.println("  > Response time is within limit.");
        }

        return duration;
    }

    // No Exception Handling for HTTP Error Codes
    public Response getUnauthorisedBookingsRawResponse() {
        String url = getBaseUrl() + BookingsUrl;
        return httpHelper.getRawResponse(url);
    }

}