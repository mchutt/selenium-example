package com.solvd.example.web.sauce.pages;

import com.solvd.example.web.sauce.components.ProductCard;
import com.solvd.example.web.utils.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SauceProductsPage extends AbstractBasePage {
    @FindBy(css = ".inventory_item")
    private List<WebElement> productCardElements;

    public SauceProductsPage(WebDriver driver) {
        super(driver);
    }

    public List<ProductCard> getProducts() {
        return productCardElements.stream()
                .map(ProductCard::new)
                .collect(Collectors.toList());
    }
}
