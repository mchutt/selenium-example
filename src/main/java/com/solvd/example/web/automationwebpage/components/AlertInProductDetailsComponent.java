package com.solvd.example.web.automationwebpage.components;

import com.solvd.example.web.automationwebpage.pages.CartPage;
import com.solvd.example.web.utils.AbstractComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.solvd.example.web.utils.WebDriverProvider.getDriver;

public class AlertInProductDetailsComponent extends AbstractComponent {

    @FindBy(xpath = ".//u[text()='View Cart']")
    private WebElement viewCartButton;

    public AlertInProductDetailsComponent(WebElement root) {
        super(root);
    }

    public CartPage openCartPage(){
        waitElement(viewCartButton);
        scrollToElement(viewCartButton);
        viewCartButton.click();
        return new CartPage(getDriver());
    }
}
