package org.example;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private static WebDriver driver;
    private By buttonOrderInHeader = By.xpath(".//button[(@class ='Button_Button__ra12g' and text()='Заказать')]");
    private By buttonOrderInСenter = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]");
    private By buttonCookie = By.xpath(".//button[@class = 'App_CookieButton__3cvqF' and text() = 'да все привыкли']");
    private By ButtonQuestion1 = By.id("accordion__heading-0");
    private By ButtonQuestion2 = By.id("accordion__heading-1");
    private By ButtonQuestion3 = By.id("accordion__heading-2");
    private By ButtonQuestion4 = By.id("accordion__heading-3");
    private By ButtonQuestion5 = By.id("accordion__heading-4");
    private By ButtonQuestion6 = By.id("accordion__heading-5");
    private By ButtonQuestion7 = By.id("accordion__heading-6");
    private By ButtonQuestion8 = By.id("accordion__heading-7");
    private By ButtonAnswer1 = By.id("accordion__panel-0");
    private By ButtonAnswer2 = By.id("accordion__panel-1");
    private By ButtonAnswer3 = By.id("accordion__panel-2");
    private By ButtonAnswer4 = By.id("accordion__panel-3");
    private By ButtonAnswer5 = By.id("accordion__panel-4");
    private By ButtonAnswer6 = By.id("accordion__panel-5");
    private By ButtonAnswer7 = By.id("accordion__panel-6");
    private By ButtonAnswer8 = By.id("accordion__panel-7");
    public static final String answerText1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String answerText2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String answerText3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String answerText4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String answerText5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String answerText6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String answerText7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String answerText8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    public HomePage(WebDriver driver) {
        HomePage.driver = driver;
    }

    public void openSite() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public void cookieСlick() {
        driver.findElement(this.buttonCookie).click();
    }

    public void clickButtonOrderInHeader() {
        driver.findElement(this.buttonOrderInHeader).click();
    }

    public void clickButtonOrderInCenter() {
        driver.findElement(this.buttonOrderInСenter).click();
    }

    public HomePage scrollPageToQuestion() {
        WebElement lastQuestionArrow = driver.findElement(this.ButtonQuestion8);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", new Object[]{lastQuestionArrow});
        return this;
    }

    public HomePage scrollPageToOrder() {
        WebElement ScrollButtonOrderInCentre = driver.findElement(this.buttonOrderInСenter);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", new Object[]{ScrollButtonOrderInCentre});
        return this;
    }

    public void clickQuestion1() {
        driver.findElement(this.ButtonQuestion1).click();
    }

    public void clickQuestion2() {
        driver.findElement(this.ButtonQuestion2).click();
    }

    public void clickQuestion3() {
        driver.findElement(this.ButtonQuestion3).click();
    }

    public void clickQuestion4() {
        driver.findElement(this.ButtonQuestion4).click();
    }

    public void clickQuestion5() {
        driver.findElement(this.ButtonQuestion5).click();
    }

    public void clickQuestion6() {
        driver.findElement(this.ButtonQuestion6).click();
    }

    public void clickQuestion7() {
        driver.findElement(this.ButtonQuestion7).click();
    }

    public void clickQuestion8() {
        driver.findElement(this.ButtonQuestion8).click();
    }

    public void checkCorrect(String answer, String text) {
        Assert.assertEquals(answer, text);
    }

    public String getAnswerFact1() {
        return driver.findElement(this.ButtonAnswer1).getText();
    }

    public String getAnswerFact2() {
        return driver.findElement(this.ButtonAnswer2).getText();
    }

    public String getAnswerFact3() {
        return driver.findElement(this.ButtonAnswer3).getText();
    }

    public String getAnswerFact4() {
        return driver.findElement(this.ButtonAnswer4).getText();
    }

    public String getAnswerFact5() {
        return driver.findElement(this.ButtonAnswer5).getText();
    }

    public String getAnswerFact6() {
        return driver.findElement(this.ButtonAnswer6).getText();
    }

    public String getAnswerFact7() {
        return driver.findElement(this.ButtonAnswer7).getText();
    }

    public String getAnswerFact8() {
        return driver.findElement(this.ButtonAnswer8).getText();
    }
}
