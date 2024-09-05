package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginStepDefinition {

    private final String validUsername = System.getenv("STANDARD_USER");
    private final String validPassword = System.getenv("PASSWORD");
    private static final String LOGIN_URL = "https://www.saucedemo.com/";
    private static final String HOME_URL = "https://www.saucedemo.com/inventory.html";
    private final LoginPage loginPage = Hook.getLoginPage();
    private final WebDriver driver = Hook.getDriver();

    @Given("I am on the login page")
    public void IAmOnTheLoginPage(){loginPage.navigateToUrl(LOGIN_URL);}

    @When("I log in with valid username and password")
    public void ILogInWithValidUsernameAndPassword(){
        loginPage.login(validUsername, validPassword);
        System.out.println("logged in");
    }

    @When("I log in with {string} as invalid username and {string} as password")
    public void ILogInWithInvalidUsernameAndPassword(String username, String password){
        loginPage.login(username, password);
    }

    @Then("I should be redirected to the home page")
    public void iShouldBeRedirectedToTheHomePage(){
        String actualUrl = driver.getCurrentUrl();

        System.out.println("Im on:" + actualUrl);
        assertEquals(HOME_URL, actualUrl);
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String errorMessage) {
        String actualErrorMessage = loginPage.getErrorMessage();

        System.out.println(actualErrorMessage);
        assertEquals(errorMessage, actualErrorMessage);
    }
}
