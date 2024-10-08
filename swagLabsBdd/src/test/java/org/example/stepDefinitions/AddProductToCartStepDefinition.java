package org.example.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.CartPage;
import org.example.pages.HomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddProductToCartStepDefinition {

    private final HomePage homePage = Hook.getHomePage();
    private final CartPage cartPage = Hook.getCartPage();
    private final WebDriverWait wait = Hook.getWait();
    private List<String> productName = new ArrayList<>();
    private static final String CART_PAGE = "https://www.saucedemo.com/cart.html";

    @When("I add one product to the cart")
    public void iAddOneProductToTheCart() {
        homePage.addBackpackToCart();
        productName.add(homePage.getBackpackText());
        homePage.openCartPage();
    }

    @Then("The product show in the cart")
    public void theProductShowInTheCart() {
        wait.until(ExpectedConditions.urlToBe(CART_PAGE));

        List <String> productNameInCart = cartPage.getCartProductNames();

        System.out.println(productName);

        assertEquals(productName, productNameInCart);
    }

    @When("I add two product to the cart")
    public void iAddTwoProductToTheCart() {
        homePage.addBackpackAndBikeLightToCart();
        productName = homePage.getBackpackAndBikeLightText();
        homePage.openCartPage();
    }
}
