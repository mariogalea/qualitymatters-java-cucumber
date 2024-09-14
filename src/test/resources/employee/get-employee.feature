Feature: GET Employee

  Scenario: GET Employee list
    Given an employee list is available
    When the user retrieves the employee list
    Then the user should have a list of all employees

  Scenario: GET Employee list by id
    Given an employee list is available
    When the user retrieves the employee list by id 100
    Then the user should have employee with requested id 100