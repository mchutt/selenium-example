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

public class SignUpFormComponent extends AbstractComponent {

    @FindBy(xpath = ".//input[@name='name']")
    private WebElement nameInput;

    @FindBy(xpath = ".//input[@data-qa='signup-email']")
    private WebElement emailInput;

    @FindBy(xpath = ".//button[text()='Signup']")
    private WebElement signUpButton;

    @FindBy(xpath = "//p[text()='Email Address already exist!']")
    private WebElement emailAddressAlreadyExistErrorMessage;



    public SignUpFormComponent(WebElement root) {
        super(root);
    }

    public void typeInNameInput(String name){
        nameInput.sendKeys(name);
    }

    public void typeInEmailInput(String email){
        emailInput.sendKeys(email);
    }

    public void clickOnSignUpButton(){
        signUpButton.click();
    }

    public boolean isErrorMessageVisible(){
        Wait<WebDriver> wait = new WebDriverWait(WebDriverProvider.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(emailAddressAlreadyExistErrorMessage));

        return emailAddressAlreadyExistErrorMessage.isDisplayed();
    }
}
