@APITEST
  @check
Feature: Create, update, read and delete single user details and List of user details

  Background: Build the request Base URL
    Given User have Base URL ready for execution

  Scenario: Validate per page user count for API
    Given Trigger ListUser API request
    When API returns "400" response
    Then Check whether per page user count is same as mentioned in the response

  Scenario: Validate if total user count returned is valid for API
    Given Trigger ListUser API request
    When API returns "200" response
    Then Check whether total users count is same as mentioned in the response

  Scenario: Check if total number of pages returned for API are valid
    Given Trigger ListUser API request
    When API returns "200" response
    Then Check whether total pages count is same as mentioned in the response

  Scenario Outline: Check if user details are being returned for valid user id
    Given Trigger ListUser API request with user id "<User ID>"
    When API returns "200" response
    Then User details should be returned in the response
    Examples:
      | User ID |
      | 1       |

  Scenario Outline: validate if no user data and error response is being returned for invalid user id
    Given Trigger ListUser API request with user id "<User ID>"
    When API returns "404" response
    Then User details should not be returned in the response
    Examples:
      | User ID |
      | 100     |

  Scenario Outline: Create user with valid details and check the success response
    Given User creates request payload with details "<user name>" and "<job>"
    And Trigger CreateUser API request
    When API returns "201" response
    Then User should be created successfully
    And Validate user name as "<user name>" and job details as "<job>" in api response
    And Validate if user creation date is today's
    Examples:
      | user name | job    |
      | user1     | tester |
#      | user2     | developer |

#  Scenario Outline: Create user with invalid details and check the failure response
#    Given User creates request payload with details "<user name>" and "<job>"
#    And Trigger ListUser API request
#    When API returns "201" success response
#    Then User should be created successfully
#    And Validate user name as "<user name>" and job details as "<job>" in api response
#    And Validate if user creation date is today's
#    Examples:
#      | user name | job       |
#      | user1     | tester    |
#      | user2     | developer |

  Scenario Outline: Update user details and validate the success response
    Given User creates request payload with details "<user name>" and "<job>"
    And Trigger UpdateUser API request with user id as "<User ID>"
    When API returns "200" response
    Then 2 mentioned detail should be updated successfully
    And Validate user name as "<user name>" and job details as "<job>" in api response
    And Validate if user updating date is today's
    Examples:
      | user name | job       | User ID |
      | user1     | tester    | 2       |
#      | user2     | developer | 3       |


  Scenario Outline: Update user name and validate the success response
    Given User creates request payload with user name as "<user name>"
    And Trigger UpdateUser API request to update specific detail for user id as "<User ID>"
    When API returns "200" response
    Then 1 mentioned detail should be updated successfully
    And Validate user name as "<user name>" in api response
    And Validate if user updating date is today's
    Examples:
      | user name | User ID |
      | user1     | 2       |
#      | user2     | 3|

  Scenario Outline: Update user job and validate the success response
    Given User creates request payload with job title as "<jobTitle>"
    And Trigger UpdateUser API request with user id as "<User ID>"
    When API returns "200" response
    Then 1 mentioned detail should be updated successfully
    And Validate user job as "<jobTitle>" in api response
    And Validate if user updating date is today's
    Examples:
      | jobTitle | User ID |
      | dev      | 2       |
#      | tester   | 3       |

  Scenario Outline: Delete valid user and validate the success response
    When Trigger DeleteUser API request for user id "<User ID>"
    Then API returns "204" response
    Examples:
      | User ID |
      | 1       |
#      | 2       |

#  Scenario: Delete invalid user and validate the failure response
#    When Trigger DeleteUser API request for user id "<User ID>"
#    Then API returns "204" success response
#    Examples:
#      | User ID |
#      | 1       |
#      | 2       |


