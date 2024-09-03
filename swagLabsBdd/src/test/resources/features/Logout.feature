Feature: User Logout
  As a registered User
  I want to be able to logout from my account
  So others cannot order on my behalf

  Scenario: SuccessFully Logout
    Given I am on the login page
      And I log in with valid username and password
    When I should be redirected to the home page
      And I click on the logout
    Then I should be redirected to the login page