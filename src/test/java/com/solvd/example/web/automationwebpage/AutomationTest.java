package com.solvd.example.web.automationwebpage;

import com.solvd.example.web.AbstractTest;
import com.solvd.example.web.automationwebpage.components.SignUpFormComponent;
import com.solvd.example.web.automationwebpage.pages.HomePage;
import com.solvd.example.web.automationwebpage.pages.LoginPage;
import com.solvd.example.web.automationwebpage.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.solvd.example.web.utils.WebDriverProvider.getDriver;

public class AutomationTest extends AbstractTest {

    @Test
    public void searchAProductTest(){
        HomePage homePage = new HomePage(getDriver());
        homePage.openPage("http://automationexercise.com");

        ProductsPage productsPage = homePage.getHeader().openProductsPage();
        boolean isTitleDisplayed = productsPage.isAllProductsTitleDisplayed();

        Assert.assertTrue(isTitleDisplayed, "Title is not displayed");
    }

    @Test
    public void registerUserWithAnExistingEmail(){
        HomePage homePage = new HomePage(getDriver());
        homePage.openPage("http://automationexercise.com");

        LoginPage loginPage = homePage.getHeader().openLoginPage();
        SignUpFormComponent form = loginPage.getSignUpForm();
        form.typeInEmailInput("pepe@pepe.com");
        form.typeInNameInput("Pepe");
        form.clickOnSignUpButton();

        boolean isErrorMessageVisible = form.isErrorMessageVisible();
        Assert.assertTrue(isErrorMessageVisible, "Error message is not visible");
    }


}
