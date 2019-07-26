Feature: This is a check item price feature checks if the total price with shipping is correct

  Background: 
    Given I am on the main page

  Scenario: Check Item Price
    When I pick blouse category and pick the item
    And I choose quantity and size of the item
    And I add the item to cart
    Then I check if Total price with shipping is correct
