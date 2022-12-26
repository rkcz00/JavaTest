package com.alfa;


import com.alfa.authorize.LoginPage;
import com.alfa.depotransfers.DepoTransferOutPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;


public class DepoTransfersOutTest {

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
                .login("lhrapchenko", "Test123");
//                .sendSms();
        new MainMenuPage(driver)
                .checkEmailWindow()
                .chooseTransfers()
                .chooseSecurities();


    }


    @Test
    @Disabled
    @DisplayName("Проверка списания ЦБ")
    void depoTransferOut() {

        new DepoTransferOutPage(driver)
                .chooseWithdraw()
                .choosePosition()
                .chooseSecurity()
                .chooseCounterparty()
                .clickWithDrawTarifCheckbox()
                .clickTransferButton();
        new LoginPage(driver).sendSms();
        new DepoTransferOutPage(driver).checkSuccessNotify();


    }

    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}

