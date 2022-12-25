package com.alfa;

import com.alfa.authorize.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class QuickWithdrawTest {

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
                .login("t_eq_bespalov_st", "Test123")
                .sendSms();
        new MainMenuPage(driver)
                .checkEmailWindow();


    }

    @Test
    @DisplayName("Проверка корректности быстрого вывода")
    void checkQuickWithdraw() {

        new MainPage(driver)
                .insertFields();

    }

    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}
