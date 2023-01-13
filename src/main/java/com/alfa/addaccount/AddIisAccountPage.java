package com.alfa.addaccount;

import com.alfa.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddIisAccountPage extends BasePage {
    public AddIisAccountPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(id = "open-iis")
    private WebElement openIisButton;

    public AddAccountNewDocumentsPage openIisButtonClick() {
        webDriverWait.until(ExpectedConditions.visibilityOf(openIisButton));
        openIisButton.click();
        return new AddAccountNewDocumentsPage(driver);
    }
}
