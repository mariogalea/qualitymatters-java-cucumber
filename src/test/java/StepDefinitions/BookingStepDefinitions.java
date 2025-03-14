package StepDefinitions;

import io.cucumber.java.en.*;
import io.qualitymatters.bdd.booking.actions.BookingActions;
import io.qualitymatters.bdd.booking.pojo.BookingId;

import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.util.List;

public class BookingStepDefinitions {

    private final Context context;

    public BookingStepDefinitions(Context context) {
        this.context = context;
    }

    BookingActions bookingService = new BookingActions();

    @Given("a bookings list is available")
    public void aBookingsListIsAvailable() throws IOException, InterruptedException {

        context.bookingIds = bookingService.getBookings();

    }

    @When("the user retrieves booking list")
    public void theUserRetrievesBookingList() throws IOException, InterruptedException {

        context.bookingIds = bookingService.getBookings();

    }

    @When("the user retrieves booking id {int}")
    public void theUserRetrievesBookingId(int id) {


    }

    @When("the user retrieves booking by id")
    public void theUserRetrievesBookingById() throws IOException, InterruptedException {

        bookingService.getBookingByARandomId();



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

    @Then("the user should have the specified booking")
    public void theUserShouldHaveTheSpecifiedBooking() {
    }




}