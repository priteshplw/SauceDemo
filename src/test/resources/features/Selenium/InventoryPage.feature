@UITest
Feature: Swag Labs Inventory page validation

  Background: User Navigate to Swag Lab Inventory Page
    When User enter the valid URL for Swag Lab application
    And User enters the username as "standard_user"
    And User enters the password as "secret_sauce"
    And User clicks on the login button

  Scenario: Validate Swag Lab Inventory Page
    When User is on Inventory Page
    Then Swag Lab logo should be visible on the top of the page
    And User should see Cart Icon on top right of the page
    And User should see Navigation Menu on top left of the page
    And User Should see the "PRODUCTS" Title text above product inventory
    And User should be able to see inventory products in page
    And User should see the 3 Social media icons in page footer
    And User should see the footer copyright text
    And User should see robo image in right side of footer

  Scenario: Validate All the products in page
    When User is on Inventory Page
    Then User should be able to see below Product titles and price in the page
    And All the Product Images should be visible
    And Product description should be visible for all the products
    And Product add to cart CTA should be visible for all products

#  Scenario Outline: Validate product details page
#    When User is on Inventory Page
#    And User clicks on the "<Product Title>"
#    Then User lands on the Product details page
#    And User should see Product Image in the page
#    And User validates Product Title as "<Product Title>" in PDP Page
#    And User validates Description as "<Description>" in PDP Page
#    And User validates the Price as <Price> in PDP Page
#    Examples:
#      | Product Title | Price | Description |
#      | Product1   | 123   | Description |
#      | Product2   | 133   | Description2 |
#
