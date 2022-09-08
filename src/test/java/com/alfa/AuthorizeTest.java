package com.alfa;

import com.alfa.authorize.LoginPage;
import com.alfa.authorize.ResetPassPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthorizeTest {

    WebDriver driver;
    WebDriverWait webDriverWait;
    static ChromeOptions chromeOptions = new ChromeOptions();

    private final static String LK_TEST_URL = "https://ip12.alfadirect.ru";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
        chromeOptions.addArguments("--headless");

    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver(chromeOptions);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(LK_TEST_URL);

    }

    @Test
    @DisplayName("Проверка успешной авторизации в ЛК")
    void authorizeToLk() {

        new LoginPage(driver)
                .login("t_eq_d_nikonov", "Test123")
                .sendSms()
                .checkSuccessNotify();


    }


    @Test
    @DisplayName("Проверка ввода некорректных смс")
    void incorrectSms() {
        new LoginPage(driver)
                .login("t_eq_d_nikonov", "Test123")
                .sendIncorrectSms()
                .checkOverLimitSms();


    }

    @Test
    @DisplayName("Проверка успешного восстановления пароля")
    void passwordRecoveryTest() throws InterruptedException {

        new LoginPage(driver).restorePassClick()
                .insertSurname("Агафонов")
                .insertName("Сабзиро")
                .insertSecondName("Депозитович")
                .insertPhone("9057896899")
                .clickRestorePassButton()
                .sendPassportSms()
                .insertNewPassword("Test123")
                .insertRepeatPassword("Test123")
                .clickResetPassButton()
                .sendSms();
        new ResetPassPage(driver).checkSuccessReset();


    }

    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}
