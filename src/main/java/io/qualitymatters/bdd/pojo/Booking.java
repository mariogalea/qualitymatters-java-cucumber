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

class BookingDates {
    @JsonProperty("checkin")
    String checkin;

    public String getCheckin() {
        return this.checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    @JsonProperty("checkout")
    String checkout;

    public String getCheckout() {
        return this.checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

}

class BookingDetails {


    @JsonProperty("firstname")
    String firstname;

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @JsonProperty("lastname")
    String lastname;

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname; }

    @JsonProperty("totalprice")
    int totalprice;

    public int getTotalprice() {
        return this.totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    @JsonProperty("depositpaid")
    boolean depositpaid;

    public boolean getDepositpaid() {
        return this.depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    @JsonProperty("bookingdates")
    BookingDates bookingdates;

    public BookingDates getBookingdates() {
        return this.bookingdates;
    }

    public void setBookingdates(BookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }

    @JsonProperty("additionalneeds")
    String additionalneeds;

    public String getAdditionalneeds() {
        return this.additionalneeds;
    }
    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }


}

