package com.solvd.example.web.automationwebpage.pages;

import com.solvd.example.web.utils.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends AbstractBasePage {

    @FindBy(xpath = "//input[@name='name_on_card']")
    private WebElement nameOnCardInput;

    @FindBy(xpath = "//input[@name='card_number']")
    private WebElement cardNumberInput;

    @FindBy(xpath = "//input[@name='cvc']")
    private WebElement cvcInput;

    @FindBy(xpath = "//input[@name='expiry_month']")
    private WebElement expirationMonthInput;

    @FindBy(xpath = "//input[@name='expiry_year']")
    private WebElement expirationYearInput;

    @FindBy(css = "#submit")
    private WebElement confirmOrderbutton;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void typeInNameOnCardInput(String text) {
        sendKeysToElement(nameOnCardInput, text);
    }

    public void typeInCardNumberInput(String text) {
        sendKeysToElement(cardNumberInput, text);
    }

    public void typeInCVCInput(String text) {
        sendKeysToElement(cvcInput, text);
    }

    public void typeInExpirationMonthInput(String text) {
        sendKeysToElement(expirationMonthInput, text);
    }

    public void typeInExpirationYearInput(String text) {
        sendKeysToElement(expirationYearInput, text);
    }

    public PaymentDonePage clickOnConfirmOrderbutton(){
        scrollToElement(confirmOrderbutton);
        clickElement(confirmOrderbutton);
        return new PaymentDonePage(driver);
    }

}
