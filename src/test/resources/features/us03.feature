Feature: As a user, I want to retrieve all bookings
  @api @us03
  Scenario: Retrieve all bookings from the API endpoint

    Given I am connected to API
    When I send GET request to "/booking" endpoint
    Then status code should be 200
    And Response Content type is "application/json; charset=utf-8"
    And "bookingid" should not be null