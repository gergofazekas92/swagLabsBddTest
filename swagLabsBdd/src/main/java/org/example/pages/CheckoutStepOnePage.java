package org.example.pages;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepOnePage extends BasePage{

    private final Dotenv dotenv = Dotenv.load();
    @FindBy(id = "first-name")
    private WebElement firstNameInput;
    @FindBy(id = "last-name")
    private WebElement lastNameInput;
    @FindBy(id = "postal-code")
    private  WebElement zipInput;
    @FindBy(id = "continue")
    private WebElement continueButton;

    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickContinueButton(){
        continueButton.click();
    }

    public void fillInputFields(){
        firstNameInput.sendKeys(dotenv.get("FIRSTNAME"));
        lastNameInput.sendKeys(dotenv.get("LASTNAME"));
        zipInput.sendKeys((dotenv.get("ZIPCODE")));
    }
}
