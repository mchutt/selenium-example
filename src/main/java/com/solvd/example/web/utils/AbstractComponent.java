package com.solvd.example.web.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractComponent implements IMethodsHolder {

    private static Logger logger = LoggerFactory.getLogger(AbstractComponent.class);

    protected WebElement root;

    public AbstractComponent(WebElement root) {
        this.root = root;
        PageFactory.initElements(root, this);
    }


}
