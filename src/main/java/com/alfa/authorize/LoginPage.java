package com.alfa.authorize;

import com.alfa.BasePage;
import com.alfa.OpenAccountPage;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.List;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);

    }


    private final String loginIdLocator = "login";


    @FindBy(id = loginIdLocator)
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "authorize")
    private WebElement authorizeButton;

    @FindBy(xpath = "//input[@inputmode='numeric']")
    private WebElement sendSmsForm;

    @FindBy(xpath = "//span[@class = 'overlimit__title']")
    private WebElement overLimitSms;

    @FindBy(id = "replenishment")
    private WebElement successNotify;

    @FindBy(id = "password-restore")
    private WebElement passRestoreLink;

    @FindBy(id = "open-account")
    private WebElement openAccountButton;

    public LoginPage login(String login, String password) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loginIdLocator)));
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        authorizeButton.click();
        return new LoginPage(driver);
    }

    public LoginPage sendSms() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(sendSmsForm));
        List<WebElement> inputField = driver.findElements(By.xpath("//input[@inputmode = 'numeric']"));

        try {
            for (int i = 0; i < 5; i++) {
                inputField.get(i).sendKeys("1");
                Thread.sleep(100);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        return new LoginPage(driver);
    }

    public LoginPage sendIncorrectSms() {
        webDriverWait.until(ExpectedConditions.visibilityOf(sendSmsForm));
        for (int i = 0; i < 6; i++) {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(sendSmsForm));
            sendSmsForm.sendKeys("11112");
        }
        return new LoginPage(driver);
    }

    public LoginPage checkSuccessNotify() {
        webDriverWait.until(ExpectedConditions.visibilityOf(successNotify));
        Assertions.assertTrue(successNotify.isDisplayed());
        return new LoginPage(driver);
    }

    public LoginPage checkOverLimitSms() {
        webDriverWait.until(ExpectedConditions.visibilityOf(overLimitSms));
        Assertions.assertTrue(overLimitSms.isDisplayed());
        return new LoginPage(driver);
    }

    public RestorePassPage restorePassClick() {
        webDriverWait.until(ExpectedConditions.visibilityOf(passRestoreLink));
        passRestoreLink.click();
        return new RestorePassPage(driver);
    }

    public OpenAccountPage openaAccountButtonClick() throws IOException, ParseException {
        webDriverWait.until(ExpectedConditions.visibilityOf(openAccountButton));
        openAccountButton.click();
        return new OpenAccountPage(driver);
    }
}
