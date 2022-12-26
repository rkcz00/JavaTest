package com.alfa;


import com.alfa.authorize.LoginPage;
import com.alfa.depotransfers.DepoTransferInPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;


public class DepoTransfersInTest {

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
                .login("t_eq_ezivankov", "Test123")
                .sendSms();
        new MainMenuPage(driver)
                .checkEmailWindow()
                .chooseTransfers()
                .chooseSecurities();


    }

    @Test
    @Disabled
    @DisplayName("Проверка зачисления ЦБ")
    void depoTransferIn() {


        new DepoTransferInPage(driver)
                .insertSecurity()
                .chooseCounterparty()
                .clickTarifCheckbox()
                .clickTransferButton();
        new LoginPage(driver).sendSms();
        new DepoTransferInPage(driver)
                .checkSuccessNotify();


    }

    @Test
    @Disabled
    @DisplayName("Проверка пакетного зачисления ЦБ")
    void depoTransferMassIn() {

        new DepoTransferInPage(driver)
                .selectBatchEnrollment()
                .selectSubAccount()
                .insertMassSecurity()
                .chooseMassCounterparty()
                .clickTransferButton();


    }


    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}

