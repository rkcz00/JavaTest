package com.alfa;

import com.alfa.authorize.LoginPage;
import com.alfa.documents.TaxesInfoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class DocumentsTest {

    WebDriver driver;
    private final static String LK_TEST_URL = "https://ip12.alfadirect.ru";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    void setupBrowser() throws InterruptedException {
        driver = SettingsOption.getChromeDriver();
        driver.get(LK_TEST_URL);


        new LoginPage(driver)
                .login("t_eq_nshomski", "Test123")
                .sendSms();
        new MainMenuPage(driver)
//                .goToBlockedАssets()
                .checkEmailWindow()
                .chooseDocumentsAndTaxes();

    }

    @Test
    @DisplayName("Проверка заказа брокерского отчета")
    void checkBrokerageReportOrder() {

        new TaxesInfoPage(driver)
                .chooseDocumentOrderTab()
                .chooseReportDocument()
                .chooseBrokerageReport()
                .chooseWayToGetOffice()
                .insertOfficeFields()
                .clickOfferDocumentsButton()
                .checkFirstSuccessNotify()
                .chooseWayToGetPost()
                .clickOfferDocumentsButton()
                .checkFinalSuccessNotify();

    }

    @Test
    @DisplayName("Проверка заказа справки-расчета")
    void checkReferenceCalculationReportOrder() {

        new TaxesInfoPage(driver)
                .chooseDocumentOrderTab()
                .chooseReportDocument()
                .chooseReferenceCalculationReport()
                .chooseWayToGetOffice()
                .insertOfficeFields()
                .clickOfferDocumentsButton()
                .checkFirstSuccessNotify()
                .chooseWayToGetPost()
                .clickOfferDocumentsButton()
                .checkFinalSuccessNotify();

    }

    @Test
    @DisplayName("Проверка заказа детального расчета")
    void checkdetailedСalculationReportOrder() {

        new TaxesInfoPage(driver)
                .chooseDocumentOrderTab()
                .chooseReportDocument()
                .chooseDetailedСalculationReport()
                .chooseWayToGetOffice()
                .insertOfficeFields()
                .clickOfferDocumentsButton()
                .checkFirstSuccessNotify()
                .chooseWayToGetPost()
                .clickOfferDocumentsButton()
                .checkFinalSuccessNotify();

    }


    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}
