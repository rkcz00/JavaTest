package com.alfa.moneytransfers;

import com.alfa.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.net.URISyntaxException;
import java.net.URL;

public class OtherBankPage extends BasePage {
    public OtherBankPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[text()='В другой банк']")
    private WebElement inTheOtherBank;

    @FindBy(id = "bic")
    private WebElement bicField;

    @FindBy(id = "account-to")
    private WebElement accountToField;

    @FindBy(xpath = "//*[text()='Назначение платежа']")
    private WebElement purposeOfPaymentLink;

    @FindBy(id = "additional-requisites")
    private WebElement purposeOfPaymentField;

    @FindBy(id = "amount")
    private WebElement amountField;

    @FindBy(id = "send-money")
    private WebElement sendMoneyButton;

    @FindBy(xpath = "//div[contains(@class, 'notification_status_ok')]")
    private WebElement successNotify;

    public OtherBankPage chooseInTheOtherBank(){
        webDriverWait.until(ExpectedConditions.visibilityOf(inTheOtherBank));
        inTheOtherBank.click();
        return new OtherBankPage(driver);
    }

    public OtherBankPage insertFields(){
        webDriverWait.until(ExpectedConditions.visibilityOf(bicField));
        bicField.sendKeys("044525229");
        accountToField.sendKeys("40444444444444444444");
        purposeOfPaymentLink.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(purposeOfPaymentField));
        purposeOfPaymentField.sendKeys("Тестовое назначение");
        amountField.sendKeys("100");
        return new OtherBankPage(driver);
    }

    public OtherBankPage clickSendMoney(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(sendMoneyButton));
        sendMoneyButton.click();
        return new OtherBankPage(driver);
    }

    public OtherBankPage pressKeys() throws URISyntaxException, FindFailed, InterruptedException {
        String filepath = "C:\\Users\\Selecty\\Documents\\";
        Screen s = new Screen();
        Pattern openDocumentBox = new Pattern(filepath + "1671565807319.png");

        Thread.sleep(1000);

        s.click(openDocumentBox);

//        URL resourceFolderURL = this.getClass().getClassLoader().getResource("images");
//        String basePath = resourceFolderURL.toURI().getPath() + "/";
//
//        s.wait(5.0);
//        s.click(basePath + "Button.PNG");
        return new OtherBankPage(driver);
    }

    public OtherBankPage checkSuccessNotify() {
        webDriverWait.until(ExpectedConditions.visibilityOf(successNotify));
        Assertions.assertTrue(successNotify.isDisplayed());
        return new OtherBankPage(driver);
    }
}
