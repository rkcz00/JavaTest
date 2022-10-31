package com.alfa.tests;

import com.alfa.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MarginalTestPage extends BasePage {
    public MarginalTestPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//h4[contains(text(), 'С какой целью')]")
    private WebElement question1_1;

    @FindBy(xpath = "//h4[contains(text(), 'Маржинальная торговля')]")
    private WebElement question1_2;

    @FindBy(id = "answer-592")
    private WebElement answer1_1;

    @FindBy(id = "answer-1")
    private WebElement answer1_2;

    @FindBy(id = "next")
    private WebElement nextButton;




    public WebElement checkQuestion1() {
        try {
            return question1_1;

        } catch (NoSuchElementException e) {
            return question1_2;
        }
    }


    public WebElement selectAnswer1() {

        if (checkQuestion1() == question1_1) {
            return answer1_1;
        }else{
            return answer1_2;}
    }




    public MarginalTestPage answerQuestion1() {


        webDriverWait.until(ExpectedConditions.visibilityOf(checkQuestion1()));
        WebElement element = selectAnswer1();
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        nextButton.click();

        return new MarginalTestPage(driver);
    }

}
