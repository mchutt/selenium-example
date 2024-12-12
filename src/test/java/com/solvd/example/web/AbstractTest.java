package com.solvd.example.web;

import com.solvd.example.web.utils.WebDriverProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractTest {

    @BeforeMethod
    public void openBrowser(){
        WebDriverProvider.openBrowser();
    }

    @AfterMethod
    public void quiteDriver(){
        WebDriverProvider.quitDriver();
    }

}
