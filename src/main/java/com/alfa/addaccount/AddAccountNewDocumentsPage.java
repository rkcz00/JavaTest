package com.alfa.addaccount;

import com.alfa.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddAccountNewDocumentsPage extends BasePage {
    public AddAccountNewDocumentsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//input[@id ='agree']")
    private WebElement agreeCheckBox;

    @FindBy(id = "document-sign")
    private WebElement documentSignButton;

    @FindBy(xpath = "//h5")
    private WebElement signTitle;

    public AddAccountNewDocumentsPage agreeCheckBoxClick() {
        webDriverWait.until(ExpectedConditions.visibilityOf(signTitle));
        WebElement element = agreeCheckBox;
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        return new AddAccountNewDocumentsPage(driver);
    }

    public AddAccountNewDocumentsPage clickDocumentSignButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(documentSignButton));
        documentSignButton.click();
        return new AddAccountNewDocumentsPage(driver);
    }
}


