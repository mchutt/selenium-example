package com.solvd.example.web.amazon.pages;

import com.solvd.example.web.amazon.components.ProductCardComponent;
import com.solvd.example.web.utils.AbstractBasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class SearchPage extends AbstractBasePage {

    private final String productXpath = "//div[@data-component-type='s-search-result']";
    @FindBy(xpath = productXpath)
    private List<WebElement> productList;

    @FindBy(xpath = "//span[@id='a-autoid-0-announce']//span[@class='a-dropdown-prompt']")
    private WebElement sortingButton;

    @FindBy(css = "#s-result-sort-select_1")
    private WebElement sortByPriceAsc;


    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductListEmpty(){
        return getProductList().isEmpty();
    }

    public ProductCardComponent getAProduct(int index){
        return new ProductCardComponent(getProductList().get(index));
    }

    public List<WebElement> getProductList(){
        new FluentWait<>(driver)
                .pollingEvery(Duration.ofMillis(250))
                .withTimeout(Duration.ofSeconds(5))
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.xpath(productXpath)));
        return productList;
    }

    public void clickOnSortingButton(){
        clickElement(sortingButton);
    }
    public void clickOnSortByPriceAsc(){
        clickElement(sortByPriceAsc);
    }
    public boolean isProductListSortedByPrice(){
        List<Double> cleanPrices = getClearPrices();

        return cleanPrices
                .equals(cleanPrices
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
