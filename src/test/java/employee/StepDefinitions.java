package employee;

import io.cucumber.java.en.*;

public class StepDefinitions {


    @Given("an employee list is available")
    public void anEmployeeListIsAvailable() {
    }

    @When("the user retrieves the employee list by id {int}")
    public void theUserRetrievesTheEmployeeListById(int id) {

        id = 100;
    }

    @When("the user retrieves the employee list")
    public void theUserRetrievesTheEmployeeList() {
    }

    @Then("the user should have a list of all employees")
    public void theUserShouldHaveAListOfAllEmployees() {
    }

    @Then("the user should have employee with requested id {int}")
    public void theUserShouldHaveEmployeeWithRequestedId(int id) {
        id = 100;
    }

}
