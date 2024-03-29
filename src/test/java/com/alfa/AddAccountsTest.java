package com.alfa;

import com.alfa.addaccount.AddAccountSuccessPage;
import com.alfa.addaccount.AddBrokerAccountPage;
import com.alfa.addaccount.AddIisAccountPage;
import com.alfa.authorize.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;

public class AddAccountsTest extends BaseTest {


    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    void setupBrowser() {
        driver = SettingsOption.getChromeDriver();
        driver.get(LK_TEST_URL);


        new LoginPage(driver)
                .login("t_eq_nzkolesnikov", "Test123")//нужен новый логин на каждый тест
                .sendSms();
        new MainMenuPage(driver)
                .checkEmailWindow()
                .chooseMore()
                .chooseOpenNewAccount();


    }

    @Test
    @Disabled
    @DisplayName("Проверка открытия брокерского счета")
    void openNewBrokerAccount() {

        new AddBrokerAccountPage(driver)
                .openBrokerButtonClick()
                .agreeCheckBoxClick()
                .clickDocumentSignButton();
        new LoginPage(driver).sendSms();
        new AddAccountSuccessPage(driver).checkSuccessStage();
    }

    @Test
    @Disabled
    @DisplayName("Проверка открытия ИИС")
    void openNewIisAccount() {

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
