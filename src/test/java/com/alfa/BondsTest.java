package com.alfa;

import com.alfa.authorize.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class BondsTest  {
    WebDriver driver;
    public final static String LK_TEST_URL = "https://ip12.alfadirect.ru/public-offering/active/23";


    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    void setupBrowser() throws InterruptedException {
        driver = SettingsOption.getChromeDriver();
        driver.get(LK_TEST_URL);


        new LoginPage(driver)
                .login("lhrapchenko", "Test123");
//                    .sendSms();
        new MainMenuPage(driver)
                .checkEmailWindow();
//                    .chooseMore()
//                    .chooseProfile();


    }

    @Test
    @Disabled
    @DisplayName("Проверка корректности покупки облигаций")
    void buyBondsTest() {

        new BondsPage(driver)
                .clickPublicOfferingButton()
                .buyBonds();
        new LoginPage(driver)
                .sendSms();

    }


    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}


