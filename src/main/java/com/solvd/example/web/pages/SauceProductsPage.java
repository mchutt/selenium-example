package com.solvd.example.web.pages;

import com.solvd.example.web.components.ProductCard;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class SauceProductsPage extends AbstractBasePage{
    @FindBy(css = ".inventory_item")
    private List<WebElement> productCardElements;

    public SauceProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<ProductCard> getProducts() {
        return productCardElements.stream()
                .map(ProductCard::new)
                .collect(Collectors.toList());
    }
}
