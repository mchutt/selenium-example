package com.solvd.example.web.automationwebpage.pages;

import com.solvd.example.web.utils.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentDonePage extends AbstractBasePage {

    @FindBy(xpath = "//p[text()='Congratulations! Your order has been confirmed!']")
    private WebElement confirmedOrderMessage;

    public PaymentDonePage(WebDriver driver) {
        super(driver);
    }

    public boolean isConfirmedOrderMessageDisplayed() {
        return confirmedOrderMessage.isDisplayed();
    }
}
