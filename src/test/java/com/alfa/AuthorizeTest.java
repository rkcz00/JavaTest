package com.alfa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthorizeTest {

    WebDriver driver;
    WebDriverWait webDriverWait;
    static ChromeOptions chromeOptions = new ChromeOptions();

    private final static String LK_TEST_URL = "https://ip12.alfadirect.ru";

    @BeforeAll
    static void registerDriver (){
        WebDriverManager.chromedriver().setup();
        chromeOptions.addArguments("--headless");

    }

    @BeforeEach
     void setupBrowser (){
        driver = new ChromeDriver(chromeOptions);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(LK_TEST_URL);

    }

    @Test
    @DisplayName("Проверка успешной авторизации в ЛК")
    void authorizeToLk (){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        driver.findElement(By.id("login")).sendKeys("t_eq_d_nikonov");
        driver.findElement(By.id("password")).sendKeys("Test123");
        driver.findElement(By.id("authorize")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@inputmode='numeric']")));
        driver.findElement(By.xpath("//input[@inputmode='numeric']")).sendKeys("11111");

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("replenishment")));
        Assertions.assertEquals(driver.findElement(By.id("replenishment")).isDisplayed(), true);


    }

    @Test
    @DisplayName("Проверка ввода некорректного пароля")
    void incorrectPassword () {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        driver.findElement(By.id("login")).sendKeys("t_eq_gedel_pm");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        driver.findElement(By.id("password")).sendKeys("Test124");
        for (int i = 0; i <=5 ; i++) {
            driver.findElement(By.id("authorize")).click();
        }
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img")));
        Assertions.assertTrue(driver.findElement(By.xpath("//img")).isDisplayed());

    }

    @Test
    @DisplayName("Проверка ввода некорректных смс")
    void incorrectSms () {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        driver.findElement(By.id("login")).sendKeys("t_eq_dtvlasov");
        driver.findElement(By.id("password")).sendKeys("Test123");
        driver.findElement(By.id("authorize")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@inputmode='numeric']")));
        for (int i = 0; i <=5 ; i++) {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@inputmode='numeric']")));
            driver.findElement(By.xpath("//input[@inputmode='numeric']")).sendKeys("11112");
        }
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class = 'overlimit__title']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//span[@class = 'overlimit__title']")).isDisplayed());

    }

    @Test
    @DisplayName("Проверка успешного восстановления пароля")
    void passwordRecoveryTest() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password-restore")));
        driver.findElement(By.id("password-restore")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("register-name-surname")));

        driver.findElement(By.id("register-name-surname")).sendKeys("Агафонов");
        driver.findElement(By.id("register-name-name")).sendKeys("Сабзиро");
        driver.findElement(By.id("register-name-secondname")).sendKeys("Депозитович");
        driver.findElement(By.id("phone")).sendKeys("9057896899");
        driver.findElement(By.id("on-line-bank-btn")).click();
        Thread.sleep(2000);
//        webDriverWait.until(ExpectedConditions.visibilityOf((WebElement) By.xpath("//input")));
        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("0000");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("new-password")));
        driver.findElement(By.id("new-password")).sendKeys("Test123");
        driver.findElement(By.id("repeat-password")).sendKeys("Test123");
        driver.findElement(By.xpath("//div[@class='registration-password__button']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@inputmode='numeric']")));
        driver.findElement(By.xpath("//input[@inputmode='numeric']")).sendKeys("11111");


        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("replenishment")));
        Assertions.assertTrue(driver.findElement(By.id("replenishment")).isDisplayed());
    }

    @AfterEach
    void quitBrowser (){
        driver.quit();
    }
}
