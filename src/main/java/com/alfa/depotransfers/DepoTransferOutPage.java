package com.alfa.depotransfers;

import com.alfa.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DepoTransferOutPage extends BasePage {
    public DepoTransferOutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[.= 'Списание']")
    private WebElement withdrawButton;

    @FindBy(xpath = "//span[@class='select-button__content'][.='Выберите позицию']")
    private WebElement choosePositionField;

    @FindBy(xpath = "//div[.='Портфель 1']")
    private WebElement accountNum;

    @FindBy(id = "security-name")
    private WebElement securityNameField;

    @FindBy(id = "security-amount")
    private WebElement securityAmountField;

    @FindBy(xpath = "//div[.='RU000A0JNAB6 / 1-01-08902-A']")
    private WebElement securityIsinName;

    @FindBy(xpath = "//button[@class='select-button select-button_size_m select-button_theme_alfa-on-white']/span/span[.='Выберите место хранения']")
    private WebElement securityStorage;

    @FindBy(xpath = "//div[.='АО Альфа-Банк']")
    private WebElement securityAlfaStorage;

    @FindBy(id = "withdraw-despository-bank-broker-name")
    private WebElement withdrawDepoBrokerNameField;

    @FindBy(id = "withdraw-depo-account-num")
    private WebElement withdrawDepoAccountNameField;

    @FindBy(id = "withdraw-tariff-checkbox")
    private WebElement withdrawTarifCheckBox;

    @FindBy(id = "withdraw-send-transfer-request")
    private WebElement withdrawSendTransferButton;

    @FindBy(xpath = "//div[@class='notification__content']/div/span[.='Поручение принято к исполнению']")
    private WebElement successNotify;

    public DepoTransferOutPage chooseWithdraw() {
        webDriverWait.until(ExpectedConditions.visibilityOf(withdrawButton));
        withdrawButton.click();
        return new DepoTransferOutPage(driver);
    }

    public DepoTransferOutPage choosePosition() {
        webDriverWait.until(ExpectedConditions.visibilityOf(choosePositionField));
        choosePositionField.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(accountNum));
        accountNum.click();
        securityNameField.click();
        return new DepoTransferOutPage(driver);
    }

    public DepoTransferOutPage chooseSecurity() {
        webDriverWait.until(ExpectedConditions.visibilityOf(securityIsinName));
        securityIsinName.click();
        securityAmountField.sendKeys("11");
        return new DepoTransferOutPage(driver);
    }

    public DepoTransferOutPage chooseCounterparty() {
        securityStorage.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(securityAlfaStorage));
        securityAlfaStorage.click();
        withdrawDepoBrokerNameField.sendKeys("Атон");
        withdrawDepoAccountNameField.sendKeys("1111ОHTRRRR");
        return new DepoTransferOutPage(driver);
    }

    public DepoTransferOutPage clickWithDrawTarifCheckbox() {
        WebElement element = withdrawTarifCheckBox;
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        return new DepoTransferOutPage(driver);
    }

    public DepoTransferInPage clickTransferButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(withdrawSendTransferButton));
        withdrawSendTransferButton.click();
        return new DepoTransferInPage(driver);
    }

    public DepoTransferInPage checkSuccessNotify() {
        webDriverWait.until(ExpectedConditions.visibilityOf(successNotify));
        Assertions.assertTrue(successNotify.isDisplayed());
        return new DepoTransferInPage(driver);
    }
}


