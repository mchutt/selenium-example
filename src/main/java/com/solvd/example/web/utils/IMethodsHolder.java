package com.solvd.example.web.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public interface IMethodsHolder {

    Logger logger = LoggerFactory.getLogger(IMethodsHolder.class);

    default void scrollToElement(WebElement element) {
        logger.debug("Starting scrolling..");
        waitElement(element);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverProvider.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    default void clickElement(WebElement element){
        logger.debug("clickElement method invoked");
        waitElement(element);

        element.click();
        logger.info("Element clicked");
        logger.debug("clickElement method fully executed");
    }

    default void sendKeysToElement(WebElement element, CharSequence keys){
        logger.debug("sendKeys method invoked");
        waitElement(element);

        element.sendKeys(keys);
        logger.info("Keys '{}' sent ", keys);
        logger.debug("sendKeys method fully executed");
    }

    default void waitElement(WebElement element){
        logger.debug("Waiting until the element is displayed. Element name: '{}'", element.getAccessibleName());
        try {
            WebDriverWait wait = new WebDriverWait(WebDriverProvider.getDriver(), Duration.ofSeconds(5));
            wait.until(driver1 -> element.isDisplayed());
        }catch (TimeoutException exception){
            logger.error("Element not found. {} ",  exception.getLocalizedMessage());
        }
    }

}
