package com.solvd.example.web.automationwebpage.pages;

import com.solvd.example.web.automationwebpage.components.AlertInProductDetailsComponent;
import com.solvd.example.web.utils.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends AbstractBasePage {


    @FindBy(xpath = "//button[@type='button']")
    private WebElement addToCartButton;

    @FindBy(className = "modal-content")
    private WebElement modal;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public AlertInProductDetailsComponent clickOnAddToCartButton(){
        addToCartButton.click();
        return new AlertInProductDetailsComponent(modal);
    }

}
