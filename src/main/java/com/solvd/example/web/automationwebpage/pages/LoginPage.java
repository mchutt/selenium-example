package com.solvd.example.web.automationwebpage.pages;

import com.solvd.example.web.automationwebpage.components.LoginFormComponent;
import com.solvd.example.web.automationwebpage.components.SignUpFormComponent;
import com.solvd.example.web.utils.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractBasePage {

    @FindBy(css = ".signup-form")
    private WebElement signUpFormElement;

    @FindBy(css = ".login-form")
    private WebElement loginFormElement;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public SignUpFormComponent getSignUpForm(){
        return new SignUpFormComponent(signUpFormElement);
    }

    public LoginFormComponent getLoginForm() {
        return new LoginFormComponent(loginFormElement);
    }
}
