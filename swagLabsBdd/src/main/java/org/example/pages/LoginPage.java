package org.example.pages;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
    @FindBy(xpath = "//div[@class = 'error-message-container error']")
    private WebElement loginErrorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        driver.get(dotenv.get("BASE_URL"));
        System.out.println("Navigated to login page");
        fillUsername(username);
        fillPassword(password);
        submitCredentials();
    }

    public boolean checkIfLoginIsSuccessful() {
        wait.until(ExpectedConditions.visibilityOf(menuButton));
        return menuButton.isDisplayed();
    }

    public boolean checkIfLoginIsUnsuccessful() {
        wait.until(ExpectedConditions.visibilityOf(loginErrorMessage));
        return checkIfErrorMessageIsShown();
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

}
