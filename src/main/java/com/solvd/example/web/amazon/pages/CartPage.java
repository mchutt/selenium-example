package com.solvd.example.web.amazon.pages;

import com.solvd.example.web.utils.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends AbstractBasePage {
    @FindBy(xpath = "//div[@data-csa-c-type='item']")
    private List<WebElement> cartItemList;

    public CartPage(WebDriver driver) {
        super(driver);
    }
    public boolean isCartEmpty(){
        return cartItemList.isEmpty();
    }
}
