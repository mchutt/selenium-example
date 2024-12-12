package com.solvd.example.web.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverProvider {
    //Create a thread local variable and this value will be read only by this current thread
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    //get driver from the current thread
    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void openBrowser() {
        driver.set(new ChromeDriver());
    }

    public static void quitDriver() {
        if (driver.get() != null) driver.get().quit();
        //remove from the TreadLocal variable
        driver.remove();
    }
}
