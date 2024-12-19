package com.solvd.example.web.automationwebpage.pages;

import com.solvd.example.web.automationwebpage.components.ProductInCartComponent;
import com.solvd.example.web.utils.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends AbstractBasePage {

    @FindBy(xpath = "//tbody//tr")
    private List<WebElement> cartProductList;

    @FindBy(xpath = "//a[text()='Proceed To Checkout']")
    private WebElement proceedToCheckoutButton;

    @FindBy(css = "#empty_cart")
    private WebElement emptyCartMessage;



    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<ProductInCartComponent> getAllProducts(){
        return cartProductList.stream().map(ProductInCartComponent::new)
                .collect(Collectors.toList());
    }

    public CheckoutPage clickOnCheckoutButton(){
        clickElement(proceedToCheckoutButton);
        return new CheckoutPage(driver);
    }

    public boolean isEmptyCartMessageVisible(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(emptyCartMessage));

        return emptyCartMessage.isDisplayed();
    }

}
