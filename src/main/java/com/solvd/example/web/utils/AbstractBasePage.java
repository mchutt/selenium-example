package com.solvd.example.web.utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public abstract class AbstractBasePage {
    private static Logger logger = LoggerFactory.getLogger(AbstractBasePage.class);

    protected WebDriver driver;

    public AbstractBasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage(String url){
        driver.get(url);
        logger.info("Page opened {}", getClass().getSimpleName());
    }
    public void clickElement(WebElement element){
        logger.debug("clickElement method invoked");
        waitElement(element);

        element.click();
        logger.info("Element clicked");
        logger.debug("clickElement method fully executed");
    }
    public void sendKeysToElement(WebElement element, CharSequence keys){
        logger.debug("sendKeys method invoked");
        waitElement(element);

        element.sendKeys(keys);
        logger.info("Keys '{}' sent ", keys);
        logger.debug("sendKeys method fully executed");
    }
    private void waitElement(WebElement element){
        try {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .pollingEvery(Duration.ofMillis(250))
                    .withTimeout(Duration.ofSeconds(5))
                    .ignoring(NoSuchElementException.class);

            wait.until(driver1 -> element.isDisplayed());
        }catch (TimeoutException exception){
            logger.error("Element not found. {} ",  exception.getLocalizedMessage());
        }
    }
}
