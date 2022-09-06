package com.alfa;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WrapperClass {


    static WebDriver driver;
    static WebDriverWait webDriverWait;
    static String user;
   static boolean isDisplayed() {
        try {
            return driver.findElement(By.xpath("//button[@class='modal__close']")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    static void login(String user) throws InterruptedException {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
            driver.findElement(By.id("login")).sendKeys(user);
            driver.findElement(By.id("password")).sendKeys("Test123");
            driver.findElement(By.id("authorize")).click();
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@inputmode='numeric']")));
            driver.findElement(By.xpath("//input[@inputmode='numeric']")).sendKeys("11111");
            Thread.sleep(4000);
            if (isDisplayed()){
                webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='modal__close']")));
                driver.findElement(By.xpath("//button[@class='modal__close']")).click();
            }
        }
    }
