package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.cdimascio.dotenv.Dotenv;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortingStepDefinition {

    private final Dotenv dotenv = Dotenv.load();
    private final HomePage homePage = Hook.getHomePage();
    private final LoginPage loginPage = Hook.getLoginPage();
    private final String validUsername = dotenv.get("STANDARD_USER");
    private final String validPassword = dotenv.get("PASSWORD");
    private final String loginUrl = dotenv.get("LOGIN_URL");

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        loginPage.navigateToUrl(loginUrl);
        loginPage.login(validUsername, validPassword);
    }

    @When("I select the {string} of sorting")
    public void iSelectTheDirectionOfSorting(String type) {
        homePage.clickSortProducts(type);
    }


    @Then("I see the products sorted in descending order by {string}")
    public void iSeeTheProductsSortedInDescendingOrderByGivenParameter(String itemParameter) {
        List<String> sortedProductInfos = homePage.getProductsSortedInReverseOrder(itemParameter);
        List<String> productInfosOnHomePage = homePage.getProductInfo(itemParameter);

        assertEquals(sortedProductInfos, productInfosOnHomePage);
    }

    @Then("I see the products sorted in ascending order by {string}")
    public void iSeeTheProductsSortedInAscendingOrderBy(String itemParameter) {
        List<String> sortedProductInfos = homePage.getProductsSortedInAscOrder(itemParameter);
        List<String> productInfosOnHomePage = homePage.getProductInfo(itemParameter);

        assertEquals(sortedProductInfos, productInfosOnHomePage);
    }
}
