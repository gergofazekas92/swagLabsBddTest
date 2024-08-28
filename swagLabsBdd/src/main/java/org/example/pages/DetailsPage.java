package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailsPage extends BasePage{

    @FindBy(xpath = "//*[contains(@class, 'inventory_details_name') and contains(@class, 'large_size')]")
    private WebElement productName;
    public DetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getProductName(){
        return productName.getText();
    }
}
