package io.qualitymatters.bdd.booking.actions;

import java.io.IOException;

import io.qualitymatters.bdd.utilities.HTTPHelper;

import org.json.JSONObject;


public class BookingActions {

    public BookingActions() {

    }

    public void getBookings() throws IOException {

        String response = HTTPHelper.get();
        System.out.println(response);
    
    }

    public void getBookingById() {

    }

    public void postBooking() throws IOException{

        JSONObject json = new JSONObject();

        json.put("firstname", "Gorgio");
        json.put("lastName","Armani");

        String responsePost = HTTPHelper.post(json);

        System.out.println(responsePost);



    }

    public void putBookingById() {

    }
    
    public void deleteBookingById() {

    }

}