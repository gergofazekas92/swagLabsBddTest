package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepOnePage extends BasePage{

    @FindBy(id = "first-name")
    private WebElement firstNameInput;
    @FindBy(id = "last-name")
    private WebElement lastNameInput;
    @FindBy(id = "postal-code")
    private  WebElement zipInput;
    @FindBy(id = "continue")
    private WebElement continueButton;
    private static final String FIRSTNAME = "John";
    private static final String LASTNAME = "Doe";
    private static final String ZIPCODE = "1234";


    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickContinueButton(){
        continueButton.click();
    }

    public void fillInputFields(){
        firstNameInput.sendKeys(FIRSTNAME);
        lastNameInput.sendKeys(LASTNAME);
        zipInput.sendKeys(ZIPCODE);
    }
}
