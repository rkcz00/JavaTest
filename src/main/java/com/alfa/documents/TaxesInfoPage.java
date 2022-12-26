package com.alfa.documents;

import com.alfa.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TaxesInfoPage extends BasePage {
    public TaxesInfoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[text()='Заказ документов']")
    private WebElement documentOrderTab;

    public DocumentsOrderPage chooseDocumentOrderTab() {
        webDriverWait.until(ExpectedConditions.visibilityOf(documentOrderTab));
        documentOrderTab.click();
        return new DocumentsOrderPage(driver);
    }


}
