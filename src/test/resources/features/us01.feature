Feature: Log in and validate the booking is displayed in the admin panel
  @ui @us01
  Scenario: Log in as an admin and check the booking

    Then I scroll down to the bottom of the page and click on Admin panel and Login
    When I click on the first available room reservation
    Then I click edit icon on the first booking
    And I change the first name, last name, deposit paid status, check in date, and check out date
    Then I click update and validate my booking information has been updated




