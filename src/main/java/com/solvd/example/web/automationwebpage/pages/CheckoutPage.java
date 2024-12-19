package com.solvd.example.web.automationwebpage.pages;

import com.solvd.example.web.utils.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends AbstractBasePage {

    @FindBy(xpath = "//a[text()='Place Order']")
    private WebElement placeOrderButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public PaymentPage clickOnPlaceOrderButton(){
        scrollToElement(placeOrderButton);
        clickElement(placeOrderButton);
        return new PaymentPage(driver);
    }
}
