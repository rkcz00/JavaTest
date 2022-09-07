package com.alfa.authorize;

import com.alfa.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationFirmPage extends BasePage {
    public RegistrationFirmPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "lastname")
    private WebElement lastnameField;

    @FindBy(id = "firstname")
    private WebElement firstnameField;

    @FindBy(id = "fullname")
    private WebElement fullnameField;

    @FindBy(id = "passport")
    private WebElement passportField;

    @FindBy(id = "phone")
    private WebElement phoneField;

    @FindBy(id = "registration-demo-submit")
    private WebElement registrationDemoButton;

    public RegistrationFirmPage fillingApplication (String lastname, String firstname, String fullname, String passport, String phone){
        webDriverWait.until(ExpectedConditions.visibilityOf(lastnameField));
        lastnameField.sendKeys(lastname);
        firstnameField.sendKeys(firstname);
        fullnameField.sendKeys(fullname);
        passportField.sendKeys(passport);
        phoneField.sendKeys(phone);
        return new RegistrationFirmPage(driver);
    }

    public RegistrationFirmPage clickRegistrationDemoButton(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(registrationDemoButton));
        registrationDemoButton.click();
        return new RegistrationFirmPage(driver);
    }
}
