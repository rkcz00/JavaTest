package com.alfa.profile;

import com.alfa.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactInfoPage extends BasePage {
    public ContactInfoPage(WebDriver driver) {
        super(driver);


    }

    @FindBy(id = "phone")
    private WebElement phoneField;

    @FindBy(id = "nick-name")
    private WebElement nickNameField;

    @FindBy(id = "save-chat-settings")
    private WebElement saveChatSettingsButton;

    @FindBy(xpath = "//div[@class='notification__content']/div/span[.='Настройки чата успешно изменены']")
    private WebElement successChatNotify;

    @FindBy(xpath = "//a[.= 'Паспортные данные']")
    private WebElement tabPassportData;

    @FindBy(xpath = "//a[.= 'Смена пароля']")
    private WebElement tabChangePassword;

    public ContactInfoPage checkPhoneVisibility() {
        webDriverWait.until(ExpectedConditions.visibilityOf(phoneField));
        return new ContactInfoPage(driver);
    }

    public ContactInfoPage insertNickName() {
        nickNameField.sendKeys("rtyu1234" + (Math.random()*9+10));
        return new ContactInfoPage(driver);
    }

    public ContactInfoPage saveChatSettingsButton() {
        saveChatSettingsButton.click();
        return new ContactInfoPage(driver);
    }

    public ContactInfoPage checkSuccessNotify() {
        webDriverWait.until(ExpectedConditions.visibilityOf(successChatNotify));
        Assertions.assertTrue(successChatNotify.isDisplayed());
        return new ContactInfoPage(driver);
    }

    public PassportDataPage chooseTabPassportData() {
        webDriverWait.until(ExpectedConditions.visibilityOf(tabPassportData));
        tabPassportData.click();
        return new PassportDataPage(driver);
    }

    public ChangePasswordPage chooseTabChangePassword() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(tabChangePassword));
        tabChangePassword.click();
        return new ChangePasswordPage(driver);
    }


}
