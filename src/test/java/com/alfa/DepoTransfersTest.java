package com.alfa;


import com.alfa.authorize.LoginPage;
import com.alfa.depotransfers.DepoTransferInPage;
import com.alfa.depotransfers.DepoTransferOutPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;


public class DepoTransfersTest {

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
    @DisplayName("Проверка зачисления ЦБ")
    void depoTransferIn() throws InterruptedException {

        new DepoTransferInPage(driver)
                .nextButtonClick()
                .selectPlaceHolder()
                .chooseReestr()
                .sendPesonalAccount()
                .nextButtonClick()
                .chooseSecurity()
                .insertCountFiled()
                .nextButtonClick()
                .sendOrderButtonClick()
                .checkSuccessNotify();


    }

    @Test
    @DisplayName("Проверка списания ЦБ")
    void depoTransferOut() throws InterruptedException {

        new DepoTransferOutPage(driver)
                .chooseWithdraw()
                .nextButtonClick()
                .selectPlaceHolder()
                .chooseNrd()
                .insertCounterPartyFields()
                .nextButtonClick()
                .chooseSecurity()
                .insertCountFiled()
                .nextButtonClick()
                .sendOrderButtonClick()
                .checkSuccessNotify();

    }

    @Test
    @Disabled
    @DisplayName("Проверка пакетного зачисления ЦБ")
    void depoTransferMassIn() {

//        new DepoTransferInPage(driver)
//                .selectBatchEnrollment()
//                .selectSubAccount()
//                .insertMassSecurity()
//                .chooseMassCounterparty()
//                .clickTransferButton();
//
//
    }


    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}

