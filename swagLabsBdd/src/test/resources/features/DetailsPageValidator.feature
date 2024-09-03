Feature: Details page show valid information
  As a registered User
  I want to see every product on its own page
  So that I can get detailed information on the product.

    Scenario: Details page show valid information
      Given I am on the login page
      When I log in with valid username and password
      Then I click on a product so i can see more details