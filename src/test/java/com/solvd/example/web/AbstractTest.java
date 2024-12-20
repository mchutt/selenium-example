package com.solvd.example.web;

import com.solvd.example.web.utils.WebDriverProvider;
import org.testng.ITestListener;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public abstract class AbstractTest implements ITestListener {

    @Parameters({"browser-name"})
    @BeforeMethod
    public void openBrowser(@Optional("") String browserName) {
        WebDriverProvider.openBrowser(browserName);
    }

    @AfterMethod
    public void quitDriver() {
        WebDriverProvider.quitDriver();
    }

    protected void pause(Long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
