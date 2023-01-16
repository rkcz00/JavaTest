package com.alfa;

import com.alfa.depotransfers.DepoTransferOutPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ElectronicSignature extends BasePage{
    public ElectronicSignature(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "create-certificate")
    private WebElement createNewButton;

    @FindBy (id = "cancel-certificate")
    private WebElement cancelCertificateButton;

    @FindBy (id = "approve-certificate")
    private WebElement approveCertificateButton;

    @FindBy(xpath = "//div[contains(@class, 'notification_status_ok')]")
    private WebElement successNotify;


    public ElectronicSignature createNewSign(){
        webDriverWait.until(ExpectedConditions.visibilityOf(createNewButton));
        createNewButton.click();
        return new ElectronicSignature(driver);
    }

    public ElectronicSignature approveCertificate(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(approveCertificateButton));
        approveCertificateButton.click();
        return new ElectronicSignature(driver);
    }

    public ElectronicSignature cancelCertificate(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(cancelCertificateButton));
        cancelCertificateButton.click();
        return new ElectronicSignature(driver);
    }

    public ElectronicSignature checkSuccessNotify() {
        webDriverWait.until(ExpectedConditions.visibilityOf(successNotify));
        Assertions.assertTrue(successNotify.isDisplayed());
        return new ElectronicSignature(driver);
    }

}
