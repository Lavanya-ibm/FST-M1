Feature: Basic syntax for cucumber files
  Scenario: This is scenario 1
    Given User is on TS homepage
    When User clicks about us button
    Then About Us page should open
    And Close the browser
