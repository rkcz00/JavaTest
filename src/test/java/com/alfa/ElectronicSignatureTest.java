package com.alfa;

import com.alfa.authorize.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;

public class ElectronicSignatureTest extends BaseTest {

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    void setupBrowser() {
        driver = SettingsOption.getChromeDriver();
        driver.get(LK_TEST_URL);

        new LoginPage(driver)
                .login("t_eq_ehabramov", "Test123")
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
