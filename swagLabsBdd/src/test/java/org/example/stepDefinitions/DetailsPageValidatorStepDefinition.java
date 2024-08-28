package org.example.stepDefinitions;

import io.cucumber.java.en.Then;
import io.github.cdimascio.dotenv.Dotenv;
import org.example.pages.DetailsPage;
import org.example.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DetailsPageValidatorStepDefinition {
    private final Dotenv dotenv = Dotenv.load();
    private final WebDriverWait wait = Hook.getWait();
    private final WebDriver driver = Hook.getDriver();
    private final DetailsPage detailsPage = Hook.getDetailsPage();
    private final HomePage homePage = Hook.getHomePage();

    private final String homeUrl = dotenv.get("HOME_URL");


    @Then("I click on a product so i can see more details")
    public void iClickOnAProductSoICanSeeMoreDetails() {
        List<WebElement> products = homePage.getProducts();
        boolean rightDetails = false;
        for (int i = 0; i < products.size(); i++) {
            WebElement product = products.get(i);
            String productName = product.getText();
            System.out.println(productName);

            product.click();
            String productDetailsName = detailsPage.getProductName();
            System.out.println(productDetailsName);

            if (productName.equals(productDetailsName)) {
                rightDetails = true;
            } else {
                System.out.println("invalid details:" + productName);
                break;
            }

            driver.navigate().back();
            wait.until(ExpectedConditions.urlToBe(homeUrl));

            products = homePage.getProducts();
        }
        assertTrue(rightDetails);
    }
}
