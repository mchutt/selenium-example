package com.solvd.example.web.automationwebpage;

import com.solvd.example.web.AbstractTest;
import com.solvd.example.web.automationwebpage.components.LoginFormComponent;
import com.solvd.example.web.automationwebpage.components.ProductCardComponent;
import com.solvd.example.web.automationwebpage.components.ProductInCartComponent;
import com.solvd.example.web.automationwebpage.components.SignUpFormComponent;
import com.solvd.example.web.automationwebpage.pages.*;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.solvd.example.web.utils.WebDriverProvider.getDriver;

public class AutomationTest extends AbstractTest {

    private static final String USER_PASSWORD = "123456789";

    private static final String USER_EMAIL = "mateo@mateo.com";

    @Test
    public void searchAProductTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.openPage("http://automationexercise.com");

        ProductsPage productsPage = homePage.getHeader().openProductsPage();
        boolean isTitleDisplayed = productsPage.isAllProductsTitleDisplayed();
        Assert.assertTrue(isTitleDisplayed, "The 'All Products' title is not displayed on the Products page.");

        String searchQ = "top";
        productsPage.typeTextInSearchInput(searchQ);
        productsPage.clickOnSubmitSearchButton();

        List<ProductCardComponent> products = productsPage.getProducts();
        int productNameContainsSearchedTextCount = 0;
        for (ProductCardComponent product : products) {
            if (StringUtils.containsIgnoreCase(product.getProductName(), searchQ)) {
                productNameContainsSearchedTextCount++;
            } else productNameContainsSearchedTextCount--;
        }
        Assert.assertTrue(productNameContainsSearchedTextCount > 0, "The product list do not contain any products which name matches with the searched text: " + searchQ);
    }

    @Test
    public void registerUserWithAnExistingEmailTest() {

        HomePage homePage = new HomePage(getDriver());
        homePage.openPage("http://automationexercise.com");

        LoginPage loginPage = homePage.getHeader().openLoginPage();
        SignUpFormComponent form = loginPage.getSignUpForm();
        form.typeInEmailInput("pepe@pepe.com");
        form.typeInNameInput("Pepe");
        form.clickOnSignUpButton();

        boolean isErrorMessageVisible = form.isErrorMessageVisible();
        Assert.assertTrue(isErrorMessageVisible, "The error message for an existing email is not displayed. ");
    }

    @Test
    public void loginWithAnIncorrectEmailAndPasswordTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.openPage("http://automationexercise.com");

        LoginPage loginPage = homePage.getHeader().openLoginPage();
        LoginFormComponent loginForm = loginPage.getLoginForm();
        loginForm.typeInEmailInput("pepe@pepe.com");
        loginForm.typeInPasswordInput("Incorrect Pass");
        loginForm.clickOnLoginButton();

        boolean isErrorMessageVisible = loginForm.isErrorMessageVisible();
        Assert.assertTrue(isErrorMessageVisible, "The error message for incorrect login credentials is not displayed. ");
    }

    @Test
    public void addProductToTheCartTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.openPage("http://automationexercise.com");


        ProductsPage productsPage = homePage.getHeader().openProductsPage();
        ProductCardComponent productCardComponent = productsPage.getProducts().get(0);
        ProductDetailsPage productDetailsPage = productCardComponent.openProductDetails();


        CartPage cartPage = productDetailsPage.clickOnAddToCartButton().openCartPage();
        Assert.assertFalse(cartPage.getAllProducts().isEmpty(), "The cart is empty. ");


        cartPage.getAllProducts()
                .forEach(ProductInCartComponent::clickOnDeleteProductButton);
        Assert.assertTrue(cartPage.isEmptyCartMessageVisible(), "The cart is NOT empty. ");

    }

    @Test
    public void checkoutTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.openPage("http://automationexercise.com");

        //Login
        LoginPage loginPage = homePage.getHeader().openLoginPage();
        LoginFormComponent loginForm = loginPage.getLoginForm();
        loginForm.typeInEmailInput(USER_EMAIL);
        loginForm.typeInPasswordInput(USER_PASSWORD);
        loginForm.clickOnLoginButton();

        boolean isloggedMessageDisplayed = homePage.getHeader().isLoggedMessageDisplayed();
        Assert.assertTrue(isloggedMessageDisplayed, "The 'logged in user' message is not displayed after login. ");

        //Add product to cart
        ProductsPage productsPage = homePage.getHeader().openProductsPage();
        ProductCardComponent productCardComponent = productsPage.getProducts().get(0);
        ProductDetailsPage productDetailsPage = productCardComponent.openProductDetails();
        CartPage cartPage = productDetailsPage.clickOnAddToCartButton().openCartPage();

        Assert.assertFalse(cartPage.getAllProducts().isEmpty(), "The cart is empty after adding a product. ");

        CheckoutPage checkoutPage = cartPage.clickOnCheckoutButton();
        PaymentPage paymentPage = checkoutPage.clickOnPlaceOrderButton();

        paymentPage.typeInNameOnCardInput("mateo");
        paymentPage.typeInCardNumberInput("123424234");
        paymentPage.typeInCVCInput("234");
        paymentPage.typeInExpirationMonthInput("03");
        paymentPage.typeInExpirationYearInput("2030");
        PaymentDonePage paymentDonePage = paymentPage.clickOnConfirmOrderbutton();

        boolean confirmedOrder = paymentDonePage.isConfirmedOrderMessageDisplayed();
        Assert.assertTrue(confirmedOrder, "The order confirmation message is not displayed. ");

    }
}
