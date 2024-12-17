package com.solvd.example.web.amazon.pages;

import com.solvd.example.web.amazon.components.ProductCardComponent;
import com.solvd.example.web.utils.AbstractBasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class ProductListPage extends AbstractBasePage {


    @FindBy(xpath = "//div[@data-component-type='s-search-result']")
    private List<WebElement> productList;

    @FindBy(xpath = "//span[@id='a-autoid-0-announce']//span[@class='a-dropdown-prompt']")
    private WebElement sortingButton;

    @FindBy(css = "#s-result-sort-select_1")
    private WebElement sortByPriceAsc;


    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductListEmpty(){
        return getProductList().isEmpty();
    }

    public ProductCardComponent getAProduct(int index){
        return new ProductCardComponent(getProductList().get(index));
    }

    public List<WebElement> getProductList(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfAllElements(productList));
        return productList;
    }

    public void clickOnSortingButton(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(sortingButton));
        sortingButton.click();
    }
    public void clickOnSortByPriceAsc(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(sortByPriceAsc));
        sortByPriceAsc.click();
    }
    public boolean isProductListSortedByPrice(){
        List<Double> clearPrices = getClearPrices();
        //System.out.println(clearPrices);

        return clearPrices
                .equals(clearPrices
                        .stream()
                        .sorted()
                        .collect(Collectors.toList()));
    }

    public List<Double> getClearPrices(){
       return getProductList().stream().map(ProductCardComponent::new)
                .map(ProductCardComponent::getClearPrice)
                .filter(price -> !price.equals(-1.0))
                .collect(Collectors.toList());
    }
}
