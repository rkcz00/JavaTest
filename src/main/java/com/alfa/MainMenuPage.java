package com.alfa;

import com.alfa.profile.ContactInfoPage;
import org.openqa.selenium.*;
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

    @FindBy(xpath = "//*[text()='Ценные бумаги']")
    private WebElement mainMenuSecurities;

    @FindBy(xpath = "//*[text()='Ещё']")
    private WebElement moreButton;

    @FindBy(xpath = "//*[text()='Открыть новый счёт']")
    private WebElement openNewAccountButton;

    @FindBy(xpath = "//*[text()='Профиль']")
    private WebElement profileButton;

    @FindBy(xpath = "//button[@class='modal__close']")
    private WebElement emailWindowCloseButton;

    public MainMenuPage checkEmailWindow() throws InterruptedException {
        Thread.sleep(4000);
//        webDriverWait.until(ExpectedConditions.visibilityOf(emailWindowCloseButton));
        if (isDisplayed()) {
            webDriverWait.until(ExpectedConditions.visibilityOf(emailWindowCloseButton));
            emailWindowCloseButton.click();
        }
        return new MainMenuPage(driver);
    }

    public MainMenuPage chooseTransfers() {
        webDriverWait.until(ExpectedConditions.visibilityOf(mainMenuTransfers));
        mainMenuTransfers.click();
        return new MainMenuPage(driver);
    }

    public MainMenuPage chooseSecurities(){
        webDriverWait.until(ExpectedConditions.visibilityOf(mainMenuSecurities));
        mainMenuSecurities.click();
        return new MainMenuPage(driver);
    }

    public MainMenuPage chooseMore(){
        webDriverWait.until(ExpectedConditions.visibilityOf(moreButton));
        moreButton.click();
        return new MainMenuPage(driver);
    }

    public MainMenuPage chooseOpenNewAccount(){
        webDriverWait.until(ExpectedConditions.visibilityOf(openNewAccountButton));
        WebElement element = openNewAccountButton;
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        return new MainMenuPage(driver);
    }

    public ContactInfoPage chooseProfile(){
        webDriverWait.until(ExpectedConditions.visibilityOf(profileButton));
        WebElement element = profileButton;
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        return new ContactInfoPage(driver);
    }
}
