package com.alfa.tests;

import com.alfa.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllTestsPage extends BasePage {
    public AllTestsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[.='Необеспеченные (маржинальные) сделки']")
    private WebElement marginalTest;

    public MarginalTestPage chooseMarginalTest(){
        webDriverWait.until(ExpectedConditions.visibilityOf(marginalTest));
        marginalTest.click();
        return new MarginalTestPage(driver);
    }
}


