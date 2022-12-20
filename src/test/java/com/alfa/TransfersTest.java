package com.alfa;


import com.alfa.authorize.LoginPage;
import com.alfa.moneytransfers.InteriorPage;
import com.alfa.moneytransfers.OtherBankPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;

import java.net.URISyntaxException;
import java.time.Duration;


public class TransfersTest {

    WebDriver driver;
    WebDriverWait webDriverWait;
    static ChromeOptions chromeOptions = new ChromeOptions();

    private final static String LK_TEST_URL = "https://ip12.alfadirect.ru";


    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("window-size=1920,1080");



    }

    @BeforeEach
    void setupBrowser() throws InterruptedException {
        driver = new ChromeDriver();
//        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
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
    void otherBankTransfer() throws FindFailed, URISyntaxException {


        new OtherBankPage(driver)
                .chooseInTheOtherBank()
                .insertFields()
                .clickSendMoney()
                .pressKeys()
                .checkSuccessNotify();;
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

