package io.qualitymatters.bdd.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingDates {

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
