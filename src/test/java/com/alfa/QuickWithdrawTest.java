package com.alfa;

import com.alfa.authorize.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;

public class QuickWithdrawTest extends BaseTest {


    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    void setupBrowser() throws InterruptedException {
        driver = SettingsOption.getChromeDriver();
        driver.get(LK_TEST_URL);


        new LoginPage(driver)
                .login("t_eq_shddenisov", "Test123")
                .sendSms();
        new MainMenuPage(driver)
                .checkEmailWindow();


    }

    @Test
    @DisplayName("Проверка корректности быстрого вывода")
    void checkQuickWithdraw() {

        new MainPage(driver)
                .insertFields()
                .checkSuccessNotify();

    }

    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}
