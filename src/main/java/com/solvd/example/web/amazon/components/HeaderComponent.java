package com.solvd.example.web.amazon.components;

import com.solvd.example.web.amazon.pages.CartPage;
import com.solvd.example.web.amazon.pages.ChangeLanguagePage;
import com.solvd.example.web.amazon.pages.LoginPage;
import com.solvd.example.web.utils.AbstractComponent;
import com.solvd.example.web.utils.WebDriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends AbstractComponent {

    @FindBy(css = "#icp-nav-flyout")
    private WebElement changeLanguageButton;

    @FindBy(css = "#nav-cart")
    private WebElement cartButton;

    @FindBy(css = "#nav-link-accountList")
    private WebElement loginButton;



    public HeaderComponent(WebElement root) {
        super(root);
    }

    public ChangeLanguagePage clickOnChangeLanguageButton(){
        clickElement(changeLanguageButton);
        return new ChangeLanguagePage(WebDriverProvider.getDriver());
    }
    public String getActualLanguageSentence(){
        return changeLanguageButton.getDomAttribute("aria-label");
    }
    public CartPage clickOnCartButton(){
        clickElement(cartButton);
        return new CartPage(WebDriverProvider.getDriver());
    }
    public LoginPage clickOnLoginButton(){
        clickElement(loginButton);
        return new LoginPage(WebDriverProvider.getDriver());
    }
}
