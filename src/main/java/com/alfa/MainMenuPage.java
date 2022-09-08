package com.alfa;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
}
