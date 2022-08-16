package com.alfa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://ip12.alfadirect.ru/");
        driver.findElement(By.id("login")).sendKeys("t_eq_d_nikonov");
        driver.findElement(By.id("password")).sendKeys("Test123");
        driver.findElement(By.id("authorize")).click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@inputmode='numeric']")));
        driver.findElement(By.xpath("//input[@inputmode='numeric']")).sendKeys("11111");

        driver.quit();

    }
}
