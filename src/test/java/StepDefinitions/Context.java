package StepDefinitions;

import io.qualitymatters.bdd.booking.pojo.Booking;
import io.qualitymatters.bdd.booking.pojo.NestedBookingPojo;

public  class Context {

    private Booking booking;
    private NestedBookingPojo bookings;

    public Booking getBooking(){
        
        return this.booking;
    }

    public void setBooking(Booking booking) {

        this.booking = booking;
    }

    public NestedBookingPojo getBookings() {

        return this.bookings;
    }

    public void setBookings(NestedBookingPojo bookings) {

        this.bookings = bookings;
    }


}
