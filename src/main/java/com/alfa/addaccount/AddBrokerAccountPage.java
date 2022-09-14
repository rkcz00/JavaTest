package com.alfa.addaccount;

import com.alfa.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddBrokerAccountPage extends BasePage {
    public AddBrokerAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "open-broker")
    private WebElement openBrokerButton;

    public AddAccountNewDocumentsPage openBrokerButtonClick(){
        webDriverWait.until(ExpectedConditions.visibilityOf(openBrokerButton));
        openBrokerButton.click();
        return new AddAccountNewDocumentsPage(driver);
    }
}


