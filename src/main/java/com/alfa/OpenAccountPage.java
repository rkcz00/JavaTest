package com.alfa;

import com.alfa.authorize.LoginPage;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class OpenAccountPage extends BasePage {
    public OpenAccountPage(WebDriver driver) throws IOException, ParseException {
        super(driver);
    }

    CreateNewUser newUser = new CreateNewUser();

    @FindBy(id = "register-name-surname")
    private WebElement surnameField;

    @FindBy(id = "register-name-name")
    private WebElement nameField;

    @FindBy(id = "register-name-secondname")
    private WebElement secondNameField;

    @FindBy(id = "phone")
    private WebElement phoneField;

    @FindBy(id = "on-line-bank-btn")
    private WebElement nextButton;

    @FindBy(xpath = "//input[@type='tel']")
    private WebElement sendPassportSmsForm;

    @FindBy(xpath = "//h4[.= 'Ваши регистрационные данные']")
    private WebElement accData;

    @FindBy(xpath = "//button/span[.='Открыть брокерский счёт']")
    private WebElement openAccountButton;

    @FindBy(xpath = "//input[@inputmode='numeric']")
    private WebElement sendSmsForm;

    @FindBy(id = "new-password")
    private WebElement newPasswordField;

    @FindBy(id = "repeat-password")
    private WebElement repeatPasswordField;

    @FindBy(id = "save-password")
    private WebElement savePasswordButton;

    @FindBy(xpath = "//h2[contains(text(), \'Вы открыли брокерский счет\')]")
    private WebElement successText;

    public OpenAccountPage insertUserData() throws IOException, ParseException {
        webDriverWait.until(ExpectedConditions.visibilityOf(surnameField));
        surnameField.sendKeys(newUser.getLastName());
        nameField.sendKeys(newUser.getName());
        secondNameField.sendKeys(newUser.getPatronymic());
        phoneField.sendKeys(newUser.getPhoneNumber());
        return new OpenAccountPage(driver);
    }

    public OpenAccountPage nextButtonClick() throws IOException, ParseException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();
        return new OpenAccountPage(driver);
    }

    public OpenAccountPage sendPassportSms() throws InterruptedException, IOException, ParseException {
        Thread.sleep(3000);
        sendPassportSmsForm.sendKeys("0000");
        return new OpenAccountPage(driver);
    }

    public OpenAccountPage openAccountButtonClick() throws IOException, ParseException {
        webDriverWait.until(ExpectedConditions.visibilityOf(accData));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(openAccountButton));
        openAccountButton.click();
        return new OpenAccountPage(driver);
    }

    public OpenAccountPage sendSms() throws IOException, ParseException {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@inputmode='numeric']")));
        sendSmsForm.sendKeys("11111");
        return new OpenAccountPage(driver);
    }

    public OpenAccountPage insertPass() throws IOException, ParseException {
        webDriverWait.until(ExpectedConditions.visibilityOf(newPasswordField));
        newPasswordField.sendKeys("Test123");
        repeatPasswordField.sendKeys("Test123");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(savePasswordButton));
        savePasswordButton.click();
        return new OpenAccountPage(driver);
    }

    public void checkSuccessText() {
        webDriverWait.until(ExpectedConditions.visibilityOf(successText));
        Assertions.assertTrue(successText.isDisplayed());
    }

}
