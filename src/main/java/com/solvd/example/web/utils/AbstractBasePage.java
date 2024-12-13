package com.solvd.example.web.utils;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public abstract class AbstractBasePage {
    private static Logger logger = LoggerFactory.getLogger(AbstractBasePage.class);

    protected WebDriver driver;

    public AbstractBasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage(String url){
        driver.get(url);
        logger.info("Page opened {}", getClass().getSimpleName());
    }
    protected void clickElement(WebElement element){
        logger.debug("clickElement method invoked");
        waitElement(element);

        element.click();
        logger.info("Element clicked");
        logger.debug("clickElement method fully executed");
    }
    protected void sendKeysToElement(WebElement element, CharSequence keys){
        logger.debug("sendKeys method invoked");
        waitElement(element);

        element.sendKeys(keys);
        logger.info("Keys '{}' sent ", keys);
        logger.debug("sendKeys method fully executed");
    }
    protected void waitElement(WebElement element){
        logger.debug("Waiting until the element is displayed. Element name: '{}'", element.getAccessibleName());
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(driver1 -> element.isDisplayed());
        }catch (TimeoutException exception){
            logger.error("Element not found. {} ",  exception.getLocalizedMessage());
        }
    }
}
