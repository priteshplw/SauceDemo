@UITest
Feature: Swag Lab Login or Landing page validations

  Background: User Navigates to the Swag Lab Login or Landing Page
    When User enter the valid URL for Swag Lab application
    Then User should be navigated to the Swag Lab Login or Landing page

  Scenario: Validate login page for the Swag Lab Applications
    When User is on the Swag Lab Login or Landing page
    Then Login Page Swag Lab logo visible on the top of the page
    And User Name and Password field should be visible in page
    And Login button should be visible in the page
    And Robo picture should be visible in the page
    And Accepted User name labels are visible in the page
    And Accepted password labels are visible in page

  Scenario: User should be logged in successfully if valid credentials are entered
    When User is on the Swag Lab Login or Landing page
    And User enters the username as "standard_user"
    And User enters the password as "secret_sauce"
    And User clicks on the login button
    Then User should be logged in successfully


  Scenario: User login should be failed if invalid credentials are entered
    When User is on the Swag Lab Login or Landing page
    And User enters the username as "locked_out_user"
    And User enters the password as "incorrect_pass"
    And User clicks on the login button
    Then Login should fail and error message is displayed as "Epic sadface: Username and password do not match any user in this service"

  Scenario: Validate if user not allowed to login if account is locked
    When User is on the Swag Lab Login or Landing page
    And User enters the username as "locked_out_user"
    And User enters the password as "secret_sauce"
    And User clicks on the login button
    Then Login should fail and error message is displayed as "Epic sadface: Sorry, this user has been locked out."

