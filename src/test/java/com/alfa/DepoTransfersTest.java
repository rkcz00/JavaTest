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

public class DepoTransfersTest {

    WebDriver driver;
    WebDriverWait webDriverWait;
    static ChromeOptions chromeOptions = new ChromeOptions();

    private final static String LK_TEST_URL = "https://ip12.alfadirect.ru";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
        chromeOptions.addArguments("--headless");

    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(7));
        driver.get(LK_TEST_URL);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        driver.findElement(By.id("login")).sendKeys("t_eq_afnovikov");
        driver.findElement(By.id("password")).sendKeys("Test123");
        driver.findElement(By.id("authorize")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@inputmode='numeric']")));
        driver.findElement(By.xpath("//input[@inputmode='numeric']")).sendKeys("11111");
    }

    @Test
    @DisplayName("Проверка зачисления ЦБ")
    void depoTransferIn() throws InterruptedException {
//        Thread.sleep(7);
        boolean t = driver.findElement(By.xpath("//button[@class='modal__close']")).isDisplayed();
        if (t) {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='modal__close']")));
            driver.findElement(By.xpath("//button[@class='modal__close']")).click();
        }
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Переводы']")));
        driver.findElement(By.xpath("//*[text()='Переводы']")).click();
        driver.findElement(By.xpath("//*[text()='Ценные бумаги']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("security-name")));
        driver.findElement(By.id("security-name")).sendKeys("Втб");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='RU000A0JP5V6 / 10401000B']")));
        driver.findElement(By.xpath("//div[.='RU000A0JP5V6 / 10401000B']")).click();
//        Assertions.assertEquals(driver.findElement(By.id("replenishment")).isDisplayed(), true);


    }


//    @AfterEach
//    void quitBrowser (){
//        driver.quit();
//    }
}

