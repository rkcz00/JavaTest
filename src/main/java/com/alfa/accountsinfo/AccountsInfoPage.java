package com.alfa.accountsinfo;

import com.alfa.BasePage;
import com.alfa.depotransfers.DepoTransferInnerPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AccountsInfoPage extends BasePage {
    public AccountsInfoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span/span[.= 'Крылов Глеб Люциферович']")
    private WebElement owner;

    @FindBy(xpath = "//span[contains(text(), '30601810000021081677')]")
    private WebElement rubAcc;

    @FindBy(xpath = "//span[contains(text(), '30601840300021081677')]")
    private WebElement usdAcc;

    @FindBy(xpath = "//span[contains(text(), '30601978900021081677')]")
    private WebElement eurAcc;

    @FindBy(xpath = "//span[contains(text(), 'БBIOM1000')]")
    private WebElement kcbAcc;

    @FindBy(xpath = "//span[contains(text(), 'БBIOS1000')]")
    private WebElement spbAcc;

    @FindBy(xpath = "//a[.= 'Управление счётом']")
    private WebElement accountManagementTab;

    @FindBy(xpath = "//span/span[.= 'Добавить субсчет']")
    private WebElement adSubAccountButton;

    @FindBy(xpath = "//div[contains(@class, 'notification_status_ok')]")
    private WebElement successNotify;

    @FindBy(xpath = "//button[@id= 'redact-subaccount']")
    private WebElement redactSubAccountButton;

    @FindBy(id = "subbaccount-redact-name")
    private WebElement redactSubAccountNameField;

    @FindBy(id = "subaccount-save")
    private WebElement subaccountSaveButton;

    @FindBy(id = "count")
    private WebElement fioField;

    @FindBy(id = "comment")
    private WebElement loginField;

    @FindBy(id = "doc-number")
    private WebElement docNumberField;

    @FindBy(xpath = "//button/span/span[.= 'Оформить доверенность']")
    private WebElement createAttorneyButton;

    @FindBy(xpath = "//button[@class = 'button button_icon button_size_m button_theme_alfa-on-white']//span[@class = 'icon confidants__delete-icon icon_close icon_size_s icon_theme_alfa-on-white']")
    private WebElement cancelAttorneyButton;

    @FindBy (xpath = "//button[.= 'Продолжить']")
    private WebElement nextButton;

    @FindBy(id = "do-order")
    private WebElement doOrderButton;


    public AccountsInfoPage waitInfoDownload() {
        webDriverWait.until(ExpectedConditions.visibilityOf(owner));
        webDriverWait.until(ExpectedConditions.visibilityOf(rubAcc));
        webDriverWait.until(ExpectedConditions.visibilityOf(usdAcc));
        webDriverWait.until(ExpectedConditions.visibilityOf(eurAcc));
        webDriverWait.until(ExpectedConditions.visibilityOf(kcbAcc));
        webDriverWait.until(ExpectedConditions.visibilityOf(spbAcc));
        return new AccountsInfoPage(driver);
    }

    public AccountsInfoPage accountManagementTabClick() {
        webDriverWait.until(ExpectedConditions.visibilityOf(accountManagementTab));
        accountManagementTab.click();
        return new AccountsInfoPage(driver);
    }

    public AccountsInfoPage adSubAccountButtonClick() {
        webDriverWait.until(ExpectedConditions.visibilityOf(adSubAccountButton));
        adSubAccountButton.click();
        return new AccountsInfoPage(driver);
    }

    public AccountsInfoPage redactSubAccountButtonClick() {
        webDriverWait.until(ExpectedConditions.visibilityOf(adSubAccountButton));
        List<WebElement> buttonsList = driver.findElements(By.xpath("//button[@id= 'redact-subaccount']"));
        actions.moveToElement(buttonsList.get(0)).click().build().perform();
        return new AccountsInfoPage(driver);
    }

    public AccountsInfoPage insertNewName() {
        webDriverWait.until(ExpectedConditions.visibilityOf(redactSubAccountNameField));
        redactSubAccountNameField.sendKeys(Keys.CONTROL + "a");
        redactSubAccountNameField.sendKeys(Keys.DELETE);
        redactSubAccountNameField.sendKeys("Autotest " + (int) (Math.random() * 90 + 100));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(subaccountSaveButton));
        subaccountSaveButton.click();
        return new AccountsInfoPage(driver);
    }

    public AccountsInfoPage createAttorneyButtonClick() {
        webDriverWait.until(ExpectedConditions.visibilityOf(createAttorneyButton));
        actions.moveToElement(createAttorneyButton).click().build().perform();
//        createAttorneyButton.click();
        return new AccountsInfoPage(driver);
    }

    public AccountsInfoPage insertAttorneyFields() {
        webDriverWait.until(ExpectedConditions.visibilityOf(fioField));
        fioField.sendKeys("Попов Мстислав Иосифович");
        loginField.sendKeys("t_eq_mipopov");
        docNumberField.sendKeys("7232487942");
        doOrderButton.click();
        return new AccountsInfoPage(driver);
    }

    public AccountsInfoPage cancelAttorney() {
        webDriverWait.until(ExpectedConditions.visibilityOf(cancelAttorneyButton));
        actions.moveToElement(cancelAttorneyButton).click().build().perform();
        webDriverWait.until(ExpectedConditions.visibilityOf(nextButton));
        nextButton.click();
        return new AccountsInfoPage(driver);
    }

    public AccountsInfoPage checkSuccessResult() {
        Assertions.assertTrue(owner.isDisplayed());
        return new AccountsInfoPage(driver);
    }

    public AccountsInfoPage checkSuccessNotify() {
        webDriverWait.until(ExpectedConditions.visibilityOf(successNotify));
        Assertions.assertTrue(successNotify.isDisplayed());
        return new AccountsInfoPage(driver);
    }
}
