package org.example;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private static WebDriver driver;

    //Вопросы
    public static final By QUESTION_PRICE_AND_PAYMENT = By.id("accordion__heading-0");
    public static final By QUESTION_MULTIPLE_SCOOTERS = By.id("accordion__heading-1");
    public static final By QUESTION_RENTAL_DURATION = By.id("accordion__heading-2");
    public static final By QUESTION_ORDER_SAME_DAY = By.id("accordion__heading-3");
    public static final By QUESTION_EARLY_RETURN = By.id("accordion__heading-4");
    public static final By QUESTION_CHARGING_INCLUDED = By.id("accordion__heading-5");
    public static final By QUESTION_CANCEL_ORDER = By.id("accordion__heading-6");
    public static final By QUESTION_DELIVERY_OUTSIDE_MKAD = By.id("accordion__heading-7");

    //Ответы
    public static final By ANSWER_PRICE_AND_PAYMENT = By.id("accordion__panel-0");
    public static final By ANSWER_MULTIPLE_SCOOTERS = By.id("accordion__panel-1");
    public static final By ANSWER_RENTAL_DURATION = By.id("accordion__panel-2");
    public static final By ANSWER_ORDER_SAME_DAY = By.id("accordion__panel-3");
    public static final By ANSWER_EARLY_RETURN = By.id("accordion__panel-4");
    public static final By ANSWER_CHARGING_INCLUDED = By.id("accordion__panel-5");
    public static final By ANSWER_CANCEL_ORDER = By.id("accordion__panel-6");
    public static final By ANSWER_DELIVERY_OUTSIDE_MKAD = By.id("accordion__panel-7");

    //Ожидаемый текст
    public static final String RENTAL_COST_INFO = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String SCOOTER_PER_ORDER_POLICY = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String RENTAL_TIME_RULES = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String DELIVERY_START_TIME = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String URGENT_SUPPORT_INFO = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String SCOOTER_BATTERY_INFO = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String CANCEL_ORDER_POLICY = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String DELIVERY_AREA_INFO = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    //Локатор кнопки "Заказать" в хэдере
    private By buttonOrderInHeader = By.xpath(".//button[(@class ='Button_Button__ra12g' and text()='Заказать')]");
    //Локатор кнопки "Заказать" в центре страницы
    private By buttonOrderInCenter = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]");
    //Локатор кнопки "куки"
    private By buttonCookie = By.xpath(".//button[@class = 'App_CookieButton__3cvqF' and text() = 'да все привыкли']");



    public HomePage(WebDriver driver) {
        HomePage.driver = driver;
    }

    public void openSite() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public void cookieClick() {
        driver.findElement(buttonCookie).click();
    }

    public void clickButtonOrderInHeader() {
        driver.findElement(buttonOrderInHeader).click();
    }

    public void clickButtonOrderInCenter() {
        driver.findElement(buttonOrderInCenter).click();
    }

    //Скролл до 8 вопроса
    public HomePage scrollPageToQuestion() {
        WebElement lastQuestionArrow = driver.findElement(ANSWER_DELIVERY_OUTSIDE_MKAD);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", new Object[]{lastQuestionArrow});
        return this;
    }

    //Скролл до кнопки заказать в центре страницы
    public HomePage scrollPageToOrder() {
        WebElement ScrollButtonOrderInCentre = driver.findElement(this.buttonOrderInCenter);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", new Object[]{ScrollButtonOrderInCentre});
        return this;
    }

    //Клик по вопросам
    public void clickQuestion(By question) {
        driver.findElement(question).click();
    }

    //Проверяем ожидаемый текст и фактический
    public void checkCorrect(String answer, String text) {
        Assert.assertEquals(answer, text);
    }

    //Запрашиваем фактический текст
    public String getAnswerFact(By answer) {
        return driver.findElement(answer).getText();
    }

}
