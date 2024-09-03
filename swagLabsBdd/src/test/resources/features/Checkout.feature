Feature: Checkout is working correctly
  As a registered User
  I want to check out
  So that I can finish shopping.

  Scenario: Checkout with product in the cart
    Given I am on the home page
      And I add one product to the cart
    When I click on the checkout button
      And I fill the inputs fields
      And I confirm the purchase
    Then Confirmation message show up
