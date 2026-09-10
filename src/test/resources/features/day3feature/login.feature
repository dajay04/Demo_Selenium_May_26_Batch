@Sanity @SmokeTest
Feature: Login Functionality test

  Background:
    Given user navigated to login page of orange portal

  @SmokeTest
  Scenario: Valid user login
    When user enters username as "Admin" and password as "admin123"
    Then user should be redirected to the dashboard page

    @SanityTest @Regression @Integration @AGE-535
  Scenario Outline: Invalid user login test
    When user enters username as "<user>" and password as "<pass>"
    Then user verifies error message as "Invalid credentials"

    Examples:
      | user  | pass     |
      | ajay  | admin123 |
      | Admin | asdasd   |
      | asds  | asdas    |

