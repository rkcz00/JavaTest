package com.alfa;

import com.alfa.registrationfirm.FirmAnketaPage;
import com.alfa.authorize.LoginPage;
import com.alfa.authorize.RegistrationFirmPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationFirmTest {

    WebDriver driver;
    WebDriverWait webDriverWait;
    static ChromeOptions chromeOptions = new ChromeOptions();
    private final static String LK_TEST_URL = "https://ip12.alfadirect.ru/registration-firm";

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
    @DisplayName("Проверка успешной регистрации ЮЛ")
    void registrationFirmTest() {

        new RegistrationFirmPage(driver).fillingApplication
                        ("Храпченко",
                                "Людмила",
                                "Валерьевна",
                                "1111111111",
                                "77777777777")
                .clickRegistrationDemoButton();
        new LoginPage(driver).sendSms();
        new FirmAnketaPage(driver).insertBaseFirmInfo()
                .insertCommonFirmInfo()
                .insertCeoInfo()
                .insertRegDateInfo()
                .insertLegalAddress()
                .insertLicenseInfo()
                .insertMoreInfo()
                .clickSubmitButton()
                .acceptTransactionMode()
                .checkSuccessFirmRegistration();


    }


    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}
