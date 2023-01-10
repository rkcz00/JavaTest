package com.alfa;

import com.alfa.authorize.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;


public class ArbitraryOrdersTests {

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
                .chooseArbitaryOrder();

    }

    @Test
    @DisplayName("Проверка корректности отправки поручения с темой 'Иное'")
    void checkOtherThemeOrder() {

        new ArbitraryOrders(driver)
                .chooseOtherTheme()
                .clickSendOrderButton()
                .checkSuccessNotify();

    }

    @Test
    @DisplayName("Проверка корректности отправки поручения с темой 'Quik'")
    void checkQuikThemeOrder() {

        new ArbitraryOrders(driver)
                .chooseQuikTheme()
                .clickSendOrderButton()
                .checkSuccessNotify();

    }

    @Test
    @DisplayName("Проверка корректности отправки поручения с темой 'Признание квалифицированным инвестором'")
    void checkQualifiedInvestorThemeOrder() {

        new ArbitraryOrders(driver)
                .chooseQualifiedInvestorTheme()
                .clickSendOrderButton()
                .checkSuccessNotify();

    }

    @Test
    @DisplayName("Проверка корректности отправки поручения с темой 'Участие в размещении ЦБ'")
    void checkOfferThemeOrder() {

        new ArbitraryOrders(driver)
                .chooseOfferTheme()
                .clickSendOrderButton()
                .checkSuccessNotify();

    }

    @Test
    @DisplayName("Проверка корректности отправки поручения с темой 'Отмена поручения на размещение'")
    void checkCancelOfferThemeOrder() {

        new ArbitraryOrders(driver)
                .chooseCancelOfferTheme()
                .clickSendOrderButton()
                .checkSuccessNotify();

    }


    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}


