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
                .login("t_eq_drozdov_va", "Test123")
                .sendSms();
        new MainMenuPage(driver)
                .checkEmailWindow()
                .chooseDocumentsAndTaxes();

    }

    @Test
    @DisplayName("")
    void checkReportOrder() {

        new TaxesInfoPage(driver)
                .chooseDocumentOrderTab();

    }

    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}
