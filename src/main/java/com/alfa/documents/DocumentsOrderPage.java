package com.alfa.documents;

import com.alfa.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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


}
