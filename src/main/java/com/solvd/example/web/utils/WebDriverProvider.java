package com.solvd.example.web.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverProvider {

    //Create a thread local variable and this value will be read only by this current thread
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    //get driver from the current thread
    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void openBrowser() {
        try {
            WebDriver webDriver = new RemoteWebDriver(new URL("http://localhost:4444"), new ChromeOptions());
            webDriver.manage().window().maximize();
            driver.set(webDriver);
        }catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void quitDriver() {
        if (driver.get() != null) driver.get().quit();
        //remove from the TreadLocal variable
        driver.remove();
    }
}
