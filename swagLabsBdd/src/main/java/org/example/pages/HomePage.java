package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HomePage extends BasePage{

    @FindBy(id = "react-burger-menu-btn")
    private WebElement sidebarMenuButton;
    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;
    @FindBy(className = "product_sort_container")
    private WebElement sortDropDown;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(sidebarMenuButton));
        sidebarMenuButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();
    }

    private List<WebElement> getAllSortOptions() {
        Select select = new Select(sortDropDown);
        return select.getOptions();
    }

    public void clickSortProducts(String option) {
        List<WebElement> allOptions = getAllSortOptions();
        allOptions.stream()
                .filter(webElement -> webElement.getText().equals(option))
                .findFirst()
                .ifPresent(WebElement::click);
    }

    public List<String> getProductsSortedInReverseOrder(String info) {
        List<String> names = new ArrayList<>();
        List<String> prices = new ArrayList<>();
        extractProductInfo(info, names, prices);

        if (!prices.isEmpty()) {
            List<String> sortedPrices = prices.stream()
                    .map(Double::parseDouble)
                    .sorted(Comparator.reverseOrder())
                    .map(String::valueOf)
                    .toList();
            System.out.println(sortedPrices);
            return sortedPrices;
        }

        names.sort(Collections.reverseOrder());
        System.out.println(names);
        return names;
    }

    public List<String> getProductsSortedInAscOrder(String info) {
        List<String> names = new ArrayList<>();
        List<String> prices = new ArrayList<>();
        extractProductInfo(info, names, prices);

        if (!prices.isEmpty()) {
            List<String> sortedPrices = prices.stream()
                    .map(Double::parseDouble)
                    .sorted(Comparator.naturalOrder())
                    .map(String::valueOf)
                    .toList();
            System.out.println(sortedPrices);
            return sortedPrices;
        }

        names.sort(Comparator.naturalOrder());
        System.out.println(names);
        return names;
    }

    public List<String> getProductInfo(String info) {
        List<String> names = new ArrayList<>();
        List<String> prices = new ArrayList<>();
        extractProductInfo(info, names, prices);

        System.out.println(prices.isEmpty() ? names : prices);
        return prices.isEmpty() ? names : prices;
    }

    private void extractProductInfo(String info, List<String> names, List<String> prices) {
        List<WebElement> products = driver.findElements(By.className(info));
        for (WebElement product : products) {
            String text = product.getText();
            if (text.contains("$")) {
                prices.add(text.substring(1));
            } else {
                names.add(text);
            }
        }
    }

    public List<WebElement> getProducts(){
        return driver.findElements(By.className("inventory_item_name"));
    }
}
