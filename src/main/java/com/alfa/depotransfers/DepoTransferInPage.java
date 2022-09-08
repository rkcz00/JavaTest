package com.alfa.depotransfers;

import com.alfa.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DepoTransferInPage extends BasePage {
    public DepoTransferInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "security-name")
    private WebElement securityNameField;

    @FindBy(xpath = "//div[.='RU000A0JP5V6 / 10401000B']")
    private WebElement securityVTBInList;

    @FindBy(id = "security-amount")
    private WebElement securityAmountField;

    @FindBy(xpath = "//button[@class='select-button select-button_size_m select-button_theme_alfa-on-white']/span/span[.='Выберите место хранения']")
    private WebElement securityStorage;

    @FindBy(xpath = "//div[.='АО Альфа-Банк']")
    private WebElement securityAlfaStorage;

    @FindBy(id = "despository-bank-broker-name")
    private WebElement bankBrokerNameField;

    @FindBy(id = "depo-account-num")
    private WebElement depoAccountNameField;

    @FindBy(id = "tarif-checkbox")
    private WebElement tarifCheckBox;

    @FindBy(id = "send-transfer-request")
    private WebElement sendTransferButton;

    @FindBy(xpath = "//div[@class='notification__content']/div/span[.='Поручение принято к исполнению']")
    private WebElement successNotify;

    @FindBy(xpath = "//a[.= 'Пакетное зачисление']")
    private WebElement batchEnrollment;

    @FindBy(xpath = "//span[@class='select-button__text']/span[.= 'Выберите субсчёт']")
    private WebElement subAccount;

    @FindBy(xpath = "//span[.='1048654-000']")
    private WebElement subAccountNum;

    @FindBy(xpath = "//span[@class='select-button__text']/span[.='Выберите рынок']")
    private WebElement chooseMarket;

    @FindBy(xpath = "//div[contains(@class, 'white')]/span[.='Московская биржа (НРД)']")
    private WebElement moscowExchange;

    @FindBy(xpath = "//div[.='RU0009024277 / 1-01-00077-A']")
    private WebElement securityLukoilInList;

    @FindBy(xpath = "//button[contains(@class, 'white')]/span/span[.='Добавить ещё одну']")
    private WebElement addOneMoreButton;

    @FindBy(xpath = "//div[.='RU0007661625 / 1-02-00028-A']")
    private WebElement securityGazpromInList;

    @FindBy(xpath = "//button[contains(@class, 'white')]/span/span[.='Выберите контрагента']")
    private WebElement counterParty;

    @FindBy(xpath = "//div/span[.='ООО «АТОН»']")
    private WebElement counterPartyAton;

    public DepoTransferInPage insertSecurity() {
        webDriverWait.until(ExpectedConditions.visibilityOf(securityNameField));
        securityNameField.sendKeys("Втб");
        webDriverWait.until(ExpectedConditions.visibilityOf(securityVTBInList));
        securityVTBInList.click();
        securityAmountField.sendKeys("88");
        return new DepoTransferInPage(driver);
    }

    public DepoTransferInPage chooseCounterparty() {
        WebElement element = securityStorage;
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        webDriverWait.until(ExpectedConditions.visibilityOf(securityAlfaStorage));
        securityAlfaStorage.click();
        bankBrokerNameField.sendKeys("Контрагент");
        depoAccountNameField.sendKeys("2050100000");
        return new DepoTransferInPage(driver);
    }

    public DepoTransferInPage clickTarifCheckbox() {
        WebElement element = tarifCheckBox;
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        return new DepoTransferInPage(driver);
    }

    public DepoTransferInPage clickTransferButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(sendTransferButton));
        sendTransferButton.click();
        return new DepoTransferInPage(driver);
    }

    public DepoTransferInPage checkSuccessNotify() {
        webDriverWait.until(ExpectedConditions.visibilityOf(successNotify));
        Assertions.assertTrue(successNotify.isDisplayed());
        return new DepoTransferInPage(driver);
    }

    public DepoTransferInPage selectBatchEnrollment() {
        webDriverWait.until(ExpectedConditions.visibilityOf(batchEnrollment));
        batchEnrollment.click();
        return new DepoTransferInPage(driver);
    }

    public DepoTransferInPage selectSubAccount() {
        webDriverWait.until(ExpectedConditions.visibilityOf(subAccount));
        subAccount.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(subAccountNum));
        subAccountNum.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(chooseMarket));
        chooseMarket.click();
        List<WebElement> rialtoList = driver.findElements(
                By.xpath("//div[contains(@class, 'white')]/span[.='Московская биржа (НРД)']"));;
        rialtoList.get(1).click();
        return new DepoTransferInPage(driver);

    }

    public DepoTransferInPage insertMassSecurity() {
        webDriverWait.until(ExpectedConditions.visibilityOf(securityNameField));
        securityNameField.sendKeys("Лукойл");
        webDriverWait.until(ExpectedConditions.visibilityOf(securityLukoilInList));
        securityLukoilInList.click();
        securityAmountField.sendKeys("11");
        webDriverWait.until(ExpectedConditions.visibilityOf(addOneMoreButton));
        addOneMoreButton.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(securityNameField));
        securityNameField.sendKeys("Газпром");
        webDriverWait.until(ExpectedConditions.visibilityOf(securityGazpromInList));
        securityGazpromInList.click();
        securityAmountField.sendKeys("22");
        return new DepoTransferInPage(driver);
    }

    public DepoTransferInPage chooseMassCounterparty(){
        webDriverWait.until(ExpectedConditions.visibilityOf(counterParty));
        counterParty.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(counterPartyAton));
        counterPartyAton.click();
        return new DepoTransferInPage(driver);
    }
}
