package booking;

import io.cucumber.java.en.*;
import io.qualitymatters.bdd.service.booking.BookingService;

import java.io.IOException;

public class StepDefinitions {

    BookingService bookingService = new BookingService();

    @Given("a bookings list is available")
    public void aBookingsListIsAvailable() throws IOException, InterruptedException {

        bookingService.getBookings();

    }

    @When("the user retrieves booking list")
    public void theUserRetrievesBookingList() {


    }

    @When("the user retrieves booking id {int}")
    public void theUserRetrievesBookingId(int id) {



    }

    @Then("the user should have a list of all bookings")
    public void theUserShouldHaveAListOfAllBookings() throws IOException, InterruptedException {


    }

    @Then("the user should have booking id {int}")
    public void theUserShouldHaveBookingId(int id) {

    }
}