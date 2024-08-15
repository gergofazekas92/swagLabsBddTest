Feature: User Login
  As a registered user
  I want to be able to log in to my account
  So that I can use the web shop

  Scenario : Successful Login
    Given I am on the login page
    When I log in with valid username and password
    Then I should be redirected to the home page

  Scenario Outline: Login with invalid credentials
    Given I am on the login page
    When I enter username "<username>", password "<password>" and I click the login button
    Then I should see an error message "<error>"

    Examples:
      | username        | password    | error                             |
      | NON_EXISTING_USER | PASSWORD | Epic sadface: Username and password do not match any user in this service |
      | LOCKED_OUT_USER   | PASSWORD | Epic sadface: Sorry, this user has been locked out.|