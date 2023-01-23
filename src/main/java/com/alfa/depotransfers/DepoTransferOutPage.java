package com.alfa.depotransfers;

import com.alfa.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DepoTransferOutPage extends BasePage {
    public DepoTransferOutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[.= 'Списание']")
    private WebElement withdrawButton;

    @FindBy(xpath = "//span[.= 'Продолжить']")
    private WebElement nextButton;

    @FindBy(xpath = "//span[.= 'Выберите место хранения']")
    private WebElement placeHolder;

//    @FindBy(xpath = "//div[.= 'НРД (Московская биржа)']")
//    private WebElement nrd;

    @FindBy(xpath = "//div[.= 'НРД']")
    private WebElement nrd;

    @FindBy(xpath = "//textarea[@name = 'counterpartyPlace']")
    private WebElement counterpartyName;

    @FindBy(xpath = "//input[@name = 'depoAccount']")
    private WebElement depoAccount;

    @FindBy(xpath = "//input[@name = 'depoSection']")
    private WebElement depoSection;

    @FindBy(xpath = "//input[@name = 'depoCode']")
    private WebElement depoCode;

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

    public DepoTransferOutPage chooseWithdraw() {
        webDriverWait.until(ExpectedConditions.visibilityOf(withdrawButton));
        withdrawButton.click();
        return new DepoTransferOutPage(driver);
    }

    public DepoTransferOutPage nextButtonClick() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.visibilityOf(nextButton));
        Thread.sleep(1000);
        actions.moveToElement(nextButton).click().build().perform();
        return new DepoTransferOutPage(driver);
    }

    public DepoTransferOutPage selectPlaceHolder() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(placeHolder));
        Thread.sleep(1000);
        actions.moveToElement(placeHolder).click().build().perform();
        return new DepoTransferOutPage(driver);
    }

    public DepoTransferOutPage chooseNrd() throws InterruptedException {
        Thread.sleep(1000);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(nrd));
        actions.moveToElement(nrd).click().build().perform();
        return new DepoTransferOutPage(driver);
    }

    public DepoTransferOutPage insertCounterPartyFields() {
        webDriverWait.until(ExpectedConditions.visibilityOf(counterpartyName));
        counterpartyName.sendKeys("ООО «АТОН»");
        depoAccount.sendKeys("HL1212116750");
        depoSection.sendKeys("36MC0031400000F00");
        depoCode.sendKeys("MC0031400000");
        return new DepoTransferOutPage(driver);
    }

    public DepoTransferOutPage chooseSecurity() {
        webDriverWait.until(ExpectedConditions.visibilityOf(securityField));
        securityField.sendKeys("Энел");
        webDriverWait.until(ExpectedConditions.visibilityOf(paper));
        paper.click();
        return new DepoTransferOutPage(driver);
    }

    public DepoTransferOutPage insertCountFiled() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(countFiled));
        countFiled.sendKeys("1");
        return new DepoTransferOutPage(driver);
    }

    public DepoTransferOutPage sendOrderButtonClick() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(sendOrderButton));
        actions.moveToElement(sendOrderButton).click().build().perform();
        return new DepoTransferOutPage(driver);
    }

    public DepoTransferOutPage checkSuccessNotify() {
        webDriverWait.until(ExpectedConditions.visibilityOf(successNotify));
        Assertions.assertTrue(successNotify.isDisplayed());
        return new DepoTransferOutPage(driver);
    }

}


