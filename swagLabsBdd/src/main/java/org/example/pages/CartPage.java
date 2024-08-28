package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage{

    @FindBy(className = "inventory_item_name")
    private List<WebElement> cartProducts;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<String> getCartProductNames(){
        List<String> names = new ArrayList<>();
        for (WebElement product : cartProducts){
            names.add(product.getText());
        }
        System.out.println(names.getFirst());
        return names;
    }
}
