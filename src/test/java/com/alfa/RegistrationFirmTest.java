package com.alfa;

import com.alfa.authorize.LoginPage;
import com.alfa.authorize.RegistrationFirmPage;
import com.alfa.registrationfirm.FirmAnketaPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class RegistrationFirmTest  {

    WebDriver driver;
//    public final static String LK_TEST_URL = "https://lk-fb-int.alfadirect.ru/registration-firm";
    public final static String LK_TEST_URL = "https://ip12.alfadirect.ru/registration-firm";

    @BeforeAll
    static void registerDriver() {


        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    void setupBrowser() {
        driver = SettingsOption.getChromeDriver();
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
