package com.solvd.example.web;

import com.solvd.example.web.utils.WebDriverProvider;
import org.testng.ITestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public abstract class AbstractTest implements ITestListener {

    @BeforeMethod
    public void openBrowser(){
        WebDriverProvider.openBrowser();
    }

    @AfterMethod
    public void quitDriver(){
        WebDriverProvider.quitDriver();
    }

    protected void pause(Long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
