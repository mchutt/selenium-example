package com.solvd.example.web.automationwebpage.components;

import com.solvd.example.web.automationwebpage.pages.ProductDetailsPage;
import com.solvd.example.web.utils.AbstractComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.solvd.example.web.utils.WebDriverProvider.getDriver;

public class ProductCardComponent extends AbstractComponent {

    @FindBy(xpath = ".//a[text()='View Product']")
    private WebElement viewProductDetailsButton;

    @FindBy(css = "p")
    private WebElement productName;

    @FindBy(xpath = ".//a[text()='Add to cart']")
    private WebElement addToCartButton;

    public ProductCardComponent(WebElement root) {
        super(root);
    }

    public ProductDetailsPage openProductDetails(){
        scrollToElement(viewProductDetailsButton);
        clickElement(viewProductDetailsButton);
        return new ProductDetailsPage(getDriver());
    }

    public String getProductName(){
        return productName.getText();
    }

}
