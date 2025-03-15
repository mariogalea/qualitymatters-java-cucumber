package io.qualitymatters.bdd.booking.pojo.booking;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Embedded {

    private ArrayList<Booking> bookingList;

    @JsonProperty("bookingList") 
    public ArrayList<Booking> getBookingList() { 
	    return this.bookingList;         
    } 

    public void setBookingList(ArrayList<Booking> bookingList) { 
	    this.bookingList = bookingList; 
    } 
}