package com.solvd.example.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceLoginPage extends AbstractBasePage{

    @FindBy(css = "#user-name")
    private WebElement userNameInput;
    @FindBy(css = "#password")
    private WebElement userPasswordInput;
    @FindBy(css = "#login-button")
    private WebElement loginButton;

    public SauceLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void typePassword(String pass) {
        userPasswordInput.sendKeys(pass);
    }

    public void typeUserName(String username) {
        userNameInput.sendKeys(username);
    }
    public SauceProductsPage clickOnLoginButton(){
        loginButton.click();
        return new SauceProductsPage(driver);
    }
}
