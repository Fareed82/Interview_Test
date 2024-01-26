Feature: As a user, I want to create a new booking
@api @us04
  Scenario: Create a new booking API

    Given I am connected to API
    And I create a random booking as request body
    When I send POST request to "/booking" endpoint
    Then status code should be 200 for new booking
    And Response Content type is "application/json; charset=utf-8" for new booking
    And verify the new user has booking has been created