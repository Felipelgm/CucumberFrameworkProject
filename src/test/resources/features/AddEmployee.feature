
Feature: Add Employee to HRMS

  Background:
    Given the user is on the login page
    When user enters valid username and password
    And user clicks on login button
    Then user is able to login successfully


  Scenario: Add a new employee WITHOUT providing an Employee ID
    When user clicks on PIM option
    And user clicks on Add Employee button
    When user enters first name "Aleks" and middle name "Vasic" and last name "Marques"
    And user clears the employee id field
    And user clicks on save button
    Then employee is added successfully
    And user verifies employee is visible in the personal details page


  Scenario: Add a new employee WITH a custom Employee ID
    When user clicks on PIM option
    And user clicks on Add Employee button
    When user enters first name "Test" and middle name "QA" and last name "User"
    And user enters a custom employee id "99999"
    And user clicks on save button
    Then employee is added successfully
    And user verifies employee ID "99999" is saved correctly


  Scenario: Validate error messages when required fields are missing
    When user clicks on PIM option
    And user clicks on Add Employee button
    And user leaves first name empty
    And user fills only last name "Marques"
    And user clicks on save button
    Then user should see required error under first name field
