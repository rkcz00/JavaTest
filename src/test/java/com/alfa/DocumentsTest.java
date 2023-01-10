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
                .login("t_eq_vishniakov_ss", "Test123")
                .sendSms();
        new MainMenuPage(driver)
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
                .clickOfferReportsButton()
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
                .clickOfferReportsButton()
                .checkFinalSuccessNotify();

    }

    @Test
    @Disabled
    @DisplayName("Проверка заказа детального расчета")
    void checkDetailedСalculationReportOrder() {

        new TaxesInfoPage(driver)
                .chooseDocumentOrderTab()
                .chooseReportDocument()
                .chooseDetailedСalculationReport()
                .chooseWayToGetPost()
                .clickOfferReportsButton()
                .checkFinalSuccessNotify();

    }

    @Test
    @Disabled
    @DisplayName("Проверка заказа справки 2-НДФЛ")
    void checkNdflOrder() {

        new TaxesInfoPage(driver)
                .chooseDocumentOrderTab()
                .chooseNdflReport()
                .chooseWayToGetOffice()
                .insertOfficeFields()
                .clickOfferReportsButton()
                .checkFirstSuccessNotify()
                .chooseWayToGetPost()
                .clickOfferReportsButton()
                .checkFinalSuccessNotify();

    }

    @Test
    @DisplayName("Проверка заказа выписки о движении")
    void checkMovementReportOrder() {

        new TaxesInfoPage(driver)
                .chooseDocumentOrderTab()
                .chooseStatementOfMovementReport()
                .chooseDepoAccount()
                .chooseWayToGetPost()
                .clickOfferDocumentsButton()
                .checkFinalSuccessNotify();

    }


    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}
