package com.alfa;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ArbitraryOrders extends BasePage {
    public ArbitraryOrders(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[text()='Новое']")
    private WebElement newTab;

    @FindBy(xpath = "//span[text()='Выберите тему поручения']")
    private WebElement chooseOrderTheme;

    @FindBy(xpath = "//div/span[text()='Иное']")
    private WebElement otherTheme;

    @FindBy(xpath = "//div/span[text()='QUIK']")
    private WebElement quikTheme;

    @FindBy(xpath = "//div/span[text()='Признание квалифицированным инвестором']")
    private WebElement qualifiedInvestorTheme;

    @FindBy(xpath = "//div/span[text()='Участие в размещении ЦБ, оферте']")
    private WebElement offerTheme;

    @FindBy(xpath = "//div/span[text()='Отмена поручения на размещение ЦБ, оферту']")
    private WebElement cancelOfferTheme;

    @FindBy(id = "free-order-text")
    private WebElement orderField;

    @FindBy(id = "send-free-order")
    private WebElement sendOrderButton;

    @FindBy(xpath = "//div[contains(@class, 'notification_status_ok')]")
    private WebElement successNotify;

    public ArbitraryOrders chooseOtherTheme() {
        webDriverWait.until(ExpectedConditions.visibilityOf(newTab));
        chooseOrderTheme.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(otherTheme));
        otherTheme.click();
        orderField.sendKeys("Test");
        return new ArbitraryOrders(driver);
    }

    public ArbitraryOrders chooseQuikTheme() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(newTab));
        chooseOrderTheme.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(quikTheme));
        quikTheme.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(orderField));
        orderField.sendKeys("Test");
        return new ArbitraryOrders(driver);
    }

    public ArbitraryOrders chooseQualifiedInvestorTheme() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(newTab));
        chooseOrderTheme.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(qualifiedInvestorTheme));
        qualifiedInvestorTheme.click();
        orderField.sendKeys("Test");
        return new ArbitraryOrders(driver);
    }

    public ArbitraryOrders chooseOfferTheme() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(newTab));
        chooseOrderTheme.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(offerTheme));
        offerTheme.click();
        orderField.sendKeys("Test");
        return new ArbitraryOrders(driver);
    }

    public ArbitraryOrders chooseCancelOfferTheme() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(newTab));
        chooseOrderTheme.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(cancelOfferTheme));
        cancelOfferTheme.click();
        orderField.sendKeys("Test");
        return new ArbitraryOrders(driver);
    }


    public ArbitraryOrders clickSendOrderButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(sendOrderButton));
        sendOrderButton.click();
        return new ArbitraryOrders(driver);
    }

    public ArbitraryOrders checkSuccessNotify() {
        webDriverWait.until(ExpectedConditions.visibilityOf(successNotify));
        Assertions.assertTrue(successNotify.isDisplayed());
        return new ArbitraryOrders(driver);
    }
}
