Feature: Fill out and submit a contact form
  @ui @us02
  Scenario: Fill out the contact form

    Given I am on the hotel homepage
    And I scroll down to the contact form
    Then I click on Submit without completing the form and validate error(s)
    Then I complete the form and validate success message
