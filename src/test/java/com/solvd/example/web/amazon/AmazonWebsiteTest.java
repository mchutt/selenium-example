package com.solvd.example.web.amazon;

import com.solvd.example.web.AbstractTest;
import com.solvd.example.web.amazon.pages.*;
import com.solvd.example.web.utils.WebDriverProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonWebsiteTest extends AbstractTest {
    @Test
    public void validateSearchingForAProduct(){
        AmazonHomePage page = new AmazonHomePage(WebDriverProvider.getDriver());
        page.openPage("https://www.amazon.com/");

        page.typeOnSearchInput("iPhone");
        SearchPage searchPage = page.pressEnter();

        Assert.assertFalse(searchPage.isProductListEmpty(), "Product list is empty");
    }
    @Test
    public void validateChangingWebsiteLanguage(){
        AmazonHomePage page = new AmazonHomePage(WebDriverProvider.getDriver());
        page.openPage("https://www.amazon.com/");

        ChangeLanguagePage changeLanguagePage = page.getHeaderComponent().clickOnChangeLanguageButton();
        changeLanguagePage.selectLanguage("es_US");
        changeLanguagePage.clickOnSaveChanges();

        pause(2000L); //TODO replace it for an explicit wait
        String actualLanguageSentence = page.getHeaderComponent().getActualLanguageSentence();
        String expectedLanguageSentence = "Elige un idioma para hacer compras. La selección actual es Español. ";
        Assert.assertEquals(actualLanguageSentence, expectedLanguageSentence, "Language site is not the expected one");
    }
    @Test
    public void validateAddingAProductToTheCart(){
        AmazonHomePage page = new AmazonHomePage(WebDriverProvider.getDriver());
        page.openPage("https://www.amazon.com/");

        page.typeOnSearchInput("iphone 14 pro max");
        SearchPage searchPage = page.pressEnter();
        ProductDetailsPage productDetailsPage = searchPage.getAProduct(0).clickOnProductDetailsButton();
        productDetailsPage.clickOnAddToCartButton();

        CartPage cartPage = page.getHeaderComponent().clickOnCartButton();

        Assert.assertFalse(cartPage.isCartEmpty(), "Cart is Empty");
    }

    @Test
    public void validateThatANonRegisteredUserIsInvalid(){
        AmazonHomePage page = new AmazonHomePage(WebDriverProvider.getDriver());
        page.openPage("https://www.amazon.com/");

        LoginPage loginPage = page.getHeaderComponent().clickOnLoginButton();
        loginPage.typeEmail("sadfsadf324234sdf@sdfsdf.sddf");
        loginPage.clickOnContinueButton();

        Assert.assertTrue(loginPage.isErrorMessagePresent(), "Error message is not present");
    }

    @Test
    public void validateSortingProductsByPrice(){
        AmazonHomePage page = new AmazonHomePage(WebDriverProvider.getDriver());
        page.openPage("https://www.amazon.com/");

        page.typeOnSearchInput("iPhone");
        SearchPage searchPage = page.pressEnter();
        searchPage.clickOnSortingButton();
        searchPage.clickOnSortByPriceAsc();

        Assert.assertTrue(searchPage.isProductListSortedByPrice(), "Products are no sorted by price");
    }

}
