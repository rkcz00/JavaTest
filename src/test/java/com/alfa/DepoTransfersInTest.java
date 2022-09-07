package com.alfa;


import com.alfa.authorize.LoginPage;
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
import java.util.List;

public class DepoTransfersInTest {

    WebDriver driver;
    WebDriverWait webDriverWait;
    static ChromeOptions chromeOptions = new ChromeOptions();

    private final static String LK_TEST_URL = "https://ip12.alfadirect.ru";

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

    @BeforeEach
    void setupBrowser() throws InterruptedException {
        driver = new ChromeDriver(chromeOptions);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        driver.get(LK_TEST_URL);
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
//        driver.findElement(By.id("login")).sendKeys("t_eq_ezivankov"); //t_eq_vishniakov_ss t_eq_ezivankov t_eq_gshefimov
//        driver.findElement(By.id("password")).sendKeys("Test123");
//        driver.findElement(By.id("authorize")).click();
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@inputmode='numeric']")));
//        driver.findElement(By.xpath("//input[@inputmode='numeric']")).sendKeys("11111");
//        Thread.sleep(4000);
//        if (isDisplayed()) {
//            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='modal__close']")));
//            driver.findElement(By.xpath("//button[@class='modal__close']")).click();
//        }

        new LoginPage(driver)
                .login("t_eq_ezivankov", "Test123")
                .sendSms();



        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Переводы']")));
        driver.findElement(By.xpath("//*[text()='Переводы']")).click();
        driver.findElement(By.xpath("//*[text()='Ценные бумаги']")).click();

    }

    @Test
    @DisplayName("Проверка зачисления ЦБ")
    void depoTransferIn() {

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("security-name")));
        driver.findElement(By.id("security-name")).sendKeys("Втб");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='RU000A0JP5V6 / 10401000B']")));
        driver.findElement(By.xpath("//div[.='RU000A0JP5V6 / 10401000B']")).click();
        driver.findElement(By.id("security-amount")).sendKeys("88");
        driver.findElement(By.xpath("//button[@class='select-button select-button_size_m select-button_theme_alfa-on-white']/span/span[.='Выберите место хранения']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='АО Альфа-Банк']")));
        driver.findElement(By.xpath("//div[.='АО Альфа-Банк']")).click();
        driver.findElement(By.id("despository-bank-broker-name")).sendKeys("Контраагент");
        driver.findElement(By.id("depo-account-num")).sendKeys("2050100000");


        WebElement element = driver.findElement(By.id("tarif-checkbox"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("send-transfer-request")));
        driver.findElement(By.id("send-transfer-request")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@inputmode='numeric']")));
        driver.findElement(By.xpath("//input[@inputmode='numeric']")).sendKeys("11111");


        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='notification__content']/div/span[.='Поручение принято к исполнению']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//div[@class='notification__content']/div/span[.='Поручение принято к исполнению']")).isDisplayed());


    }

    @Test
    @DisplayName("Проверка пакетного зачисления ЦБ")
    void depoTransferMassIn() {

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.= 'Пакетное зачисление']")));
        driver.findElement(By.xpath("//a[.= 'Пакетное зачисление']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='select-button__text']/span[.= 'Выберите субсчёт']")));
        driver.findElement(By.xpath("//span[@class='select-button__text']/span[.= 'Выберите субсчёт']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='1048654-000']")));
        driver.findElement(By.xpath("//span[.='1048654-000']")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='select-button__text']/span[.='Выберите рынок']")));
        driver.findElement(By.xpath("//span[@class='select-button__text']/span[.='Выберите рынок']")).click();
        List<WebElement> rialtoList = driver.findElements(
                By.xpath("//div[contains(@class, 'white')]/span[.='Московская биржа (НРД)']"));
        rialtoList.get(1).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("security-name")));
        driver.findElement(By.id("security-name")).sendKeys("Лукойл");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='RU0009024277 / 1-01-00077-A']")));
        driver.findElement(By.xpath("//div[.='RU0009024277 / 1-01-00077-A']")).click();
        driver.findElement(By.id("security-amount")).sendKeys("11");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'white')]/span/span[.='Добавить ещё одну']")));
        driver.findElement(By.xpath("//button[contains(@class, 'white')]/span/span[.='Добавить ещё одну']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("security-name")));
        driver.findElement(By.id("security-name")).sendKeys("Газпром");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='RU0007661625 / 1-02-00028-A']")));
        driver.findElement(By.xpath("//div[.='RU0007661625 / 1-02-00028-A']")).click();
        driver.findElement(By.id("security-amount")).sendKeys("22");

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'white')]/span/span[.='Выберите контрагента']")));
        driver.findElement(By.xpath("//button[contains(@class, 'white')]/span/span[.='Выберите контрагента']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/span[.='ООО «АТОН»']")));
        driver.findElement(By.xpath("//div/span[.='ООО «АТОН»']")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("send-transfer-request")));
        driver.findElement(By.id("send-transfer-request")).click();

    }


    @AfterEach
    void quitBrowser (){
        driver.quit();
    }
}

