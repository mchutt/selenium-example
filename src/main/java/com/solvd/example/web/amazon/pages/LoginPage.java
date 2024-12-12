package com.solvd.example.web.amazon.pages;

import com.solvd.example.web.utils.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractBasePage {

    @FindBy(css = "#auth-error-message-box")
    private WebElement errorMessage;

    @FindBy(css = "#ap_email")
    private WebElement emailInput;

    @FindBy(css = "#continue")
    private WebElement continueButton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void typeEmail(String email){
        sendKeysToElement(emailInput, email);
    }
    public void clickOnContinueButton(){
        clickElement(continueButton);
    }
    public boolean isErrorMessagePresent(){
        return errorMessage.isDisplayed();
    }
}
