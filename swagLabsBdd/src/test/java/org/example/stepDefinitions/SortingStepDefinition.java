package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortingStepDefinition {

    private final HomePage homePage = Hook.getHomePage();
    private final LoginPage loginPage = Hook.getLoginPage();
    private final String validUsername = System.getenv("STANDARD_USER");
    private final String validPassword = System.getenv("PASSWORD");
    private static final String LOGIN_URL = "https://www.saucedemo.com/";

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        loginPage.navigateToUrl(LOGIN_URL);
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
