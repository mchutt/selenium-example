package com.solvd.example.web.automationwebpage.components;

import com.solvd.example.web.utils.AbstractComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductInCartComponent extends AbstractComponent {

    @FindBy(xpath = ".//h4")
    private WebElement productName;

    @FindBy(css = ".cart_quantity_delete")
    private WebElement deleteProduct;

    public ProductInCartComponent(WebElement root) {
        super(root);
    }

    public String getName() {
        return productName.getText();
    }

    public void clickOnDeleteProductButton(){
        clickElement(deleteProduct);
    }

}
