package com.solvd.example.web.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCard {
    private WebElement root;
    @FindBy(css = ".inventory_item_name")
    private WebElement name;

    public ProductCard(WebElement root) {
        this.root = root;
        PageFactory.initElements(root, this);
    }

    public String getName(){
        return name.getText();
    }

}
