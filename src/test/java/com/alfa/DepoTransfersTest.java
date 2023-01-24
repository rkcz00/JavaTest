package com.alfa;


import com.alfa.authorize.LoginPage;
import com.alfa.depotransfers.DepoTransferInPage;
import com.alfa.depotransfers.DepoTransferInnerPage;
import com.alfa.depotransfers.DepoTransferOutPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;


public class DepoTransfersTest extends BaseTest {


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
                .selectFirstPlaceHolder()
                .chooseNrd()
                .nextButtonClick()
                .selectSecondPlaceHolder()
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
    @Disabled
    @DisplayName("Проверка пакетного зачисления ЦБ")
    void depoMassTransferIn() throws InterruptedException {

        new DepoTransferInPage(driver)
                .selectFirstPlaceHolder()
                .chooseNrd()
                .nextButtonClick()
                .selectSecondPlaceHolder()
//                .chooseReestr()
//                .sendPesonalAccount()
                .chooseNrd()
                .insertCounterPartyFields()
                .nextButtonClick()
                .chooseSecurity()
                .insertCountFiled()
                .addSecurities()
                .nextButtonClick()
                .sendOrderButtonClick()
                .checkSuccessNotify();


    }

    @Test
    @DisplayName("Проверка списания ЦБ")
    void depoTransferOut() throws InterruptedException {

        new DepoTransferOutPage(driver)
                .chooseWithdraw()
                .selectFirstPlaceHolder()
                .chooseNrd()
                .nextButtonClick()
                .selectSecondPlaceHolder()
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
    @DisplayName("Проверка перевода ЦБ внутри счета")
    void depoTransferInner() {

        new DepoTransferInnerPage(driver)
                .chooseInnerTransfers()
                .nextButtonClick()
                .chooseSecurity()
                .insertCountFiled()
                .nextButtonClick()
                .nextButtonClick()
                .sendOrderButtonClick()
                .checkSuccessNotify();



    }


    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}

