package com.alfa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BondsPage extends BasePage{
    public BondsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "public-offering-item-action")
    private WebElement publicOfferingButton;

    @FindBy(xpath = "//h2[contains(text(), 'Аукцион по купону')]")
    private WebElement auctionText;

    @FindBy(id = "amount")
    private WebElement amountField;

    @FindBy(id = "buy-submit")
    private WebElement buySubmit;

    @FindBy(xpath = "//div[.='RU000A102788']")
    private WebElement isinText;

    public BondsPage clickPublicOfferingButton(){
        webDriverWait.until(ExpectedConditions.visibilityOf(isinText));
        publicOfferingButton.click();
        return new BondsPage(driver);
    }

    public BondsPage buyBonds(){
        webDriverWait.until(ExpectedConditions.visibilityOf(auctionText));
        amountField.sendKeys("10");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(buySubmit));
        buySubmit.click();
        return new BondsPage(driver);
    }
}
