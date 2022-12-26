package com.alfa;


import com.alfa.authorize.LoginPage;
import com.alfa.moneytransfers.InteriorPage;
import com.alfa.moneytransfers.OtherBankPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;


public class TransfersTest {

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
                .chooseTransfers()
                .chooseMoneyTransfers();


    }

    @Test
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

