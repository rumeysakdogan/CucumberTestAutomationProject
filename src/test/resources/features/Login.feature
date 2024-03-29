@login
Feature: As user I want to be able to login under different roles
  # highlight means: there is no code implementation related to this test scenario

  # Background - test precondition
  # will be executed before every scenario in the particular feature file
  Background: common steps
    Given user is on the login page

  Scenario: Login as a sales manager
    When user logs in
    Then user should see dashboard page

  @parametrized_test @smoke
  Scenario: Parametrized login
    When user logs in as "store manager"
    Then user should see dashboard page

  @parametrized_test @smoke_test @s_o
  Scenario Outline: Parametrized login as <role>
    When user logs in as "<role>"
    Then user should see dashboard page

    Examples:
      | role          |
      | sales manager |
      | store manager |


  @s_o  @with_two_columns
  Scenario Outline: Parametrized login as <role>
    When user logs in as "<role>"
    Then user should see "<page_title>" page

    Examples:
      | role          | page_title |
      | sales manager | Dashboard  |
      | store manager | Dashboard  |
      | driver        | Quick Launchpad  |

# role -> variable.You can name parameters as you want.
# 1st row always reserved for parameters
# auto formatting : command + option + L
# "driver" - is a parameter. "" allows to do test parametrization which helps to re-use test steps

  @negative_login @smoke
  Scenario: Invalid password
    When user logs in with "storemanager85" username and "wrong" password
    Then user verifies that "Invalid user name or password." message is displayed


  @negative_scenario_outline
  Scenario Outline: Invalid Login with <username> and <password>
    When user logs in with "<username>" username and "<password>" password
    Then user verifies that "<message>" message is displayed

    Examples: data set
      | username | password | message                        |
      | wrong    | bad      | Invalid user name or password. |
      | wrnog    | bad      | Invalid user name or password. |
