package com.alfa;


import com.alfa.authorize.LoginPage;
import com.alfa.profile.ContactInfoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;

public class ProfileTest extends BaseTest {


    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    void setupBrowser() throws InterruptedException {
        driver = SettingsOption.getChromeDriver();
        driver.get(LK_TEST_URL);


        new LoginPage(driver)
                .login("t_eq_ezmaslov", "Test123")
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
