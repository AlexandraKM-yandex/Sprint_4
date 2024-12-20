import org.example.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class QuestionList {
    private WebDriver driver;

    public QuestionList() {
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
    public void dropDownListTest() {
        HomePage objHomePage = new HomePage(this.driver);
        objHomePage.openSite();
        objHomePage.cookieСlick();
        objHomePage.scrollPageToQuestion();
        objHomePage.clickQuestion1();
        objHomePage.checkCorrect(objHomePage.getAnswerFact1(), "Сутки — 400 рублей. Оплата курьеру — наличными или картой.");
        objHomePage.clickQuestion2();
        objHomePage.checkCorrect(objHomePage.getAnswerFact2(), "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.");
        objHomePage.clickQuestion3();
        objHomePage.checkCorrect(objHomePage.getAnswerFact3(), "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.");
        objHomePage.clickQuestion4();
        objHomePage.checkCorrect(objHomePage.getAnswerFact4(), "Только начиная с завтрашнего дня. Но скоро станем расторопнее.");
        objHomePage.clickQuestion5();
        objHomePage.checkCorrect(objHomePage.getAnswerFact5(), "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.");
        objHomePage.clickQuestion6();
        objHomePage.checkCorrect(objHomePage.getAnswerFact6(), "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.");
        objHomePage.clickQuestion7();
        objHomePage.checkCorrect(objHomePage.getAnswerFact7(), "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.");
        objHomePage.clickQuestion8();
        objHomePage.checkCorrect(objHomePage.getAnswerFact8(), "Да, обязательно. Всем самокатов! И Москве, и Московской области.");
    }
}