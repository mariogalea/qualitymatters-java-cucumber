package io.qualitymatters.bdd.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

//https://json2csharp.com/code-converters/json-to-pojo
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
