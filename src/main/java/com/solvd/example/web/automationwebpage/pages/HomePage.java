package com.solvd.example.web.automationwebpage.pages;

import com.solvd.example.web.automationwebpage.components.HeaderComponent;
import com.solvd.example.web.utils.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractBasePage {

    @FindBy(css = "#header")
    private WebElement header;

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public HeaderComponent getHeader(){
        return new HeaderComponent(header);
    }
}
