package com.solvd.example.web.amazon.pages;

import com.solvd.example.web.amazon.components.HeaderComponent;
import com.solvd.example.web.utils.AbstractBasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonHomePage extends AbstractBasePage {

    @FindBy(css = "#nav-belt")
    private WebElement headerElement;

    @FindBy(css = "#twotabsearchtextbox")
    private WebElement searchInput;

    public AmazonHomePage(WebDriver driver) {
        super(driver);
    }

    public void typeOnSearchInput(String text){
        sendKeysToElement(searchInput, text);
    }
    public SearchPage pressEnter(){
        sendKeysToElement(searchInput, Keys.ENTER); //TODO create another method to simulate user interactions like Enter
        return new SearchPage(driver);
    }

    public HeaderComponent getHeaderComponent() {
        return new HeaderComponent(headerElement);
    }
}
