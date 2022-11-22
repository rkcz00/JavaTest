package com.alfa.profile;

import com.alfa.BasePage;
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

    public void ChangePasswordPage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys("Test123");
        passwordConfirmationField.sendKeys("Test123");
    }

    public void clickPasswordChangeButton(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(passwordChangeButton));
        passwordChangeButton.click();
    }
}


