package io.qualitymatters.bdd.booking.actions;

import java.io.IOException;
//import java.util.ArrayList;

import io.qualitymatters.bdd.booking.pojo.Booking;
import io.qualitymatters.bdd.booking.pojo.NestedBookingPojo;
import io.qualitymatters.bdd.utilities.HTTPHelper;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;


public class BookingActions {

    private final String BASE_URL = "http://localhost:8080/bookings";


    public BookingActions() {

    }

    public void getBookings() throws IOException {

        String response = HTTPHelper.get(BASE_URL);
        //Convert string to JSON Object
          //JSONObject responseInJSON = new JSONObject(response);

        //Serialization - Convert Response to POJO ie. Bookings (Root NestedBookingPojo)
        ObjectMapper mapper = new ObjectMapper();
        NestedBookingPojo bookings = mapper.readValue(response, NestedBookingPojo.class);

        //Test Serialization
         //ArrayList<Booking> fetchedBookings = bookings.get_embedded().getBookingList();
        for(Booking booking : bookings.get_embedded().getBookingList()){

            System.out.println(booking.getId());
            System.out.println(booking.getFirstName());
            System.out.println(booking.getLastName());
            System.out.println("-------------------------------");

        }
        
        System.out.println(bookings.get_embedded().getBookingList().get(0).getFirstName());
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println(response);
    
    }

    public void getBookingById(int id) throws IOException {

        String response = HTTPHelper.get(BASE_URL + "/" + id);

        System.out.println(response);

    }

    public void addBooking() throws IOException{

        JSONObject json = new JSONObject();

        json.put("firstName", "Takeshi");
        json.put("lastName","Kitano");

        String responsePost = HTTPHelper.post(BASE_URL + "/new", json.toString());

        System.out.println(responsePost);

    }

    public void updateBookingById(int id) throws IOException {
        
        JSONObject json = new JSONObject();

        json.put("firstName", "UpdatedFirstName");
        json.put("lastName","UpdatedLastName");

        String responsePost = HTTPHelper.put(BASE_URL + "/update/" + id, json.toString());

        System.out.println(responsePost);

    }
    
    public void deleteBookingById(int id) throws IOException {

        String response = HTTPHelper.delete(BASE_URL + "/delete/" + id);

        System.out.println(response);

    }

}