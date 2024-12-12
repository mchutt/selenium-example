package com.solvd.example.web.sauce.components;

import com.solvd.example.web.utils.AbstractComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductCard extends AbstractComponent {

    @FindBy(css = ".inventory_item_name")
    private WebElement name;

    public ProductCard(WebElement root) {
        super(root);
    }

    public String getName(){
        return name.getText();
    }

}
