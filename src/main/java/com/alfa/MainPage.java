package com.alfa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h5[.='Встречайте новую услугу в ЛК']")
    private WebElement newUserPopUp;

    @FindBy(xpath = "//span/span[.='Дальше']")
    private WebElement nextButton;

//    @FindBy(xpath = "//div[@class='guide-step__abort']/a[@href='#']")
//    private WebElement closeWelcomePopupButton;

    @FindBy(xpath = "//a[@class='link guide-step__close link_size_m link_flex link_theme_alfa-on-white']")
    private WebElement closeWelcomePopupButton;

    @FindBy(xpath = "//span[@class='select__inner']/span[.='С позиции']")
    private WebElement position;

    @FindBy(xpath = "//span[.='₽']")
    private WebElement onAccount;

    @FindBy(id = "amount")
    private WebElement amount;

    @FindBy(id = "send-money")
    private WebElement sendMoneyButton;

    public MainMenuPage closeWelcomePopUp() {
        webDriverWait.until(ExpectedConditions.visibilityOf(newUserPopUp));
        List<WebElement> rialtoList = driver.findElements(By.xpath("//a[@class='link guide-step__close link_size_m link_flex link_theme_alfa-on-white']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(rialtoList.get(1)).click().build().perform();
        return new MainMenuPage(driver);
    }

    public MainMenuPage nextButtonClick() {
        webDriverWait.until(ExpectedConditions.visibilityOf(newUserPopUp));
        List<WebElement> firstNextButtons = driver.findElements(By.xpath("//span/span[.='Дальше']"));
        firstNextButtons.get(1).click();
        webDriverWait.until(ExpectedConditions.visibilityOf(nextButton));
        List<WebElement> secondsNextButtons = driver.findElements(By.xpath("//span/span[.='Дальше']"));
        secondsNextButtons.get(1).click();

        return new MainMenuPage(driver);
    }

    public MainPage insertFields() {
        WebElement element = position;
        WebElement element1 = amount;
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();

        List<WebElement> rialtoList = driver.findElements(
                By.xpath("//span[@class = 'trade-option__account']"));;
        rialtoList.get(0).click();

        actions.moveToElement(element1).click().build().perform();
        amount.click();
        amount.sendKeys(Keys.BACK_SPACE);
        amount.sendKeys("100");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(sendMoneyButton));
        sendMoneyButton.click();

        return new MainPage(driver);
    }


}
