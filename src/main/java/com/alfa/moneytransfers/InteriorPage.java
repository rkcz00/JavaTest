package com.alfa.moneytransfers;

import com.alfa.BasePage;
import com.alfa.depotransfers.DepoTransferInPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class InteriorPage extends BasePage {
    public InteriorPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[text()='Внутренние']")
    private WebElement interior;

    @FindBy(id = "amount")
    private WebElement amountField;

    @FindBy(id = "send-money")
    private WebElement sendMoneyButton;

    @FindBy(xpath = "//div[contains(@class, 'notification_status_ok')]")
    private WebElement successNotify;


    public InteriorPage chooseInteriorTransfer() {
        webDriverWait.until(ExpectedConditions.visibilityOf(interior));
        interior.click();
        return new InteriorPage(driver);
    }

    public InteriorPage insertAmount() {
        webDriverWait.until(ExpectedConditions.visibilityOf(amountField));
        amountField.sendKeys("10");
        return new InteriorPage(driver);
    }

    public InteriorPage clickTransferButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(sendMoneyButton));
        sendMoneyButton.click();
        return new InteriorPage(driver);
    }

    public InteriorPage checkSuccessNotify() {
        webDriverWait.until(ExpectedConditions.visibilityOf(successNotify));
        Assertions.assertTrue(successNotify.isDisplayed());
        return new InteriorPage(driver);
    }
}
