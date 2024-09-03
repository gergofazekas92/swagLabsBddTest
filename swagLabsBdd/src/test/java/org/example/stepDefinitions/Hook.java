package org.example.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Hook {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static LoginPage loginPage;
    private static HomePage homePage;
    private static DetailsPage detailsPage;
    private static CartPage cartPage;
    private static CheckoutStepOnePage checkoutStepOnePage;
    private static CheckoutStepTwoPage checkoutStepTwoPage;
    private static CheckoutCompletePage checkoutCompletePage;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        detailsPage = new DetailsPage(driver);
        cartPage = new CartPage(driver);
        checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    public static WebDriver getDriver() { return driver; }

    public static WebDriverWait getWait() { return wait; }

    public static LoginPage getLoginPage() {
        return loginPage;
    }

    public static HomePage getHomePage() { return homePage; }

    public static DetailsPage getDetailsPage(){ return detailsPage; }
    public static CartPage getCartPage() { return cartPage; }

    public static CheckoutStepOnePage getCheckoutStepOnePage() { return checkoutStepOnePage; }

    public static CheckoutStepTwoPage getCheckoutStepTwoPage() { return checkoutStepTwoPage; }

    public static CheckoutCompletePage getCheckoutCompletePage() { return checkoutCompletePage; }
}
