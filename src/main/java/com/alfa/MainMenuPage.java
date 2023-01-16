package com.alfa;

import com.alfa.profile.ContactInfoPage;
import com.alfa.tests.AllTestsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainMenuPage extends BasePage {

    public MainMenuPage(WebDriver driver) {
        super(driver);
    }

    boolean isDisplayed() {
        try {
            return driver.findElement(By.xpath("//button[@class='modal__close']")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @FindBy(xpath = "//div//*[text()='Переводы']")
    private WebElement mainMenuTransfers;

    @FindBy(xpath = "//div//*[text()='Деньги']")
    private WebElement mainMenuMoneyTransfers;

    @FindBy(xpath = "//*[text()='Ценные бумаги']")
    private WebElement mainMenuSecurities;

    @FindBy(xpath = "//*[text()='Электронная подпись']")
    private WebElement electronicSignature;

    @FindBy(xpath = "//*[text()='Ещё']")
    private WebElement moreButton;

    @FindBy(xpath = "//*[text()='Открыть новый счёт']")
    private WebElement openNewAccountButton;

    @FindBy(xpath = "//*[text()='Тестирование']")
    private WebElement testsButton;

    @FindBy(xpath = "//*[text()='Профиль']")
    private WebElement profileButton;

    @FindBy(xpath = "//*[text()='Произвольное поручение']")
    private WebElement arbitaryOrderButton;

    @FindBy(xpath = "//button[@class='modal__close']")
    private WebElement emailWindowCloseButton;

    @FindBy(xpath = "//*[text()='Документы и налоги']")
    private WebElement documentsAndTaxes;

//    @FindBy(xpath = "//div[contains(@class, 'email-verification-modal')]/button[@class= 'modal__close']")
//    private WebElement closeBlockedDepoButton;

    @FindBy(xpath = "//span/span[.='Перейти к списку активов']")
    private WebElement goToBlockedАssetsButton;

    public MainMenuPage checkEmailWindow() throws InterruptedException {
        Thread.sleep(4000);
        if (isDisplayed()) {
            webDriverWait.until(ExpectedConditions.visibilityOf(emailWindowCloseButton));
            emailWindowCloseButton.click();
        }
        return new MainMenuPage(driver);
    }

    public MainMenuPage goToBlockedАssets() {
        webDriverWait.until(ExpectedConditions.visibilityOf(goToBlockedАssetsButton));
        WebElement element = goToBlockedАssetsButton;
        actions.moveToElement(element).click().build().perform();
        return new MainMenuPage(driver);
    }

    public MainMenuPage chooseTransfers() {
        webDriverWait.until(ExpectedConditions.visibilityOf(mainMenuTransfers));
        mainMenuTransfers.click();
        return new MainMenuPage(driver);
    }

    public MainMenuPage chooseMoneyTransfers() {
        webDriverWait.until(ExpectedConditions.visibilityOf(mainMenuMoneyTransfers));
        mainMenuMoneyTransfers.click();
        return new MainMenuPage(driver);
    }

    public MainMenuPage chooseSecurities() {
        webDriverWait.until(ExpectedConditions.visibilityOf(mainMenuSecurities));
        mainMenuSecurities.click();
        return new MainMenuPage(driver);
    }

    public MainMenuPage chooseMore() {
        webDriverWait.until(ExpectedConditions.visibilityOf(moreButton));
        moreButton.click();
        return new MainMenuPage(driver);
    }

    public MainMenuPage chooseOpenNewAccount() {
        webDriverWait.until(ExpectedConditions.visibilityOf(openNewAccountButton));
        WebElement element = openNewAccountButton;
        actions.moveToElement(element).click().build().perform();
        return new MainMenuPage(driver);
    }

    public ContactInfoPage chooseProfile() {
        webDriverWait.until(ExpectedConditions.visibilityOf(profileButton));
        WebElement element = profileButton;
        actions.moveToElement(element).click().build().perform();
        return new ContactInfoPage(driver);
    }

    public AllTestsPage chooseTests() {
        webDriverWait.until(ExpectedConditions.visibilityOf(testsButton));
        testsButton.click();
        return new AllTestsPage(driver);
    }

    public ArbitraryOrders chooseArbitaryOrder() {
        webDriverWait.until(ExpectedConditions.visibilityOf(arbitaryOrderButton));
        WebElement element = arbitaryOrderButton;
        actions.moveToElement(element).click().build().perform();
        return new ArbitraryOrders(driver);
    }

    public MainMenuPage chooseDocumentsAndTaxes() {
        webDriverWait.until(ExpectedConditions.visibilityOf(documentsAndTaxes));
        documentsAndTaxes.click();
        return new MainMenuPage(driver);
    }

    public MainMenuPage chooseElectronicSignature() {
        webDriverWait.until(ExpectedConditions.visibilityOf(electronicSignature));
        electronicSignature.click();
        return new MainMenuPage(driver);
    }
}
