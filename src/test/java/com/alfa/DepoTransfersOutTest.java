package com.alfa;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class DepoTransfersOutTest {

    WebDriver driver;
    WebDriverWait webDriverWait;
    static ChromeOptions chromeOptions = new ChromeOptions();


    boolean isDisplayed() {
        try {
            return driver.findElement(By.xpath("//button[@class='modal__close']")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
        chromeOptions.addArguments("--headless");


    }


    @Test
    @DisplayName("Проверка списания ЦБ")
    void depoTransferOut() throws InterruptedException {

        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(7));
        driver.get("https://ip12.alfadirect.ru/transfers/securities/out");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        driver.findElement(By.id("login")).sendKeys("lhrapchenko");
        driver.findElement(By.id("password")).sendKeys("Test123");
        driver.findElement(By.id("authorize")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@inputmode='numeric']")));
        driver.findElement(By.xpath("//input[@inputmode='numeric']")).sendKeys("11111");
        Thread.sleep(4000);
        if (isDisplayed()) {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='modal__close']")));
            driver.findElement(By.xpath("//button[@class='modal__close']")).click();
        }
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='select-button__content'][.='Выберите позицию']")));
        driver.findElement(By.xpath("//span[@class='select-button__content'][.='Выберите позицию']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='8787-000']")));
        driver.findElement(By.xpath("//div[.='8787-000']")).click();
        driver.findElement(By.id("security-name")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='RU0008926258 / 1-01-00155-A']")));
        driver.findElement(By.xpath("//div[.='RU0008926258 / 1-01-00155-A']")).click();
        driver.findElement(By.id("security-amount")).sendKeys("11");

        driver.findElement(By.xpath("//button[contains(@class, 'white')]/span/span[.='Выберите место хранения']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/span[.='АО Альфа-Банк']")));
        driver.findElement(By.xpath("//div/span[.='АО Альфа-Банк']")).click();
        driver.findElement(By.id("withdraw-despository-bank-broker-name")).sendKeys("Атон");
        driver.findElement(By.id("withdraw-depo-account-num")).sendKeys("1111ОHTRRRR");

        WebElement element = driver.findElement(By.id("withdraw-tariff-checkbox"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("withdraw-send-transfer-request")));
        driver.findElement(By.id("withdraw-send-transfer-request")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@inputmode='numeric']")));
        driver.findElement(By.xpath("//input[@inputmode='numeric']")).sendKeys("11111");


        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='notification__content']/div/span[.='Поручение принято к исполнению']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//div[@class='notification__content']/div/span[.='Поручение принято к исполнению']")).isDisplayed());

    }

    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}

