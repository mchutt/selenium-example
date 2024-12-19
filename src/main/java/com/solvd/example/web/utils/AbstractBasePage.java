package com.solvd.example.web.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractBasePage implements IMethodsHolder{

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

}
