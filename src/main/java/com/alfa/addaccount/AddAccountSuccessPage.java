package com.alfa.addaccount;

import com.alfa.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddAccountSuccessPage extends BasePage {
    public AddAccountSuccessPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class= 'add-account-success__stage-body']")
    private WebElement successStage;

    public void checkSuccessStage() {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        webDriverWait.until(ExpectedConditions.visibilityOf(successStage));
        Assertions.assertTrue(successStage.isDisplayed());
    }
}
