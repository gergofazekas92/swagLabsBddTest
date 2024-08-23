package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.github.cdimascio.dotenv.Dotenv;
import org.example.pages.HomePage;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogoutStepDefinition {
    private final Dotenv dotenv = Dotenv.load();
    private final HomePage homePage = Hook.getHomePage();
    private final WebDriver driver = Hook.getDriver();

    @And("I click on the logout")
    public void iClickOnTheLogout() {
        homePage.logout();
    }

    @Then("I should be redirected to the login page")
    public void iShouldBeRedirectedToTheLoginPage() {
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = dotenv.get("LOGIN_URL");

        System.out.println("logout done Im on the" + actualUrl + "page");
        assertEquals(expectedUrl, actualUrl);
    }
}
