package com.alfa.lessons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasswordRecoveryTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://ip12.alfadirect.ru/");

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
        Assertions.assertEquals(driver.findElement(By.id("replenishment")).isDisplayed(), true);
        driver.quit();


    }
}



