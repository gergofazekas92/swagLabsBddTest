package org.example.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.pages.CartPage;
import org.example.pages.DetailsPage;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
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

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        detailsPage = new DetailsPage(driver);
        cartPage = new CartPage(driver);
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
}
