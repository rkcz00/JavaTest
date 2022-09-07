package com.alfa.registrationfirm;

import com.alfa.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FirmAnketaPage extends BasePage {
    public FirmAnketaPage(WebDriver driver) {
        super(driver);
    }

    int a = (int) (Math.random() * 900 + 1000);

    @FindBy(id = "search")
    private WebElement searchField;

    @FindBy(id = "manual-link")
    private WebElement manualLink;

    @FindBy(id = "inn")
    private WebElement innField;

    @FindBy(id = "ogrn")
    private WebElement ogrnField;

    @FindBy(id = "firm-inn-submit")
    private WebElement firmInnButton;

    @FindBy(id = "full-name")
    private WebElement fullNameField;

    @FindBy(id = "short-name")
    private WebElement shortNameField;

    @FindBy(id = "head-full-name")
    private WebElement headFullNameField;

    @FindBy(id = "head-end-term")
    private WebElement headEndTermField;

    @FindBy(id = "reg-date")
    private WebElement regDateField;

    @FindBy(id = "reg-ogrn")
    private WebElement regOgrnField;

    @FindBy(id = "search-legalAddress")
    private WebElement searchLegalAddressField;

    @FindBy(xpath = "//span[@class='menu-item__control']")
    private WebElement listAddressLink;

    @FindBy(xpath = "//*[text()='Да, совпадает']")
    private WebElement coincidenceButton;

    @FindBy(id = "license-series-number")
    private WebElement licenseSeriesNumberField;

    @FindBy(id = "license-issue-date")
    private WebElement licenseIssueDateField;

    @FindBy(id = "license-issue-authority")
    private WebElement licenseIssueAuthorityField;

    @FindBy(id = "license-activities")
    private WebElement licenseActivitiesField;

    @FindBy(id = "license-valid-to")
    private WebElement licenseValidToField;

    @FindBy(id = "license-site")
    private WebElement licenseSiteField;

    @FindBy(xpath = "//*[text()='Добавить ещё одну']")
    private WebElement addOneButton;

    @FindBy(id = "phone")
    private WebElement phoneField;

    @FindBy(id = "add-phone")
    private WebElement addPhoneField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "firm-info-submit")
    private WebElement firmInfoSubmitButton;

    @FindBy(xpath = "//*[text()='Режим совершения сделок']")
    private WebElement transactionMode;

    @FindBy(id = "end-submit")
    private WebElement endSubmitButton;

    @FindBy(xpath = "//img")
    private WebElement successImage;

    public FirmAnketaPage insertBaseFirmInfo(){
        webDriverWait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.sendKeys("ООО Анкор");
        manualLink.click();
        innField.sendKeys("111111" + a);
        ogrnField.sendKeys("222222222" + a);
        firmInnButton.click();
        return new FirmAnketaPage(driver);
    }

    public FirmAnketaPage insertCommonFirmInfo(){
        webDriverWait.until(ExpectedConditions.visibilityOf(fullNameField));
        fullNameField.sendKeys("ООО Анкор " + a);
        shortNameField.sendKeys("ООО Анкор " + a);
        innField.sendKeys("111111" + a);
        return new FirmAnketaPage(driver);
    }



    public FirmAnketaPage insertCeoInfo(){
        headFullNameField.sendKeys("Храпченко Людмила Валерьевна");
        headEndTermField.sendKeys("15.02.2025");
        return new FirmAnketaPage(driver);
    }

    public FirmAnketaPage insertRegDateInfo(){
        ogrnField.sendKeys("1111111111111");
        regDateField.sendKeys("15.02.2017");
        regOgrnField.sendKeys("ФНС");
        return new FirmAnketaPage(driver);
    }

    public FirmAnketaPage insertLegalAddress(){
        searchLegalAddressField.sendKeys("428024, Чувашия, Чебоксары, Эгерский бульвар, д. 5, к. 1");
        webDriverWait.until(ExpectedConditions.visibilityOf(listAddressLink));
        listAddressLink.click();
        coincidenceButton.click();
        return new FirmAnketaPage(driver);
    }

    public FirmAnketaPage insertLicenseInfo(){
        licenseSeriesNumberField.sendKeys("11" + a);
        licenseIssueDateField.sendKeys("11.01.2020");
        licenseIssueAuthorityField.sendKeys("ФНС");
        licenseActivitiesField.sendKeys("Деятельность1, Деятельность2");
        licenseValidToField.sendKeys("11.01.2030");
        licenseSiteField.sendKeys("www.rt.ru");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addOneButton));
        addOneButton.click();
        licenseSeriesNumberField.sendKeys("22" + a);
        licenseIssueDateField.sendKeys("22.02.2020");
        licenseIssueAuthorityField.sendKeys("ФНС");
        licenseActivitiesField.sendKeys("Деятельность3, Деятельность4");
        licenseValidToField.sendKeys("22.02.2030");
        licenseSiteField.sendKeys("www.crteert.ru");
        return new FirmAnketaPage(driver);
    }

    public FirmAnketaPage insertMoreInfo(){
        phoneField.sendKeys("+7 777 777 77 77");
        addPhoneField.sendKeys("+7 888 888 88 88");
        emailField.sendKeys("rt@m.ru");
        return new FirmAnketaPage(driver);
    }

    public FirmAnketaPage clickSubmitButton(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(firmInfoSubmitButton));
        firmInfoSubmitButton.click();
        return new FirmAnketaPage(driver);
    }

    public FirmAnketaPage acceptTransactionMode(){
        webDriverWait.until(ExpectedConditions.visibilityOf(transactionMode));
        endSubmitButton.click();
        return new FirmAnketaPage(driver);
    }

    public void checkSuccessFirmRegistration(){
        webDriverWait.until(ExpectedConditions.visibilityOf(successImage));
        Assertions.assertTrue(successImage.isDisplayed());
    }
}
