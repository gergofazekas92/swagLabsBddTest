Feature: User Login
  As a registered user
  I want to be able to log in to my account
  So that I can use the web shop

  Scenario Outline: Login with invalid credentials
    Given I am on the login page
    When I log in with "<username>" as invalid username and "<password>" as password
    Then I should see an error message "<error>"

    Examples:
      | username          | password | error                                                                     |
      | non_existing_user | secret_sauce | Epic sadface: Username and password do not match any user in this service |
      | locked_out_user   | secret_sauce | Epic sadface: Sorry, this user has been locked out.                       |

  Scenario:  Successfully Login
    Given I am on the login page
    When I log in with valid username and password
    Then I should be redirected to the home page