@Sanity @SmokeTest
Feature: Dashboard Elements Visibility test

  Background:
    Given user navigated to login page of orange portal
    When user enters username as "Admin" and password as "admin123"
    Then user should be redirected to the dashboard page

  @SmokeTest
  Scenario: Dashboard Icons post login are appearing or not
    And User should see following dashboard menu items:
      | Admin       |
      | PIM         |
      | Leave       |
      | Time        |
      | Recruitment |

