@Sanity
Feature: Login Functionality test with Map

  @SanityTest @Regression @Integration @AGE-535
  Scenario: Invalid user login test with Map
    Given user navigated to login page of orange portal
    When user enters username and password as Map:
      | user  | pass     |
      | ajay  | admin123 |
      | Admin | asdasd   |
      | asds  | asdas    |
    Then user verifies error message as "Invalid credentials"