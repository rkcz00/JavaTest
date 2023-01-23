package com.alfa.depotransfers;

import com.alfa.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DepoTransferInnerPage extends BasePage {
    public DepoTransferInnerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[.= 'Внутри счета']")
    private WebElement innerButton;

    @FindBy(xpath = "//span[.= 'Продолжить']")
    private WebElement nextButton;

    @FindBy(xpath = "//input[contains(@id, 'downs')]")
    private WebElement securityField;

    @FindBy(xpath = "//div[.= 'Энел Россия, 1 в., 1-01-50077-A / RU000A0F5UN3']")
    private WebElement paper;

    @FindBy(xpath = "//input[@aria-label = 'Количество']")
    private WebElement countFiled;

    @FindBy(xpath = "//span[.= 'Подать поручение']")
    private WebElement sendOrderButton;

    @FindBy(xpath = "//div[contains(@class, 'notification_status_ok')]")
    private WebElement successNotify;

    public DepoTransferInnerPage chooseInnerTransfers() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(innerButton));
        innerButton.click();
        return new DepoTransferInnerPage(driver);
    }

    public DepoTransferInnerPage nextButtonClick() {
        webDriverWait.until(ExpectedConditions.visibilityOf(nextButton));
        actions.moveToElement(nextButton).click().build().perform();
        return new DepoTransferInnerPage(driver);
    }

    public DepoTransferInnerPage chooseSecurity() {
        webDriverWait.until(ExpectedConditions.visibilityOf(securityField));
        securityField.sendKeys("Энел");
        webDriverWait.until(ExpectedConditions.visibilityOf(paper));
        paper.click();
        return new DepoTransferInnerPage(driver);
    }

    public DepoTransferInnerPage insertCountFiled() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(countFiled));
        countFiled.sendKeys("1");
        return new DepoTransferInnerPage(driver);
    }

    public DepoTransferInnerPage sendOrderButtonClick() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(sendOrderButton));
        actions.moveToElement(sendOrderButton).click().build().perform();
        return new DepoTransferInnerPage(driver);
    }

    public DepoTransferInnerPage checkSuccessNotify() {
        webDriverWait.until(ExpectedConditions.visibilityOf(successNotify));
        Assertions.assertTrue(successNotify.isDisplayed());
        return new DepoTransferInnerPage(driver);
    }


}
