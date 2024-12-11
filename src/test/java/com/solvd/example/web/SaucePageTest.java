package com.solvd.example.web;

import com.solvd.example.web.components.ProductCard;
import com.solvd.example.web.pages.SauceLoginPage;
import com.solvd.example.web.pages.SauceProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SaucePageTest {
    @Test
    public void verifyLoginTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");


        SauceLoginPage loginPage = new SauceLoginPage(driver);
        loginPage.typeUserName("standard_user");
        loginPage.typePassword("secret_sauce");
        SauceProductsPage sauceProductsPage = loginPage.clickOnLoginButton();
        List<ProductCard> productList = sauceProductsPage.getProducts();

        int productsListSize = productList.size();
        Assert.assertTrue(productsListSize > 0, "Products list is empty");
        productList.forEach(productCard -> System.out.println(productCard.getName()));

        driver.close();
    }
}
