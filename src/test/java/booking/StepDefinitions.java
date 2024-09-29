package booking;

import io.cucumber.java.en.*;
import io.qualitymatters.bdd.service.booking.BookingService;

import java.io.IOException;
import java.net.http.HttpResponse;

public class StepDefinitions {

    BookingService service = new BookingService();

    @Given("a bookings list is available")
    public void aBookingsListIsAvailable() throws IOException, InterruptedException {

        service.getBookings();

    }

    @When("the user retrieves booking list")
    public void theUserRetrievesBookingList() /*throws IOException, InterruptedException */{


    }

    @When("the user retrieves booking id {int}")
    public void theUserRetrievesBookingId(int id) {



    }

    @Then("the user should have a list of all bookings")
    public void theUserShouldHaveAListOfAllBookings() throws IOException, InterruptedException {

        HttpResponse<String> bookingsList = service.getBookings();


        assert !(bookingsList == null);
    }

    @Then("the user should have booking id {int}")
    public void theUserShouldHaveBookingId(int id) {
    }
}