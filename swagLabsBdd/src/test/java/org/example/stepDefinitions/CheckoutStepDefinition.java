package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.github.cdimascio.dotenv.Dotenv;
import org.example.pages.CartPage;
import org.example.pages.CheckoutCompletePage;
import org.example.pages.CheckoutStepOnePage;
import org.example.pages.CheckoutStepTwoPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutStepDefinition {

    private final Dotenv dotenv = Dotenv.load();
    private final CartPage cartPage = Hook.getCartPage();
    private final CheckoutStepOnePage checkoutStepOnePage = Hook.getCheckoutStepOnePage();
    private final CheckoutStepTwoPage checkoutStepTwoPage = Hook.getCheckoutStepTwoPage();
    private final CheckoutCompletePage checkoutCompletePage = Hook.getCheckoutCompletePage();
    private final WebDriverWait wait = Hook.getWait();

    @And("I click on the checkout button")
    public void iClickOnTheCheckoutButton() {
        cartPage.clickCheckoutButton();
    }

    @And("I fill the inputs fields")
    public void iFillTheInputsFields() {
        wait.until(ExpectedConditions.urlToBe(dotenv.get("CHECKOUT_STEP_ONE_PAGE")));
        checkoutStepOnePage.fillInputFields();
        checkoutStepOnePage.clickContinueButton();
    }

    @And("I confirm the purchase")
    public void iConfirmThePurchase() {
        wait.until(ExpectedConditions.urlToBe(dotenv.get("CHECKOUT_STEP_TWO_PAGE")));
        checkoutStepTwoPage.clickFinishButton();
    }

    @Then("Confirmation message show up")
    public void confirmationMessageShowUp() {
        wait.until(ExpectedConditions.urlToBe(dotenv.get("CHECKOUT_COMPLETE_PAGE")));

        assertTrue(checkoutCompletePage.completeMessageIsVisible());
    }
}
