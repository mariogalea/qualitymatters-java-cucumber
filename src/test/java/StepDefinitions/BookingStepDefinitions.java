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

    BookingActions bookingActions = new BookingActions();

    @Given("a bookings list is available")
    public void a_booking_list_is_available() throws IOException, InterruptedException {
        context.bookingIds = bookingActions.getBookings();
    }

    @When("the user retrieves booking list")
    public void the_user_retrieves_booking_list() throws IOException, InterruptedException {
        context.bookingIds = bookingActions.getBookings();
    }

    @When("the user retrieves booking id {int}")
    public void the_user_retrieves_booking_id(int id) throws IOException, InterruptedException {
        bookingActions.getBookingByARandomId();
    }

    @When("the user updates booking id {int}")
    public void the_user_updates_booking_id(int id) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user deletes booking by id {int}")
        public void the_user_deletes_booking_by_id(int id) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
    @When("the user adds a new booking")
    public void the_user_adds_a_new_booking() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("booking id {int} is available")
    public void booking_id_is_available(int id) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("the user should have an updated booking id {int}")
    public void the_user_should_have_an_updated_booking(int id) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
    @Then("the user should have a list of all bookings")
    public void the_user_should_have_a_list_of_all_bookings() throws IOException, InterruptedException {
        List<BookingId> bookingIds = context.bookingIds;
        Assertions.assertFalse(bookingIds.isEmpty());
    }

    @Then("the user should have booking id {int}")
    public void the_user_should_have_booking_id(int id) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the user should have the specified booking")
    public void the_user_should_have_the_speficied_booking() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the user should not have booking id {int}")
    public void the_user_should_not_have_booking_id(int id) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("the user should have an updated booking list")
    public void the_user_should_have_an_updated_booking_list() {
        // Write code here that turns the phrase above into concrete actions
    }


}