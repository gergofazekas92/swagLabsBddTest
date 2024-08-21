package org.example.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Hook {
    private static WebDriver driver;
    private static LoginPage loginPage;
    private static HomePage homePage;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    public static WebDriver getDriver() { return driver; }
    public static LoginPage getLoginPage() {
        return loginPage;
    }

    public static HomePage getHomePage() {
        return homePage;
    }
}
