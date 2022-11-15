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

public class BondsTest {


        WebDriver driver;
        WebDriverWait webDriverWait;
        static ChromeOptions chromeOptions = new ChromeOptions();

        private final static String LK_TEST_URL = "https://ip12.alfadirect.ru/public-offering/active/23";


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
                    .login("lhrapchenko", "Test123");
//                    .sendSms();
            new MainMenuPage(driver)
                    .checkEmailWindow();
//                    .chooseMore()
//                    .chooseProfile();


        }

        @Test
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


