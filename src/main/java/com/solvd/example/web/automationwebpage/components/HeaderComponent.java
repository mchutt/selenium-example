package com.solvd.example.web.automationwebpage.components;


import com.solvd.example.web.automationwebpage.constants.LinkNames;
import com.solvd.example.web.automationwebpage.pages.HomePage;
import com.solvd.example.web.automationwebpage.pages.LoginPage;
import com.solvd.example.web.automationwebpage.pages.ProductsPage;
import com.solvd.example.web.utils.AbstractComponent;
import com.solvd.example.web.utils.WebDriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;

public class HeaderComponent extends AbstractComponent {

    @FindBy(xpath = ".//li/a")
    private List<WebElement> linkList;

    @FindBy(xpath = ".//li/a[text()=' Logged in as ']")
    private WebElement loggedMessage;

    public HeaderComponent(WebElement root) {
        super(root);
    }

    private void clickOnLink(LinkNames linkName) {

        linkList.stream()
                .filter(link -> Objects.equals(
                        link.getDomAttribute("href"),
                        linkName.getHref()))
                .findFirst().orElseThrow().click();
    }

    public ProductsPage openProductsPage() {
        clickOnLink(LinkNames.PRODUCTS);
        return new ProductsPage(WebDriverProvider.getDriver());
    }

    public HomePage openHomePage(){
        clickOnLink(LinkNames.HOME);
        return new HomePage(WebDriverProvider.getDriver());
    }

    public LoginPage openLoginPage(){
        clickOnLink(LinkNames.LOGIN);
        return new LoginPage(WebDriverProvider.getDriver());
    }

    public boolean isLoggedMessageDisplayed(){
        return loggedMessage.isDisplayed();
    }

}
