package com.alfa;

import com.alfa.authorize.LoginPage;
import com.alfa.tests.AllTestsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class TestsTest {

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
                .login("t_eq_prohorov_ie", "Test123")
                .sendSms();
        new MainMenuPage(driver)
                .checkEmailWindow()
                .chooseMore()
                .chooseTests();


    }

    @Test
    @DisplayName("Проверка корректности прохождения теста по маржинальной торговле")
    void checkMarginalTest() {

        new AllTestsPage(driver)
                .chooseMarginalTest()
                .answerQuestion1();

    }

    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}
