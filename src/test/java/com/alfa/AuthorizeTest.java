package com.alfa;

import com.alfa.authorize.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;

public class AuthorizeTest extends BaseTest {


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
                .login("t_eq_vinogradov_ds", "Test123")
                .sendIncorrectSms()
                .checkOverLimitSms();


    }

    @Test
    @DisplayName("Проверка успешного восстановления пароля")
    void passwordRecoveryTest()  {

        new LoginPage(driver).restorePassClick()
                .insertSurname("КОРОЛЁВ")
                .insertName("КУЗЬМА")
                .insertSecondName("ДАВИДОВИЧ")
                .insertPhone("9058674000")
                .clickRestorePassButton()
                .sendSms()
                .insertNewPassword("Test123")
                .insertRepeatPassword("Test123")
                .clickResetPassButton()
                .comInButtonClick();

        new LoginPage(driver)
                .login("t_eq_koroliov_kd", "Test123")
                .sendSms()
                .checkSuccessNotify();
        //reset


    }

    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}
