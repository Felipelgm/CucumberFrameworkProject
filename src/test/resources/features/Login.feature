
Feature: User Story - Login Validation for HRMS Portal

  Background:
    Given the user is on the login page

  Scenario: Empty user name field
    When user attempts to log in with an empty username field
    And user clicks on login button
    Then user see the system error message "Username cannot be empty."

  Scenario: Empty password field
    When user attempts to log in with an empty password field
    And user clicks on login button
    Then user see the system error message "Password is empty."

  Scenario: Incorrect login credentials
    When user attempts to log in with incorrect credentials
    And user clicks on login button
    Then user see the system error "Invalid credentials"

  Scenario: User corrects input after error message and logs in successfully
    When user attempts to log in with incorrect credentials
    And user clicks on login button
    Then user see the system error "Invalid credentials"
    When user corrects credentials and logs in again
    Then user is successfully logged in