Feature: This is a sign in feature checks if I am able to create a new account

  Background: 
    Given I am on the main page

  Scenario: Sign in scenario
    And I click on the log in button
    When I fill email address
      | Fields | Value          |
      | EMAIL  | test30066@onet.com|
    And I click create an account button
    And I submit the form with valid data
      | Fields        | Value         |
      | Name          | TOMASZ        |
      | SURNAME       | KOWALSKI      |
      | PASSWORD      | password123   |
      | DAYS_VALUE    |            19 |
      | MONTH VALUE   |             2 |
      | YEAR_VALUE    |          1990 |
      | COMPANY       | SOFLAB        |
      | STREET        | JEROZOLIMSKIE |
      | CITY          | WARSZAWA      |
      | STATE_VALUE   |             2 |
      | ZIP_CODE      |         00023 |
      | COUNTRY_VALUE |            21 |
      | PHONE         |   00574345334 |
      | MOBILE        | 555 666 897   |
    And I set alias
      | Fields | Value    |
      | ALIAS  | NEWALIAS |
    And I submit new account
    Then I should be on my account page
