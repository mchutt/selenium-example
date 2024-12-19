package com.solvd.example.web.automationwebpage.components;

import com.solvd.example.web.utils.AbstractComponent;
import com.solvd.example.web.utils.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginFormComponent extends AbstractComponent {

    @FindBy(xpath = ".//input[@data-qa='login-email']")
    private WebElement emailInput;

    @FindBy(xpath = ".//input[@name='password']")
    private WebElement passwordInput;

    @FindBy(xpath = ".//button[@data-qa='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = ".//p[text()='Your email or password is incorrect!']")
    private WebElement emailOrPasswordIncorrectMessage;

    public LoginFormComponent(WebElement root) {
        super(root);
    }

    public void typeInEmailInput(String email){
        emailInput.sendKeys(email);
    }

    public void typeInPasswordInput(String pass){
        passwordInput.sendKeys(pass);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }

    public boolean isErrorMessageVisible(){
        Wait<WebDriver> wait = new WebDriverWait(WebDriverProvider.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(emailOrPasswordIncorrectMessage));

        return emailOrPasswordIncorrectMessage.isDisplayed();
    }
}
