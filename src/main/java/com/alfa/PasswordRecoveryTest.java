package com.alfa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasswordRecoveryTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://ip12.alfadirect.ru/");

        driver.findElement(By.xpath("//a[@href='/password-restore']")).click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(2));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("register-name-surname")));

        driver.findElement(By.id("register-name-surname")).sendKeys("Гедель");
        driver.findElement(By.id("register-name-name")).sendKeys("Павел");
        driver.findElement(By.id("register-name-secondname")).sendKeys("Михайлович");
        driver.findElement(By.id("phone")).sendKeys("9051005975");
        driver.findElement(By.id("on-line-bank-btn")).click();
        Thread.sleep(2000);
//        WebDriverWait webDriverWait2 = new WebDriverWait(driver, Duration.ofSeconds(2));
//        webDriverWait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='tel']")));
        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("0000");
//        driver.quit();


    }
}



