package com.alfa.documents;

import com.alfa.ArbitraryOrders;
import com.alfa.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DocumentsOrderPage extends BasePage {
    public DocumentsOrderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[text()='Выберите документ']")
    private WebElement chooseDocument;

    @FindBy(xpath = "//*[text()='Отчёт']")
    private WebElement report;

    @FindBy(xpath = "//*[text()='Справка 2НДФЛ']")
    private WebElement twoNDFL;

    @FindBy(xpath = "//*[text()='Выписка о движении бумаг']")
    private WebElement statementOfMovement;

    @FindBy(xpath = "//*[text()='Выписка по счету Депо']")
    private WebElement statementOfDepoAccount;

    @FindBy(xpath = "//*[text()='Отчет о выплаченных доходах']")
    private WebElement incomeStatement;

    @FindBy(xpath = "//*[text()='Документы об открытии брокерского счета']")
    private WebElement accountsDocument;

    @FindBy(xpath = "//*[text()='Уведомление о признании квалифицированным инвестором']")
    private WebElement qualificationNotice;

    @FindBy(xpath = "//*[text()='Уведомление о расторжении ГС']")
    private WebElement terminationNotice;

    @FindBy(xpath = "//span/span/span[.='Выберите тип отчёта']")
    private WebElement orderType;

    @FindBy(xpath = "//span[.='Мой портфель']")
    private WebElement myCase;

    @FindBy(xpath = "//span[.='Брокерский отчет']")
    private WebElement brokerageReport;

    @FindBy(xpath = "//span[.='Справка-расчет']")
    private WebElement referenceCalculation;

    @FindBy(xpath = "//span[.='Детальный расчет']")
    private WebElement detailedСalculation;

    @FindBy(xpath = "//span[.='Отчет о движении денежных средств']")
    private WebElement moveReport;

    @FindBy(xpath = "//span[.='Способ получения']")
    private WebElement wayToGetList;

    @FindBy(xpath = "//span[.='В офисе Альфа-Банка']")
    private WebElement wayToGetOffice;

    @FindBy(xpath = "//span[.='На почтовый адрес']")
    private WebElement wayToGetPost;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "office")
    private WebElement officeField;

    @FindBy(id = "comment")
    private WebElement commentField;

    @FindBy(id = "offer-offline-documents")
    private WebElement offerDocumentsButton;

    @FindBy(xpath = "//div[contains(@class, 'notification_status_ok')]")
    private WebElement successNotify;



    public DocumentsOrderPage chooseReportDocument() {
        webDriverWait.until(ExpectedConditions.visibilityOf(chooseDocument));
        chooseDocument.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(report));
        report.click();
        return new DocumentsOrderPage(driver);
    }

    public DocumentsOrderPage chooseMyCaseReport() {
        webDriverWait.until(ExpectedConditions.visibilityOf(orderType));
        orderType.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(myCase));
        myCase.click();
        return new DocumentsOrderPage(driver);
    }

    public DocumentsOrderPage chooseBrokerageReport() {
        webDriverWait.until(ExpectedConditions.visibilityOf(orderType));
        orderType.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(brokerageReport));
        brokerageReport.click();
        return new DocumentsOrderPage(driver);
    }

    public DocumentsOrderPage chooseReferenceCalculationReport() {
        webDriverWait.until(ExpectedConditions.visibilityOf(orderType));
        orderType.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(referenceCalculation));
        referenceCalculation.click();
        return new DocumentsOrderPage(driver);
    }

    public DocumentsOrderPage chooseDetailedСalculationReport() {
        webDriverWait.until(ExpectedConditions.visibilityOf(orderType));
        orderType.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(detailedСalculation));
        detailedСalculation.click();
        return new DocumentsOrderPage(driver);
    }

    public DocumentsOrderPage chooseMoveReport() {
        webDriverWait.until(ExpectedConditions.visibilityOf(orderType));
        orderType.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(moveReport));
        moveReport.click();
        return new DocumentsOrderPage(driver);
    }



    public DocumentsOrderPage chooseWayToGetOffice() {
        webDriverWait.until(ExpectedConditions.visibilityOf(wayToGetList));
        WebElement element = wayToGetList;
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        webDriverWait.until(ExpectedConditions.visibilityOf(wayToGetOffice));
        wayToGetOffice.click();
        return new DocumentsOrderPage(driver);
    }

    public DocumentsOrderPage chooseWayToGetPost() {
        webDriverWait.until(ExpectedConditions.visibilityOf(wayToGetList));
        WebElement element = wayToGetList;
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        webDriverWait.until(ExpectedConditions.visibilityOf(wayToGetPost));
        wayToGetPost.click();
        return new DocumentsOrderPage(driver);
    }

    public DocumentsOrderPage insertOfficeFields() {
        webDriverWait.until(ExpectedConditions.visibilityOf(cityField));
        cityField.sendKeys("Чебоксары");
        officeField.sendKeys("ул Ярославская, д.27");
        commentField.sendKeys("Тестовый комментарий");
        return new DocumentsOrderPage(driver);
    }

    public DocumentsOrderPage clickOfferDocumentsButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(offerDocumentsButton));
        offerDocumentsButton.click();
        return new DocumentsOrderPage(driver);
    }

    public DocumentsOrderPage checkFirstSuccessNotify() {
        webDriverWait.until(ExpectedConditions.visibilityOf(successNotify));
        return new DocumentsOrderPage(driver);
    }


    public DocumentsOrderPage checkFinalSuccessNotify() {
        webDriverWait.until(ExpectedConditions.visibilityOf(successNotify));
        Assertions.assertTrue(successNotify.isDisplayed());
        return new DocumentsOrderPage(driver);
    }


}
