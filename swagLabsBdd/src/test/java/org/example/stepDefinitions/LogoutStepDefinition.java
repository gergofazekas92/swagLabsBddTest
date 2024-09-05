package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.pages.HomePage;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogoutStepDefinition {

    private final HomePage homePage = Hook.getHomePage();
    private final WebDriver driver = Hook.getDriver();
    private static final String LOGIN_URL = "https://www.saucedemo.com/";

    @And("I click on the logout")
    public void iClickOnTheLogout() {
        homePage.logout();
    }

    @Then("I should be redirected to the login page")
    public void iShouldBeRedirectedToTheLoginPage() {
        String actualUrl = driver.getCurrentUrl();

        System.out.println("logout done Im on the" + actualUrl + "page");
        assertEquals(LOGIN_URL, actualUrl);
    }
}
