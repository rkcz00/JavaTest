package com.alfa;


import com.alfa.authorize.LoginPage;
import com.alfa.depotransfers.DepoTransferInPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class DepoTransfersInTest {

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
        driver = new ChromeDriver(chromeOptions);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
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

