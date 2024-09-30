package StepDefinitions;

import io.cucumber.java.en.*;
import io.qualitymatters.bdd.pojo.BookingId;
import io.qualitymatters.bdd.service.booking.BookingService;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.util.List;

public class BookingStepDefinitions {

    private final Context context;

    public BookingStepDefinitions(Context context) {
        this.context = context;
    }

    BookingService bookingService = new BookingService();

    @Given("a bookings list is available")
    public void aBookingsListIsAvailable() throws IOException, InterruptedException {


    }

    @When("the user retrieves booking list")
    public void theUserRetrievesBookingList() throws IOException, InterruptedException {

        context.bookingIds = bookingService.getBookings();

    }

    @When("the user retrieves booking id {int}")
    public void theUserRetrievesBookingId(int id) {


    }

    @Then("the user should have a list of all bookings")
    public void theUserShouldHaveAListOfAllBookings() throws IOException, InterruptedException {

        List<BookingId> bookingIds = context.bookingIds;
        /*
        for (BookingId i : bookingIds) {
            System.out.printf("Booking Id =  %s \n", i.getBookingid());
        }
        */
        Assertions.assertFalse(bookingIds.isEmpty());


    }

    @Then("the user should have booking id {int}")
    public void theUserShouldHaveBookingId(int id) {

    }
}