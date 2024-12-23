import org.example.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.example.HomePage.*;


@RunWith(Parameterized.class)

public class TestQuestionList {
    private WebDriver driver;

    private By question;
    private By answer;
    private String answerText;

    public TestQuestionList(By question, By answer, String answerText) {
        this.question = question;
        this.answer = answer;
        this.answerText = answerText;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {

                { QUESTION_PRICE_AND_PAYMENT,ANSWER_PRICE_AND_PAYMENT, RENTAL_COST_INFO},
                { QUESTION_MULTIPLE_SCOOTERS,ANSWER_MULTIPLE_SCOOTERS, SCOOTER_PER_ORDER_POLICY },
                { QUESTION_RENTAL_DURATION,ANSWER_RENTAL_DURATION, RENTAL_TIME_RULES },
                { QUESTION_ORDER_SAME_DAY,ANSWER_ORDER_SAME_DAY, DELIVERY_START_TIME},
                { QUESTION_EARLY_RETURN,ANSWER_EARLY_RETURN, URGENT_SUPPORT_INFO},
                { QUESTION_CHARGING_INCLUDED,ANSWER_CHARGING_INCLUDED, SCOOTER_BATTERY_INFO},
                { QUESTION_CANCEL_ORDER,ANSWER_CANCEL_ORDER, CANCEL_ORDER_POLICY},
                { QUESTION_DELIVERY_OUTSIDE_MKAD,ANSWER_DELIVERY_OUTSIDE_MKAD, DELIVERY_AREA_INFO}
        };
    }

    @Before
    public void before() {
        String browserName = System.getenv("BROWSER_NAME");
        this.driver = BrowserDriver.createForName(browserName != null ? browserName : "CHROME");
    }

    @After
    public void after() {
        this.driver.quit();
    }

    @Test
    public void TestDropDownListTest() {
        HomePage objHomePage = new HomePage(this.driver);
        objHomePage.openSite();
        objHomePage.cookieClick();
        objHomePage.scrollPageToQuestion();
        objHomePage.clickQuestion(question);
        String text = objHomePage.getAnswerFact(answer);
        objHomePage.checkCorrect(answerText, text);
    }
}
