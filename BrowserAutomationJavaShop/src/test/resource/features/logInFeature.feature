Feature: This is a log in feature checks if I am able to log in with correct email & password

  Background: 
    Given I am on the main page

  Scenario: Log in scenario
    And I click on the log in button
    When I put email and password
      | Fields   | Value           |
      | EMAIL    | test33@onet.com |
      | PASSWORD | password123     |
    And I click signIn button
    Then I should be on my account page
