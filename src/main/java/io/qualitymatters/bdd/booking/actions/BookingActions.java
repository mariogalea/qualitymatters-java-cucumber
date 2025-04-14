package io.qualitymatters.bdd.booking.actions;

import java.io.IOException;

import io.qualitymatters.bdd.booking.pojo.Booking;

//Serialization Imports - Enable to Test Serialization
//import java.util.ArrayList;
//import io.qualitymatters.bdd.booking.pojo.Booking;

import io.qualitymatters.bdd.booking.pojo.NestedBookingPojo;
import io.qualitymatters.bdd.utilities.HTTPHelper;

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

    public Booking addBooking() throws IOException{

        JSONObject json = new JSONObject();

        json.put("firstName", "Takeshi");
        json.put("lastName","Kitano");

        String response = HTTPHelper.post(BASE_URL + "/new", json.toString());

        Booking booking = mapper.readValue(response, Booking.class);

        return booking;

    }

    public Booking updateBookingById(int id) throws IOException {
        
        JSONObject json = new JSONObject();

        json.put("firstName", "UpdatedFirstName");
        json.put("lastName","UpdatedLastName");

        String response = HTTPHelper.put(BASE_URL + "/update/" + id, json.toString());

        Booking booking = mapper.readValue(response, Booking.class);

        return booking;

    }
    
    public void deleteBookingById(int id) throws IOException {

        String response = HTTPHelper.delete(BASE_URL + "/delete/" + id);

        System.out.println(response);

    }

}