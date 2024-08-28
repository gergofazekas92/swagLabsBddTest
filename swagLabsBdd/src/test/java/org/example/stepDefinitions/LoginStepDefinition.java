package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.cdimascio.dotenv.Dotenv;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

public class LoginStepDefinition {
    private final Dotenv dotenv = Dotenv.load();
    private final String validUsername = dotenv.get("STANDARD_USER");
    private final String validPassword = dotenv.get("PASSWORD");
    private final String loginUrl = dotenv.get("LOGIN_URL");
    private final LoginPage loginPage = Hook.getLoginPage();
    private final WebDriver driver = Hook.getDriver();

    @Given("I am on the login page")
    public void IAmOnTheLoginPage(){loginPage.navigateToUrl(loginUrl);}

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
        String homeUrl = dotenv.get("HOME_URL");

        System.out.println("Im on:" + actualUrl);
        assertEquals(homeUrl, actualUrl);
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String errorMessage) {
        String actualErrorMessage = loginPage.getErrorMessage();

        System.out.println(actualErrorMessage);
        assertEquals(errorMessage, actualErrorMessage);
    }
}
