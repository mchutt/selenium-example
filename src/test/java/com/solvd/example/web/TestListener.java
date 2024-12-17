package com.solvd.example.web;

import com.solvd.example.web.utils.WebDriverProvider;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.time.LocalDateTime;

public class TestListener implements ITestListener {
    private static final Logger logger = LoggerFactory.getLogger(TestListener.class);

    private static final LocalDateTime currentDateTime = LocalDateTime.now();

    @Override
    public void onTestFailure(ITestResult result) {
        logger.debug("onTestFailure method executed. method name {}", result.getName());
        try {
            takeScreenshot(WebDriverProvider.getDriver(), result.getName());
        } catch (Exception e) {
            logger.error("Error when trying to take a screenshot for the test: '{}'", result.getName());
            throw new RuntimeException(e);
        }
    }

    private void takeScreenshot(WebDriver webdriver, String imageName) throws Exception{
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination

        String workingDir = System.getProperty("user.dir");

        File DestFile=new File(workingDir + "/test-output/"+ currentDateTime + "/" + imageName + ".png");
        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }
}
