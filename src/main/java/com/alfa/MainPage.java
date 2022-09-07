package com.alfa;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    boolean isDisplayed() {
        try {
            return driver.findElement(By.xpath("//button[@class='modal__close']")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @FindBy(xpath = "//*[text()='Переводы']")
    private WebElement mainMenuTransfers;

    @FindBy(xpath = "//*[text()='Ценные бумаги']")
    private WebElement mainMenuSecurities;

    @FindBy(xpath = "//button[@class='modal__close']")
    private WebElement emailWindowButton;

    public MainPage checkEmailWindow() throws InterruptedException {
        Thread.sleep(4000);
    }
}
