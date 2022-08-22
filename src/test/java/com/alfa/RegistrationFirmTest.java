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

public class RegistrationFirmTest {

    WebDriver driver;
    WebDriverWait webDriverWait;
    static ChromeOptions chromeOptions = new ChromeOptions();
    private final static String LK_TEST_URL = "https://ip12.alfadirect.ru/registration-firm";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
        chromeOptions.addArguments("--headless");
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver(chromeOptions);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(LK_TEST_URL);

    }

    @Test
    @DisplayName("Проверка успешной регистрации ЮЛ")
    void registrationFirmTest() {
        int a = (int) (Math.random() * 900 + 1000);

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastname")));
        driver.findElement(By.id("lastname")).sendKeys("Храпченко");
        driver.findElement(By.id("firstname")).sendKeys("Людмила");
        driver.findElement(By.id("fullname")).sendKeys("Валерьевна");
        driver.findElement(By.id("passport")).sendKeys("1111111111");
        driver.findElement(By.id("phone")).sendKeys("77777777777");

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("registration-demo-submit")));
        driver.findElement(By.id("registration-demo-submit")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@inputmode='numeric']")));
        driver.findElement(By.xpath("//input[@inputmode='numeric']")).sendKeys("11111");

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
        driver.findElement(By.id("search")).sendKeys("ООО Анкор");

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("manual-link")));
        driver.findElement(By.id("manual-link")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inn")));
        driver.findElement(By.id("inn")).sendKeys("111111" + a);
        driver.findElement(By.id("ogrn")).sendKeys("222222222" + a);

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("firm-inn-submit")));
        driver.findElement(By.id("firm-inn-submit")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("full-name")));
        driver.findElement(By.id("full-name")).sendKeys("ООО Анкор " + a);
        driver.findElement(By.id("short-name")).sendKeys("ООО Анкор " + a);
        driver.findElement(By.id("inn")).sendKeys("111111" + a);
        driver.findElement(By.id("head-full-name")).sendKeys("Храпченко Людмила Валерьевна");
        driver.findElement(By.id("head-end-term")).sendKeys("15.02.2025");
        driver.findElement(By.id("ogrn")).sendKeys("1111111111111");
        driver.findElement(By.id("reg-date")).sendKeys("15.02.2017");
        driver.findElement(By.id("reg-ogrn")).sendKeys("ФНС");

        driver.findElement(By.id("search-legalAddress")).sendKeys("428024, Чувашия, Чебоксары, Эгерский бульвар, д. 5, к. 1");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='menu-item__control']")));
        driver.findElement(By.xpath("//span[@class='menu-item__control']")).click();

        driver.findElement(By.xpath("//*[text()='Да, совпадает']")).click();
        driver.findElement(By.id("license-series-number")).sendKeys("11" + a);
        driver.findElement(By.id("license-issue-date")).sendKeys("11.01.2020");
        driver.findElement(By.id("license-issue-authority")).sendKeys("ФНС");
        driver.findElement(By.id("license-activities")).sendKeys("Деятельность1, Деятельность2");
        driver.findElement(By.id("license-valid-to")).sendKeys("11.01.2030");
        driver.findElement(By.id("license-site")).sendKeys("www.rt.ru");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Добавить ещё одну']")));
        driver.findElement(By.xpath("//*[text()='Добавить ещё одну']")).click();
        driver.findElement(By.id("license-series-number")).sendKeys("22" + a);
        driver.findElement(By.id("license-issue-date")).sendKeys("22.02.2020");
        driver.findElement(By.id("license-issue-authority")).sendKeys("ФНС");
        driver.findElement(By.id("license-activities")).sendKeys("Деятельность3, Деятельность4");
        driver.findElement(By.id("license-valid-to")).sendKeys("22.02.2030");
        driver.findElement(By.id("license-site")).sendKeys("www.crteert.ru");

        driver.findElement(By.id("phone")).sendKeys("+7 777 777 77 77");
        driver.findElement(By.id("add-phone")).sendKeys("+7 888 888 88 88");
        driver.findElement(By.id("email")).sendKeys("rt@m.ru");

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("firm-info-submit")));
        driver.findElement(By.id("firm-info-submit")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Режим совершения сделок']")));
        driver.findElement(By.id("end-submit")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img")));
        Assertions.assertEquals(driver.findElement(By.xpath("//img")).isDisplayed(), true);


    }


    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}
