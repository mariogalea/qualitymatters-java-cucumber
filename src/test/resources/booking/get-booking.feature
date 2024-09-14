Feature: GET Booking

  Scenario: GET Booking list
    Given a bookings list is available
    When the user retrieves booking list
    Then the user should have a list of all bookings

  Scenario: GET Booking list by id
    Given a bookings list is available
    When the user retrieves booking id 100
    Then the user should have booking id 10