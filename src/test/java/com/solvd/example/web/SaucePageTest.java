package com.solvd.example.web;

import com.solvd.example.web.components.ProductCard;
import com.solvd.example.web.pages.SauceLoginPage;
import com.solvd.example.web.pages.SauceProductsPage;
import com.solvd.example.web.utils.WebDriverProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SaucePageTest extends AbstractTest {

    @Test
    public void verifyLoginTest(){
        SauceLoginPage loginPage = new SauceLoginPage(WebDriverProvider.getDriver());
        loginPage.openPage("https://www.saucedemo.com/");


        loginPage.typeUserName("standard_user");
        loginPage.typePassword("secret_sauce");
        SauceProductsPage sauceProductsPage = loginPage.clickOnLoginButton();
        List<ProductCard> productList = sauceProductsPage.getProducts();


        Assert.assertFalse(productList.isEmpty(), "Products list is empty");
        productList.forEach(productCard -> System.out.println(productCard.getName()));

    }

    @Test
    public void verifyLoginTestTwo(){

        SauceLoginPage loginPage = new SauceLoginPage(WebDriverProvider.getDriver());

        loginPage.openPage("https://www.saucedemo.com/");

        loginPage.typeUserName("standard_user");
        loginPage.typePassword("secret_sauce");
        SauceProductsPage sauceProductsPage = loginPage.clickOnLoginButton();
        List<ProductCard> productList = sauceProductsPage.getProducts();

        Assert.assertFalse(productList.isEmpty(), "Products list is empty");
        productList.forEach(productCard -> System.out.println(productCard.getName()));

    }

}
