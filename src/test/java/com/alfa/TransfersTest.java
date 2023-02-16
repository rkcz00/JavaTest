package com.alfa;


import com.alfa.authorize.LoginPage;
import com.alfa.moneytransfers.InteriorPage;
import com.alfa.moneytransfers.OtherBankPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;


public class TransfersTest extends BaseTest {

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    void setupBrowser() {
        driver = SettingsOption.getChromeDriver();
        driver.get(LK_TEST_URL);


        new LoginPage(driver)
                .login("t_eq_drozdov_va", "Test123")
                .sendSms();
        new MainMenuPage(driver)
                .checkEmailWindow()
                .chooseTransfers()
                .chooseMoneyTransfers();


    }

    @Test
    @Disabled
    @DisplayName("Проверка перевода в другой банк ")
    void otherBankTransfer() {


        new OtherBankPage(driver)
                .chooseInTheOtherBank()
                .insertFields()
                .clickSendMoney()
                .checkSuccessNotify();

    }

    @Test
    @DisplayName("Проверка внутреннего перевода")
    void interiorTransfer() {


        new InteriorPage(driver)
                .chooseInteriorTransfer()
                .insertAmount()
                .clickTransferButton()
                .checkSuccessNotify();
    }


    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}

