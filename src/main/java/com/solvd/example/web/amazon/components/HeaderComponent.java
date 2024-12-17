package com.solvd.example.web.amazon.components;

import com.solvd.example.web.amazon.pages.CartPage;
import com.solvd.example.web.amazon.pages.LanguageSettingsPage;
import com.solvd.example.web.amazon.pages.LoginPage;
import com.solvd.example.web.utils.AbstractComponent;
import com.solvd.example.web.utils.WebDriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class HeaderComponent extends AbstractComponent {

    private static final Logger logger = LoggerFactory.getLogger(HeaderComponent.class);

    @FindBy(css = "#icp-nav-flyout")
    private WebElement changeLanguageButton;

    @FindBy(css = "#nav-cart")
    private WebElement cartButton;

    @FindBy(css = "#nav-link-accountList")
    private WebElement loginButton;


    public HeaderComponent(WebElement root) {
        super(root);
    }

    public LanguageSettingsPage clickOnChangeLanguageButton(){
        clickElement(changeLanguageButton);
        return new LanguageSettingsPage(WebDriverProvider.getDriver());
    }
    public CartPage clickOnCartButton(){
        clickElement(cartButton);
        return new CartPage(WebDriverProvider.getDriver());
    }
    public LoginPage clickOnLoginButton(){
        clickElement(loginButton);
        return new LoginPage(WebDriverProvider.getDriver());
    }
    public boolean isSentencePresent(String sentence){
        logger.debug("Checking that sentence '{}' is present", sentence);
        try {
            WebDriverWait wait = new WebDriverWait(WebDriverProvider.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.attributeToBe(changeLanguageButton, "aria-label", sentence));
            logger.debug("Sentence '{}' is present in attribute", sentence);
            return true;
        }catch (Exception e){
         logger.error("Error while checking the sentence existence '{}'", sentence);
         return false;
        }
    }
}
