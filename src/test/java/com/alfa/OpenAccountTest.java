package com.alfa;

import com.alfa.authorize.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.*;

import java.io.IOException;

public class OpenAccountTest extends BaseTest {

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    void setupBrowser() throws InterruptedException {
        driver = SettingsOption.getChromeDriver();
        driver.get(LK_TEST_URL);
    }

    @Test
    @DisplayName("Проверка корректности открытия БС")
    void checkOpenAccount() throws IOException, ParseException, InterruptedException {

        new LoginPage(driver)
                .openaAccountButtonClick()
                .insertUserData()
                .nextButtonClick()
                .sendPassportSms()
                .openAccountButtonClick()
                .sendSms()
                .insertPass()
                .checkSuccessText();

    }

    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}

