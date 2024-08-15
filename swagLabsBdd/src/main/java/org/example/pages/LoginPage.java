package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(id = "user-name")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;
    @FindBy(xpath = "//div[@class = 'error-message-container error']")
    private WebElement loginErrorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

}
