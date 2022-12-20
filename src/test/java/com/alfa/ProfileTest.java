package com.alfa;


import com.alfa.authorize.LoginPage;
import com.alfa.profile.ContactInfoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfileTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    static ChromeOptions chromeOptions = new ChromeOptions();

    private final static String LK_TEST_URL = "https://ip12.alfadirect.ru";


    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
        chromeOptions.addArguments("window-size=1920,1080");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--headless");


    }

    @BeforeEach
    void setupBrowser() throws InterruptedException {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(LK_TEST_URL);


        new LoginPage(driver)
                .login("t_eq_prohorov_ie", "Test123")
                .sendSms();
        new MainMenuPage(driver)
                .checkEmailWindow()
                .chooseMore()
                .chooseProfile();


    }

    @Test
    @DisplayName("Проверка корректности отображения контактной информации в профиле")
    void checkProfileContacts() {

        new ContactInfoPage(driver)
                .checkPhoneVisibility()
                .insertNickName()
                .saveChatSettingsButton()
                .checkSuccessNotify();

    }

    @Test
    @DisplayName("Проверка корректности отображения паспортных данных")
    void checkProfilePassportData() {

        new ContactInfoPage(driver)
                .chooseTabPassportData()
                .checkPassportData();
    }

    @Test
    @DisplayName("Проверка корректности смены пароля")
    void checkCheckPasswordChange() {

        new ContactInfoPage(driver)
                .chooseTabChangePassword()
                ;
    }


    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}
