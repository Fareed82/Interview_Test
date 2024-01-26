Feature: As an admin I want to update front-end information
  @ui @wip
  Scenario: Update information in admin panel
    When I am logged in as an admin and go to "Branding" module
    Then I click and change the information for all of the details
    And validate the information has been updated
    Then I return to homepage and validate information has been update on UI
