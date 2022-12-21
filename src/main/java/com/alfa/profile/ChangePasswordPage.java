package com.alfa.profile;

import com.alfa.BasePage;
import com.alfa.moneytransfers.OtherBankPage;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ChangePasswordPage extends BasePage {
    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "password-confirmation")
    private WebElement passwordConfirmationField;

    @FindBy(id = "request-password-change")
    private WebElement passwordChangeButton;

    @FindBy(xpath = "//div[contains(@class, 'notification_status_ok')]")
    private WebElement successNotify;

    public ChangePasswordPage setNewPassword() {
        webDriverWait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys("Fest123");
        passwordConfirmationField.sendKeys("Fest123");
        return new ChangePasswordPage(driver);
    }

    public ChangePasswordPage clickPasswordChangeButton(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(passwordChangeButton));
        passwordChangeButton.click();
        return new ChangePasswordPage(driver);
    }

    public ChangePasswordPage checkSuccessNotify() {
        webDriverWait.until(ExpectedConditions.visibilityOf(successNotify));
        Assertions.assertTrue(successNotify.isDisplayed());
        return new ChangePasswordPage(driver);
    }
}


