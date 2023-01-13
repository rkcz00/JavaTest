package com.alfa.tests;

import com.alfa.BasePage;
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

    @FindBy(xpath = "//h4[contains(text(), 'При покупке')]")
    private WebElement question2_1;

    @FindBy(xpath = "//h4[contains(text(), 'Может ли ')]")
    private WebElement question2_2;

    @FindBy(id = "answer-1")
    private WebElement answer2_1;

    @FindBy(id = "answer-12")
    private WebElement answer2_2;

    @FindBy(id = "next")
    private WebElement nextButton;




    public WebElement checkQuestion(WebElement question1, WebElement question2) {
        try {
            return question1;

        } catch (NoSuchElementException e) {
            return question2;
        }
    }


    public WebElement selectAnswer(WebElement question1, WebElement question2, WebElement answer1, WebElement answer2) {

        if (checkQuestion(question1, question2) == question1) {
            return answer1;
        } else {
            return answer2;
        }
    }


    public MarginalTestPage answerQuestion1() {


        webDriverWait.until(ExpectedConditions.visibilityOf(checkQuestion(question1_1, question1_2)));
        WebElement element = selectAnswer(question1_1, question1_1, answer1_1, answer1_2);
        actions.moveToElement(element).click().build().perform();
        nextButton.click();

        return new MarginalTestPage(driver);
    }

    public MarginalTestPage answerQuestion2() {


        webDriverWait.until(ExpectedConditions.visibilityOf(checkQuestion(question1_1, question1_2)));
        WebElement element = selectAnswer(question1_1, question1_1, answer1_1, answer1_2);
        actions.moveToElement(element).click().build().perform();
        nextButton.click();

        return new MarginalTestPage(driver);
    }

}
