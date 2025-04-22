package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.*;
import io.qualitymatters.bdd.booking.actions.BookingActions;
import io.qualitymatters.bdd.booking.pojo.Booking;
import io.qualitymatters.bdd.booking.pojo.NestedBookingPojo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;



public class BookingStepDefinitions {

    private final Context context;
    
    BookingActions bookingActions = new BookingActions();

    /*
     * Dependency inject Context class to share Objects between different Steps within the same and different Step Definition files.
     */
    public BookingStepDefinitions(Context context) {
        this.context = context;
    }



    @DataTableType
    public Booking transformBooking(Map<String, String> entry) {

        Booking booking = new Booking();

        int id = Integer.parseInt(entry.get("id"));

        booking.setId(id);
        booking.setFirstName(entry.get("firstName"));
        booking.setLastName(entry.get("lastName"));
        return booking;
    }

    @Given("a bookings list is available")
    public void a_booking_list_is_available() throws IOException {
  
        //context.setBookings(bookingActions.getBookings());
        context.set("bookingList", bookingActions.getBookings());

    }

    @When("the user retrieves booking list")
    public void the_user_retrieves_booking_list() throws IOException {

        context.setBookings(bookingActions.getBookings());
  
    }

    @When("the user retrieves booking id {int}")
    public void the_user_retrieves_booking_id(int id) throws IOException {

        context.setBooking(bookingActions.getBookingById(id));

    }

    @When("the user updates booking id {int}")
    public void the_user_updates_booking_id(int id) throws IOException {

        JSONObject json = new JSONObject();

        json.put("firstName", "Robert");
        json.put("lastName","Plant");

        context.setJSON(json);

        Booking updatedBooking = bookingActions.updateBookingById(id, json);

        context.setBooking(updatedBooking);

    }

    @When("the user deletes booking by id {int}")
    public void the_user_deletes_booking_by_id(int id) throws IOException {

        bookingActions.deleteBookingById(id);
        context.setBookings(bookingActions.getBookings());

    }
    
    @When("the user adds a new booking")
    public void the_user_adds_a_new_booking() throws IOException {

        JSONObject json = new JSONObject();

        json.put("firstName", "Takeshi");
        json.put("lastName","Kitano");

        context.setJSON(json);

        Booking addedBooking = bookingActions.addBooking(json);

        context.setBooking(addedBooking);
    }

    @When("booking id {int} is available")
    public void booking_id_is_available(int id) throws IOException {
  
        Booking booking = bookingActions.getBookingById(id);
        context.setBooking(booking);

    }

    @When("the response time is captured")
    public void the_response_time_is_captured() {

        long responsetTimeCaptured = bookingActions.captureResponseTime();

        context.setResponseTime(responsetTimeCaptured);  
    }

    // Data Table
    @When("^the user updates booking with the following$")
    public void the_user_updates_booking_id_with_the_following(DataTable bookingDetails) throws IOException {

        List<Booking> bookings = bookingDetails.asList(Booking.class);
        JSONObject json = new JSONObject();
        Booking updatedBooking = new Booking();

        for (Booking booking : bookings) {
            json.put("firstName",booking.getFirstName());
            json.put("lastName",booking.getLastName());

            updatedBooking = bookingActions.updateBookingById(booking.getId(), json);
        }

        context.setJSON(json);
        context.setBooking(updatedBooking);
    }

    @When("the user adds booking with {string} and {string}")
    public void the_user_adds_booking_with_and(String firstName, String lastName) throws IOException {

        JSONObject json = new JSONObject();

        json.put("firstName", firstName);
        json.put("lastName", lastName);

        context.setJSON(json);

        Booking addedBooking = bookingActions.addBooking(json);

        context.setBooking(addedBooking);    
    }
    
    @Then("the user should have a list of all bookings")
    public void the_user_should_have_a_list_of_all_bookings() {

        //NestedBookingPojo bookings = context.getBookings();
        NestedBookingPojo bookings = context.get("bookingList", NestedBookingPojo.class);

        Assertions.assertFalse(bookings.get_embedded().getBookingList().isEmpty());

    }

    @Then("the user should have booking id {int}")
    public void the_user_should_have_booking_id(int id) {

        Booking booking = context.getBooking();

        Assertions.assertTrue(booking.getId() == 3);

    }

    @Then("the user should not have booking id {int}")
    public void the_user_should_not_have_booking_id(int id) throws IOException {

        NestedBookingPojo bookings = context.getBookings();
        
        boolean isFound = false; 

        for(Booking booking : bookings.get_embedded().getBookingList()){

            if(booking.getId() == 5) {
                isFound = true;
            }
        }

        Assertions.assertFalse(isFound);
    }

    @Then("the user should have an updated booking list")
    public void the_user_should_have_an_updated_booking_list() throws IOException {

        NestedBookingPojo bookings = bookingActions.getBookings();
        JSONObject addedJsonObject = context.getJSON();

        boolean isAdded = false;
        String firstName = addedJsonObject.getString("firstName");
        String lastName = addedJsonObject.getString("lastName");

        for(Booking booking : bookings.get_embedded().getBookingList()) {

            if(booking.getFirstName() == firstName && booking.getLastName() == lastName) {
                isAdded = true;
            }

        }

        Assertions.assertFalse(isAdded);

    }

    @Then("the user should have that booking list in less than {int} ms")
    public void the_user_should_have_that_booking_list_in_less_than_ms(int responseTime) throws IOException {

        long responseTimeCaptured = context.getResponseTime();

        Assertions.assertTrue(responseTimeCaptured < responseTime);

    }
    
    @Then("the user should have an updated booking id {int}")
    public void the_user_should_have_an_updated_booking(int id) {

        Booking updatedBooking = context.getBooking();
        JSONObject json = context.getJSON();

        Assertions.assertEquals(json.getString("firstName").toString(), updatedBooking.getFirstName().toString());
        Assertions.assertEquals(json.getString("lastName").toString(), updatedBooking.getLastName().toString());

    }

    @Then("the user should have an updated booking")
    public void the_user_should_have_an_updated_booking() {

        Booking updatedBooking = context.getBooking();
        JSONObject json = context.getJSON();

        Assertions.assertEquals(json.getString("firstName").toString(), updatedBooking.getFirstName().toString());
        Assertions.assertEquals(json.getString("lastName").toString(), updatedBooking.getLastName().toString());    
    
    }

}