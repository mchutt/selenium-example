package com.solvd.example.web.amazon.pages;

import com.solvd.example.web.utils.AbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class LanguageSettingsPage extends AbstractBasePage {
    @FindBy(xpath = "//div[@id='icp-language-settings']/div[not(@id)]")
    private List<WebElement> languageList;

    @FindBy(xpath = "//span[@id='icp-save-button']//input[@type='submit']")
    private WebElement saveChangesButton;

    public LanguageSettingsPage(WebDriver driver) {
        super(driver);
    }

    public void selectAndClickARandomLanguageButton(){
        Random r = new Random();
        WebElement webElement = languageList.get(r.nextInt(languageList.size()));
        webElement.click();
    }

    public void selectLanguage(String lang){
       WebElement languageButton = languageList.stream()
                .filter(element -> Objects.equals(element
                          .findElement(By.xpath(".//input"))
                          .getDomAttribute("value"), lang))
                .findFirst()
                .orElseThrow();

       languageButton.click();
    }
    public void clickOnSaveChanges(){
        clickElement(saveChangesButton);
    }
}
