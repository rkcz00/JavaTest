package com.alfa.profile;

import com.alfa.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PassportDataPage extends BasePage {
    public PassportDataPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//span/span[.='Дата рождения']")
    private WebElement dateOfBirth;

    @FindBy(xpath = "//span/span[.='Документ']")
    private WebElement document;

    @FindBy(xpath = "//span/span[.='Зарегистрирован по адресу']")
    private WebElement registrationAddress;


    public void checkPassportData() {
        webDriverWait.until(ExpectedConditions.visibilityOf(dateOfBirth));
        Assertions.assertTrue(dateOfBirth.isDisplayed());
        Assertions.assertTrue(document.isDisplayed());
        Assertions.assertTrue(registrationAddress.isDisplayed());
    }
}
