package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private static final String LOGIN_URL = "https://www.saucedemo.com/";
    private static final int WAIT_DURATION = 5;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_DURATION));
    }

    protected void navigateToLoginPage(){driver.get(LOGIN_URL);}

}
