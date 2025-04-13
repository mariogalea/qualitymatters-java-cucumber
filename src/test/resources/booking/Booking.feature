Feature: Booking

  Background:
    Given a bookings list is available

  Scenario: GET Booking list
    When the user retrieves booking list
    Then the user should have a list of all bookings

  Scenario: GET Booking list by id
    When the user retrieves booking id 1
    Then the user should have booking id 1

  Scenario: Update Booking by id
    When the user updates booking id 1
    Then the user should have an updated booking id 1

  Scenario: Delete Booking by id
    And booking id 1 is available 
    When the user deletes booking by id 1
    Then the user should not have booking id 1

  Scenario: Add Booking
    When the user adds a new booking
    And the user retrieves booking list
    Then the user should have an updated booking list

  Scenario: Measure Booking Response Time
    When the user retrieves booking list
    Then the user should have that booking list in less than 200 ms