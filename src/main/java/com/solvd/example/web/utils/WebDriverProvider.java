package com.solvd.example.web.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverProvider {

    private static final Logger logger = LoggerFactory.getLogger(WebDriverProvider.class);

    //Create a thread local variable and this value will be read only by this current thread
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    //get driver from the current thread
    public static WebDriver getDriver() {
        return driver.get();
    }


    public static void openBrowser(String browserName) {
        if (browserName.isEmpty()) {
            browserName = "chrome";
            logger.warn("Browser name not specified. Using the default browser name: {} ", browserName);
        }

        WebDriver webDriver;
        URL url;

        try {
            url = new URL("http://localhost:4444");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }


        webDriver = switch (browserName) {
            case "chrome" -> new RemoteWebDriver(url, new ChromeOptions());
            case "firefox" -> new RemoteWebDriver(url, new FirefoxOptions());
            default -> {
                logger.error("Unable to create a web driver for this browser name: {} ", browserName);
                throw new IllegalArgumentException("Unsupported browser name. Please specify one");
            }
        };

        webDriver.manage().window().maximize();
        driver.set(webDriver);

    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
