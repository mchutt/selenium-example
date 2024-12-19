package com.solvd.example.web.automationwebpage.pages;

import com.solvd.example.web.automationwebpage.components.ProductCardComponent;
import com.solvd.example.web.utils.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage extends AbstractBasePage {

    @FindBy(css = ".features_items .col-sm-4")
    private List<WebElement> productElementList;

    @FindBy(css = "#search_product")
    private WebElement searchInput;

    @FindBy(css = "#submit_search")
    private WebElement submitSearchButton;

    @FindBy(xpath = "//h2[text()='All Products']")
    private WebElement allProductsTitle;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void typeTextInSearchInput(String text) {
        sendKeysToElement(searchInput, text);
    }

    public void clickOnSubmitSearchButton() {
        clickElement(submitSearchButton);
    }

    public boolean isAllProductsTitleDisplayed(){
        return allProductsTitle.isDisplayed();
    }

    public List<ProductCardComponent> getProducts(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfAllElements(productElementList));

        return productElementList.stream()
                .map(ProductCardComponent::new)
                .collect(Collectors.toList());
    }

}
