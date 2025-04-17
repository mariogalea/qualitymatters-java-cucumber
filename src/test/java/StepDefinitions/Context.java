package StepDefinitions;

import org.json.JSONObject;

import io.qualitymatters.bdd.booking.pojo.Booking;
import io.qualitymatters.bdd.booking.pojo.NestedBookingPojo;

public class Context {

    private static Booking booking;
    private static NestedBookingPojo bookings;
    private static JSONObject JSON;

    public Booking getBooking(){
        
        return booking;
    }

    public void setBooking(Booking booking) {

        Context.booking = booking;
    }

    public NestedBookingPojo getBookings() {

        return bookings;
    }

    public void setBookings(NestedBookingPojo bookings) {

        Context.bookings = bookings;
    }

    public JSONObject getJSON(){

        return JSON;

    }

    public void setJSON(JSONObject JSON) {

        Context.JSON = JSON;

    }

}