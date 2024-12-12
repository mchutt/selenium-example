package com.solvd.example.web.sauce.pages;

import com.solvd.example.web.utils.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SauceLoginPage extends AbstractBasePage {

    @FindBy(css = "#user-name")
    private WebElement userNameInput;
    @FindBy(css = "#password")
    private WebElement userPasswordInput;
    @FindBy(css = "#login-button")
    private WebElement loginButton;

    public SauceLoginPage(WebDriver driver) {
        super(driver);
    }

    public void typePassword(String pass) {
        sendKeysToElement(userPasswordInput, pass);
    }

    public void typeUserName(String username) {
        sendKeysToElement(userNameInput, username);
    }

    public SauceProductsPage clickOnLoginButton(){
        clickElement(loginButton);
        return new SauceProductsPage(driver);
    }
}
