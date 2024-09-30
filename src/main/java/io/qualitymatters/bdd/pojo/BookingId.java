package io.qualitymatters.bdd.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

// https://www.jsonschema2pojo.org/
/*
    [
      {
        "bookingid": 231
      },
      {
        "bookingid": 614
      },
      {
        "bookingid": 508
      },
      {
        "bookingid": 473
      }
   ]
 */
public class BookingId {

    @JsonProperty("bookingid")
    private int bookingId;

    public int getBookingid() {
        return this.bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
}
