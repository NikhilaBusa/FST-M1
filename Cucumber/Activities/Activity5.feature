@activity5
Feature: Login test
 Scenario Outline: Testing Login with Examples
    Given User is on Login page
    When User enters "<Username>" and "<Password>"
    Then Read the page title and confirmation message
    And Close the Browser
   Examples:
   | Username | Password |
   | admin| password|
   | some | password|