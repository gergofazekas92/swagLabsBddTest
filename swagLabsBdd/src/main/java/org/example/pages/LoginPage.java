package org.example.pages;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    private final Dotenv dotenv = Dotenv.load();
    @FindBy(id = "user-name")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;
    @FindBy(xpath = "//div[@class = 'error-message-container error']//h3")
    private WebElement loginErrorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void login(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        fillUsername(username);
        fillPassword(password);
        submitCredentials();
    }

    public boolean checkIfLogoutIsSuccessful() {
        return checkIfLoginPageIsShown();
    }

    private boolean checkIfLoginPageIsShown() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        return loginButton.isDisplayed();
    }

    private boolean checkIfErrorMessageIsShown() {
        wait.until(ExpectedConditions.visibilityOf(loginErrorMessage));
        return loginErrorMessage.isDisplayed();
    }

    private void fillUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.sendKeys(username);
    }

    private void fillPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
    }

    private void submitCredentials() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(loginErrorMessage));
        return loginErrorMessage.getText();
    }
}
