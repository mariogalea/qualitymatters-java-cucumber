package io.qualitymatters.bdd.service.booking;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.qualitymatters.bdd.pojo.BookingId;
import io.qualitymatters.bdd.service.common.RequestHelper;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookingService {

    public BookingService() {

    }

    public List<BookingId> getBookings() throws IOException, InterruptedException {

        String uri = "https://restful-booker.herokuapp.com/booking";
        HttpResponse<String> response = RequestHelper.executeGetRequest(uri);

        /* Print out for debugging purposes
        System.out.printf("Status %s \n", response.statusCode());
        System.out.printf("Response %s \n", response.body());
        */

        ObjectMapper mapper = new ObjectMapper();

        // Deserialization - JSON Response converted into Java Object
        BookingId[] bookingIds = mapper.readValue(response.body(), BookingId[].class);
        // Convert Array to an ArrayList for further object mods.

        /*
        for(BookingId i : bookingIdsList) {
            System.out.printf("Booking Id =  %s \n", i.getBookingid());
        }
        */

        return new ArrayList<>(Arrays.asList(bookingIds));

    }

    public void getBookingByARandomId() throws IOException, InterruptedException {


        List<BookingId> bookingIds = getBookings();

        int selectedBookingId = 0;
        
        for(int i=0; i < bookingIds.size(); i++)
        {
            selectedBookingId = bookingIds.get(3).getBookingid();
        }

        String bookingIdAsString = String.valueOf(selectedBookingId);

        System.out.printf(bookingIdAsString);


        String uri = "https://restful-booker.herokuapp.com/booking/" + bookingIdAsString;

        System.out.printf(uri);

        HttpResponse<String> response = RequestHelper.executeGetRequest(uri);

        System.out.printf("Response %s \n", response.body());


        //ObjectMapper mapper = new ObjectMapper();

        //Booking booking = mapper.readValue(response.body(), Booking.class);
        //https://hyperskill.org/blog/post/beginners-guide-to-rest-api-testing


        //return booking;
    }

}




