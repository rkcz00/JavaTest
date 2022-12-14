package com.alfa;

import com.alfa.addaccount.AddAccountSuccessPage;
import com.alfa.addaccount.AddBrokerAccountPage;
import com.alfa.addaccount.AddIisAccountPage;
import com.alfa.authorize.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class AddAccountsTest {


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
                .login("t_eq_di_ershov", "Test123")//нужен новый логин на каждый тест
                .sendSms();
        new MainMenuPage(driver)
                .checkEmailWindow()
                .chooseMore()
                .chooseOpenNewAccount();


    }

    @Test
    @DisplayName("Проверка открытия брокерского счета")
    void openNewBrokerAccount() throws InterruptedException {

        new AddBrokerAccountPage(driver)
                .openBrokerButtonClick()
                .agreeCheckBoxClick()
                .clickDocumentSignButton();
        new LoginPage(driver).sendSms();
        new AddAccountSuccessPage(driver).checkSuccessStage();
    }

    @Test
    @DisplayName("Проверка открытия ИИС")
    void openNewIisAccount() throws InterruptedException {

        new AddIisAccountPage(driver)
                .openIisButtonClick()
                .agreeCheckBoxClick()
                .clickDocumentSignButton();
        new LoginPage(driver).sendSms();
        new AddAccountSuccessPage(driver).checkSuccessStage();
    }


    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}
