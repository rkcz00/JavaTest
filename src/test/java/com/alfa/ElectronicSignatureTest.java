package com.alfa;

import com.alfa.authorize.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class ElectronicSignatureTest {

    WebDriver driver;
    private final static String LK_TEST_URL = "https://lk-fb-int.alfadirect.ru/";


    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    void setupBrowser() throws InterruptedException {
        driver = SettingsOption.getChromeDriver();
        driver.get(LK_TEST_URL);

        new LoginPage(driver)
                .login("t_eq_gshefimov", "Test123")
                .sendSms();
        new MainMenuPage(driver)
                .checkEmailWindow()
                .chooseElectronicSignature();


    }

    @Test
    @DisplayName("Проверка корректности отзыва сертификата")
    void checkCancelElectronicSignature() {
        new ElectronicSignature(driver)
                .cancelCertificate();
        new LoginPage(driver).sendSms();
        new ElectronicSignature(driver).checkSuccessNotify();

    }

    @Test
    @DisplayName("Проверка корректности создания электронной подписи")
    void checkElectronicSignature() {

        new ElectronicSignature(driver)
                .createNewSign()
                .approveCertificate();

        new LoginPage(driver).sendSms();
        new ElectronicSignature(driver).checkSuccessNotify();
    }

    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}
