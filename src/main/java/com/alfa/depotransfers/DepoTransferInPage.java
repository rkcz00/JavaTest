package com.alfa.depotransfers;

import com.alfa.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DepoTransferInPage extends BasePage {
    public DepoTransferInPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//span[.= 'Продолжить']")
    private WebElement nextButton;

    @FindBy(xpath = "//span[.= 'Выберите место хранения']")
    private WebElement placeHolder;

    @FindBy(xpath = "//div[.= 'Реестр']")
    private WebElement reestr;

    @FindBy(xpath = "//input[@aria-label='Лицевой счет']")
    private WebElement personalAccount;

    @FindBy(xpath = "//span[contains(@class, 'checkbox__box')]")
    private WebElement checkBox;

    @FindBy(xpath = "//input[contains(@id, 'downs')]")
    private WebElement securityField;

    @FindBy(xpath = "//div[.= 'AT&T INC., а.о., US00206R1023, Акции обыкновенные']")
    private WebElement attPaper;

    @FindBy(xpath = "//div[contains(text(), 'Bristol')]")
    private WebElement bristolPaper;

    @FindBy(xpath = "//div[contains(text(), 'Verizon')]")
    private WebElement verizonPaper;

    @FindBy(xpath = "//input[@aria-label = 'Количество']")
    private WebElement countFiled;

    @FindBy(xpath = "//span[.= 'Подать поручение']")
    private WebElement sendOrderButton;

    @FindBy(xpath = "//div[contains(@class, 'notification_status_ok')]")
    private WebElement successNotify;

    @FindBy(xpath = "//input[@name = 'orgOGRN']")
    private WebElement ogrn;

    @FindBy(xpath = "//span[.= 'Добавить ценные бумаги']")
    private WebElement addSecuritiesButton;

    @FindBy(xpath = "//span[.= 'Добавить ценную бумагу']")
    private WebElement addSecurityButton;

    @FindBy(xpath = "//span[.= 'В список к зачислению']")
    private WebElement forEnrollmentButton;

    @FindBy(xpath = "//div[contains(text(), 'НРД')]")
    private WebElement nrd;

    @FindBy(xpath = "//textarea[@name = 'counterpartyPlace']")
    private WebElement counterpartyName;

    @FindBy(xpath = "//input[@name = 'depoAccount']")
    private WebElement depoAccount;

    @FindBy(xpath = "//input[@name = 'depoSection']")
    private WebElement depoSection;

    @FindBy(xpath = "//input[@name = 'depoCode']")
    private WebElement depoCode;


    public DepoTransferInPage nextButtonClick() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.visibilityOf(nextButton));
        Thread.sleep(1000);
        actions.moveToElement(nextButton).click().build().perform();
        return new DepoTransferInPage(driver);
    }

    public DepoTransferInPage selectPlaceHolder() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(placeHolder));
        Thread.sleep(1000);
        actions.moveToElement(placeHolder).click().build().perform();
        return new DepoTransferInPage(driver);
    }

    public DepoTransferInPage chooseReestr() throws InterruptedException {
        Thread.sleep(1000);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(reestr));
        actions.moveToElement(reestr).click().build().perform();
        return new DepoTransferInPage(driver);
    }

    public DepoTransferInPage sendPesonalAccount() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(personalAccount));
        personalAccount.sendKeys("40235677777111");
        ogrn.sendKeys("1037728063515");
        checkBox.click();
        return new DepoTransferInPage(driver);
    }

    public DepoTransferInPage chooseSecurity() {
        webDriverWait.until(ExpectedConditions.visibilityOf(securityField));
        securityField.sendKeys("AT");
        webDriverWait.until(ExpectedConditions.visibilityOf(attPaper));
        attPaper.click();
        return new DepoTransferInPage(driver);
    }



    public DepoTransferInPage insertCountFiled() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(countFiled));
        countFiled.sendKeys("1");
        return new DepoTransferInPage(driver);
    }

    public DepoTransferInPage addSecurities() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addSecuritiesButton));
        actions.moveToElement(addSecuritiesButton).click().build().perform();
//        addSecuritiesButton.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addSecurityButton));
        actions.moveToElement(addSecurityButton).click().build().perform();
//        addSecurityButton.click();
        Thread.sleep(1000);
        webDriverWait.until(ExpectedConditions.visibilityOf(securityField));
        securityField.sendKeys("Bristol");
        webDriverWait.until(ExpectedConditions.visibilityOf(bristolPaper));
        bristolPaper.click();
        insertCountFiled();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(forEnrollmentButton));
        actions.moveToElement(forEnrollmentButton).click().build().perform();
//        forEnrollmentButton.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addSecurityButton));
        actions.moveToElement(addSecurityButton).click().build().perform();
//        addSecurityButton.click();
        Thread.sleep(1000);
        webDriverWait.until(ExpectedConditions.visibilityOf(securityField));
        securityField.sendKeys("Ver");
        webDriverWait.until(ExpectedConditions.visibilityOf(verizonPaper));
        verizonPaper.click();
        insertCountFiled();
        actions.moveToElement(forEnrollmentButton).click().build().perform();
//        forEnrollmentButton.click();
        return new DepoTransferInPage(driver);
    }



    public DepoTransferInPage sendOrderButtonClick() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(sendOrderButton));
        actions.moveToElement(sendOrderButton).click().build().perform();
        return new DepoTransferInPage(driver);
    }

    public DepoTransferInPage checkSuccessNotify() {
        webDriverWait.until(ExpectedConditions.visibilityOf(successNotify));
        Assertions.assertTrue(successNotify.isDisplayed());
        return new DepoTransferInPage(driver);
    }

    public DepoTransferInPage chooseNrd() throws InterruptedException {
        Thread.sleep(1000);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(nrd));
        actions.moveToElement(nrd).click().build().perform();
        return new DepoTransferInPage(driver);
    }

    public DepoTransferInPage insertCounterPartyFields() {
        webDriverWait.until(ExpectedConditions.visibilityOf(counterpartyName));
        counterpartyName.sendKeys("ООО «АТОН»");
        depoAccount.sendKeys("HL1212116750");
        depoSection.sendKeys("36MC0031400000F00");
        depoCode.sendKeys("MC0031400000");
        return new DepoTransferInPage(driver);
    }
}
