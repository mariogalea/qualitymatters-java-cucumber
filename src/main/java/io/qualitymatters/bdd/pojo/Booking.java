package io.qualitymatters.bdd.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Booking {

    @JsonProperty("bookingid")
    BookingId bookingid;

    public BookingId getBookingid() {
        return this.bookingid;
    }

    public void setBookingid(BookingId bookingid) {
        this.bookingid = bookingid;
    }

    @JsonProperty("booking")
    BookingDetails bookingDetails;

    public BookingDetails getBookingDetails() {
        return this.bookingDetails;
    }
    public void setBookingDetails(BookingDetails bookingDetails) {
        this.bookingDetails = bookingDetails; }

}