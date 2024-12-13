package com.solvd.example.web.amazon.components;

import com.solvd.example.web.amazon.pages.ProductDetailsPage;
import com.solvd.example.web.utils.AbstractComponent;
import com.solvd.example.web.utils.WebDriverProvider;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductCardComponent extends AbstractComponent {

    protected static Logger logger = LoggerFactory.getLogger(AbstractComponent.class);

    @FindBy(xpath = ".//a")
    private WebElement productDetailsButton;
    @FindBy(xpath = ".//span[@class='a-color-base']")
    private WebElement price; //US$144.95 format

    public ProductCardComponent(WebElement root) {
        super(root);
    }

    public ProductDetailsPage clickOnProductDetailsButton(){
        clickElement(productDetailsButton);
        return new ProductDetailsPage(WebDriverProvider.getDriver());
    }

    public double getClearPrice(){
        double clearPrice=-1.0;
        try {
            clearPrice = Double.parseDouble(price.getText().substring(1));
        }catch (NoSuchElementException ex){
            logger.warn("Price not found for this product card");
        }catch ( NumberFormatException ex){
            logger.warn("Something went wrong while formating price {}", ex.getMessage());
        }
        return clearPrice;

    }

}
