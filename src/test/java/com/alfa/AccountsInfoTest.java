package com.alfa;

import com.alfa.accountsinfo.AccountsInfoPage;
import com.alfa.authorize.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;

public class AccountsInfoTest extends BaseTest {


    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    void setupBrowser() throws InterruptedException {
        driver = SettingsOption.getChromeDriver();
        driver.get(LK_TEST_URL);


        new LoginPage(driver)
                .login("t_eq_koroliov_kd", "Test123")
                .sendSms();
        new MainMenuPage(driver)
                .checkEmailWindow()
                .chooseTransfers()
                .chooseAccountInfo();


    }

    @Test
    @DisplayName("Проверка отображения сведений о счете")
    void checkAccountInfo() {

        new AccountsInfoPage(driver)
                .waitInfoDownload()
                .checkSuccessResult();

    }

    @Test
    @DisplayName("Проверка добавления субсчета")
    void checkAddSubAcc() {

        new AccountsInfoPage(driver)
                .accountManagementTabClick()
                .adSubAccountButtonClick()
                .checkSuccessNotify();

    }

    @Test
    @DisplayName("Проверка переименования субсчета")
    void checkRenameSubAcc() {

        new AccountsInfoPage(driver)
                .accountManagementTabClick()
                .redactSubAccountButtonClick()
                .insertNewName()
                .checkSuccessNotify();

    }

    @Test
    @DisplayName("Проверка оформления доверенности")
    void checkCreateAttorney() {

        new AccountsInfoPage(driver)
                .accountManagementTabClick()
                .createAttorneyButtonClick()
                .insertAttorneyFields()
                .checkSuccessNotify();


    }

    @Test
    @DisplayName("Проверка отзыва доверенности")
    void checkCancelAttorney() {

        new AccountsInfoPage(driver)
                .accountManagementTabClick()
                .cancelAttorney()
                .checkSuccessNotify();


    }


    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}
