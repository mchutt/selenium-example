package com.solvd.example.web.pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractBasePage {
    protected WebDriver driver;

    public AbstractBasePage(WebDriver driver) {
        this.driver = driver;
    }

}
