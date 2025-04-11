package io.qualitymatters.bdd.booking.actions;

import java.io.IOException;

import io.qualitymatters.bdd.utilities.HTTPHelper;

import org.json.JSONObject;


public class BookingActions {

    private final String BASE_URL = "http://localhost:8080/bookings";


    public BookingActions() {

    }

    public void getBookings() throws IOException {

        String response = HTTPHelper.get(BASE_URL);

        System.out.println(response);
    
    }

    public void getBookingById(int id) throws IOException {

        String response = HTTPHelper.get(BASE_URL + "/" + id);

        System.out.println(response);

    }

    public void addBooking() throws IOException{

        JSONObject json = new JSONObject();

        json.put("firstName", "Gorgio");
        json.put("lastName","Armani");

        String responsePost = HTTPHelper.post(BASE_URL + "/new", json.toString());

        System.out.println(responsePost);



    }

    public void updateBookingById(int id) throws IOException {

        
        JSONObject json = new JSONObject();

        json.put("firstName", "Gorgio");
        json.put("lastName","Armani");

        String responsePost = HTTPHelper.put(BASE_URL + "/update/", json.toString());

        System.out.println(responsePost);

    }
    
    public void deleteBookingById(int id) throws IOException {

        String response = HTTPHelper.delete(BASE_URL + "/delete/" + id);

        System.out.println(response);

    }

}