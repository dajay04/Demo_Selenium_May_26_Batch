@Sanity
Feature: Login Functionality test

  @SmokeTest @UITest
  Scenario: Valid user login
    Given user navigated to login page of orange portal
    When user enters username as "Admin" and password as "adjajbsbbasd"
    Then user should be redirected to the dashboard page

    @SanityTest @Regression @Integration @AGE-535
  Scenario Outline: Invalid user login test
      Given user navigated to login page of orange portal
    When user enters username as "<user>" and password as "<pass>"
    Then user verifies error message as "Invalid credentials"

    Examples:
      | user  | pass     |
      | dahiya  | admin123 |
      | Admin | asdasd   |
      | asds  | asdas    |

