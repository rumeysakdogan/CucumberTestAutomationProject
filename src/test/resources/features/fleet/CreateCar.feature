Feature: As user, I want to be able to create new cars

  @add_car @smoke
  Scenario: 1. Add some car
    Given user is on the login page
    And  user logs in as "store manager"
    And user navigates to "Fleet" and "Vehicles"
    And user clicks on create car button
    When user adds new vehicle information
      | Licence Plate | SDET |
      | Model Year    | 2021 |
    And user clicks on save and close button


  @add_car_scenario_outline
  Scenario Outline: 1. Add some car for <licence plate>
    Given user is on the login page
    And  user logs in as "store manager"
    And user navigates to "Fleet" and "Vehicles"
    And user clicks on create car button
    When user adds new vehicle information
      | Licence Plate | <licence plate> |
      | Model Year    | <model year>    |
    And user clicks on save and close button

    Examples: test data
      | licence plate | model year |
      | FLORIDA       | 2020       |
      | QA            | 2021       |
      | RAMAZAN       | 2030       |
      | SDET          | 1999       |
