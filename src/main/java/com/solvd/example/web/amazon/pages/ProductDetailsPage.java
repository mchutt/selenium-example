package com.solvd.example.web.amazon.pages;

import com.solvd.example.web.utils.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends AbstractBasePage {

    @FindBy(css = "#add-to-cart-button")
    private WebElement addToCartBtton;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddToCartButton(){
        clickElement(addToCartBtton);
    }
}
