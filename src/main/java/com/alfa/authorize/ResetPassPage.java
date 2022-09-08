package com.alfa.authorize;

import com.alfa.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResetPassPage extends BasePage {


    public ResetPassPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "new-password")
    private WebElement newPassword;

    @FindBy(id = "repeat-password")
    private WebElement repeatPassword;

    @FindBy(xpath = "//div[@class='registration-password__button']")
    private WebElement registrationPasswordButton;

    @FindBy(id = "replenishment")
    private WebElement successNotify;

    public ResetPassPage insertNewPassword(String newPass) {
        webDriverWait.until(ExpectedConditions.visibilityOf(newPassword));
        newPassword.sendKeys(newPass);
        return new ResetPassPage(driver);
    }

    public ResetPassPage insertRepeatPassword(String repeatPass) {
        repeatPassword.sendKeys(repeatPass);
        return new ResetPassPage(driver);
    }


    public LoginPage clickResetPassButton() {
        registrationPasswordButton.click();
        return new LoginPage(driver);
    }

    public void checkSuccessReset() {
        webDriverWait.until(ExpectedConditions.visibilityOf(successNotify));
        Assertions.assertTrue(successNotify.isDisplayed());
    }

}
