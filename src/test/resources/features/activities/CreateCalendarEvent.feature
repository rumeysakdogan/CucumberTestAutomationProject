@calendar_events
Feature: As a user, I want to be able to create calendar events

  Background:
    Given user is on the login page

    @smoke
  Scenario: Create calendar event with default time

    And user logs in as "store manager"
    And user navigates to "Activities" and "Calendar Events"
    And user clicks on create calendar event button
    When user adds new calendar event information
      | Title          | B20 Graduation Party  						 |
      | Description    | All B20 friends are invited for this party! |
    And user clicks on save and close button
    Then user verifies that new calendar event is displayed:
      | Title       | B20 Graduation Party                        |
      | Description | All B20 friends are invited for this party! |
