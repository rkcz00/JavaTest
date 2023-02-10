package com.alfa.authorize;

import com.alfa.BasePage;
import com.alfa.OpenAccountPage;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class RestorePassPage extends BasePage {


    public RestorePassPage(WebDriver driver) {
        super(driver);

    }


    @FindBy(id = "register-name-surname")
    private WebElement registerSurname;

    @FindBy(id = "register-name-name")
    private WebElement registerName;

    @FindBy(id = "register-name-secondname")
    private WebElement registerSecondName;

    @FindBy(id = "phone")
    private WebElement registerPhone;

    @FindBy(id = "on-line-bank-btn")
    private WebElement passRestoreButton;

    @FindBy(xpath = "//input[@type='tel']")
    private WebElement sendPassportSmsForm;

    @FindBy(xpath = "//input[@inputmode='numeric']")
    private WebElement sendSmsForm;

    public RestorePassPage insertSurname(String surname) {
        registerSurname.sendKeys(surname);
        return new RestorePassPage(driver);
    }

    public RestorePassPage insertName(String name) {
        registerName.sendKeys(name);
        return new RestorePassPage(driver);
    }

    public RestorePassPage insertSecondName(String secondname) {
        registerSecondName.sendKeys(secondname);
        return new RestorePassPage(driver);
    }

    public RestorePassPage insertPhone(String phone) {
        registerPhone.sendKeys(phone);
        return new RestorePassPage(driver);
    }

    public RestorePassPage clickRestorePassButton() {
        passRestoreButton.click();
        return new RestorePassPage(driver);
    }

    public ResetPassPage sendPassportSms() throws InterruptedException {
        Thread.sleep(3000);
        sendPassportSmsForm.sendKeys("0000");
        return new ResetPassPage(driver);
    }

    public ResetPassPage sendSms()  {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@inputmode='numeric']")));
        sendSmsForm.sendKeys("11111");
        return new ResetPassPage(driver);
    }

}
