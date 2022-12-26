package com.alfa;


import com.alfa.authorize.LoginPage;
import com.alfa.profile.ContactInfoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class ProfileTest {

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
    void checkPasswordChange() {

        new ContactInfoPage(driver)
                .chooseTabChangePassword()
                .setNewPassword()
                .clickPasswordChangeButton()
                .checkSuccessNotify();

    }


    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}
