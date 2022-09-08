package com.alfa;


import com.alfa.authorize.LoginPage;
import com.alfa.depotransfers.DepoTransferOutPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class DepoTransfersOutTest {

    WebDriver driver;
    WebDriverWait webDriverWait;
    static ChromeOptions chromeOptions = new ChromeOptions();

    private final static String LK_TEST_URL = "https://ip12.alfadirect.ru";


    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("window-size=1200,1100");


    }

    @BeforeEach
    void setupBrowser() throws InterruptedException {
        driver = new ChromeDriver(chromeOptions);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(LK_TEST_URL);


        new LoginPage(driver)
                .login("lhrapchenko", "Test123")
                .sendSms();
        new MainMenuPage(driver)
                .checkEmailWindow()
                .chooseTransfers()
                .chooseSecurities();


    }


    @Test
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

