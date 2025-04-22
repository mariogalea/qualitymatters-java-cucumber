@booking
Feature: Booking

  Background:
    Given a bookings list is available
  
  @functional
  Scenario: GET Booking list
    When the user retrieves booking list
    Then the user should have a list of all bookings
  
  @functional
  Scenario: GET Booking by id
    When the user retrieves booking id 3
    Then the user should have booking id 3
  
  @functional
  Scenario: Update Booking by id
    When the user updates booking id 4
    Then the user should have an updated booking id 4
  
  @functional
  Scenario: Update Booking by id
    When the user updates booking with the following
    |id|firstName|lastName|
    |5 |Jimmy    |Page    |
    Then the user should have an updated booking
  
  @functional
  Scenario: Add Booking
    When the user adds a new booking
    Then the user should have an updated booking list 

  @functional
  Scenario Outline: Add Multiple bookings
    When the user adds booking with '<firstName>' and '<lastName>'
    Then the user should have an updated booking list

    Examples:
    |firstName|lastName|
    |Robert   |Plant   |
    |John Paul|Jones   |
    |John     |Bonham  |
    |Peter    |Grant   |
  
  @functional
  @reboot
  Scenario: Delete Booking by id
    And booking id 5 is available 
    When the user deletes booking by id 5
    Then the user should not have booking id 5

  @performance
  Scenario: Measure Booking Response Time
    When the user retrieves booking list
    And the response time is captured
    Then the user should have that booking list in less than 10 ms