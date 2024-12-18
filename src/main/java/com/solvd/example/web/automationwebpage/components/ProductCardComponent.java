package com.solvd.example.web.automationwebpage.components;

import com.solvd.example.web.utils.AbstractComponent;
import com.solvd.example.web.utils.WebDriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProductCardComponent extends AbstractComponent {

    @FindBy(xpath = ".//a[text()='View Product']")
    private WebElement viewProductDetailsButton;

    public ProductCardComponent(WebElement root) {
        super(root);
    }

    public void openProductDetails(){
        viewProductDetailsButton.click();
    }


}
