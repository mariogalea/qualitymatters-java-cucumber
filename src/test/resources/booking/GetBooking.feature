Feature: GET Booking

  Background:
    Given a bookings list is available

  Scenario: GET Booking list
    When the user retrieves booking list
    Then the user should have a list of all bookings

  Scenario: GET Booking list by id
    When the user retrieves booking by id
    Then the user should have the specified booking