package org.example.pages;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected Dotenv dotenv = Dotenv.load();
    protected WebDriver driver;
    protected WebDriverWait wait;
    private static final int WAIT_DURATION = 5;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_DURATION));
    }

    public void navigateToUrl(String url){
        driver.get(url);
        System.out.println("Navigated to " + url);
        wait.until(ExpectedConditions.urlToBe(url));
    }
}
