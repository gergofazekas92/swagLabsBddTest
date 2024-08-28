Feature: Add product to cart
  As a registered User
  I want to put products into the cart
  So that I can buy them.

  Scenario: Add one product to cart
    Given I am on the home page
    When I add one product to the cart
    Then The product show in the cart

  Scenario: Add multiple products to cart
    Given I am on the home page
    When I add two product to the cart
    Then The product show in the cart
