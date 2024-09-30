package io.qualitymatters.bdd.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingDetails {

    @JsonProperty("firstname")
    String firstName;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("lastname")
    String lastName;

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName; }

    @JsonProperty("totalprice")
    int totalPrice;

    public int getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @JsonProperty("depositpaid")
    boolean depositPaid;

    public boolean getDepositPaid() {
        return this.depositPaid;
    }

    public void setDepositPaid(boolean depositPaid) {
        this.depositPaid = depositPaid;
    }

    @JsonProperty("bookingdates")
    BookingDates bookingDates;

    public BookingDates getBookingDates() {
        return this.bookingDates;
    }

    public void setBookingDates(BookingDates bookingDates) {
        this.bookingDates = bookingDates;
    }

    @JsonProperty("additionalneeds")
    String additionalNeeds;

    public String getAdditionalNeeds() {
        return this.additionalNeeds;
    }
    public void setAdditionalNeeds(String additionalNeeds) {
        this.additionalNeeds = additionalNeeds;
    }
}
