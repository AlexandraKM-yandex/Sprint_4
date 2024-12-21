package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {
    private WebDriver driver;
    private By headingWhoSamokat = By.xpath(".//div[@class = 'Order_Header__BZXOb' and text() = 'Для кого самокат']");
    private By fieldName = By.xpath(".//input[@placeholder = '* Имя']");
    private By fieldSurname = By.xpath(".//input[@placeholder = '* Фамилия']");
    private By fieldAdress = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    private By fieldMetroStation = By.xpath(".//input[@placeholder = '* Станция метро']");
    private By fieldTelephone = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    private By buttonNext1 = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее')]");
    private By headingAboutRent = By.xpath(".//div[@class = 'Order_Header__BZXOb' and text() = 'Про аренду']");
    private By fieldData = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    private By fieldRentalPeriod = By.xpath(".//div[@class='Dropdown-control']");
    private By fieldColorSamokatBlack = By.xpath(".//input[@id = 'black']");
    private By fieldColorSamokatGrey = By.xpath(".//input[@id = 'grey']");
    private By fieldComment = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    private By buttonOrder = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]");
    private By buttonOrderYes = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да')]");
    private By OrderPlacedSuccess = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text() = 'Заказ оформлен']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getHeadingWhoSamokat() {
        return this.headingWhoSamokat;
    }

    public void nameSet(String name) {
        this.driver.findElement(this.fieldName).sendKeys(new CharSequence[]{name});
    }

    public void surnameSet(String surname) {
        this.driver.findElement(this.fieldSurname).sendKeys(new CharSequence[]{surname});
    }

    public void adressSet(String address) {
        this.driver.findElement(this.fieldAdress).sendKeys(new CharSequence[]{address});
    }

    public void metroSet(String metro) {
        this.driver.findElement(this.fieldMetroStation).click();
        this.driver.findElement(this.fieldMetroStation).sendKeys(new CharSequence[]{metro});
        this.driver.findElement(this.fieldMetroStation).sendKeys(new CharSequence[]{Keys.DOWN, Keys.ENTER});
    }

    public void telephoneSet(String telephone) {
        this.driver.findElement(this.fieldTelephone).sendKeys(new CharSequence[]{telephone});
    }

    public void buttonNext1Set() {
        this.driver.findElement(this.buttonNext1).click();
        WebDriverWait wait = new WebDriverWait(this.driver, 5L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.headingAboutRent));
    }

    public void dataSet(String date) {
        this.driver.findElement(this.fieldData).sendKeys(new CharSequence[]{date});
        this.driver.findElement(this.fieldData).sendKeys(new CharSequence[]{Keys.ENTER});
    }

    public void periodSet(String rentalPeriod) {
        this.driver.findElement(this.fieldRentalPeriod).click();
        this.driver.findElement(By.xpath(".//div[text()='" + rentalPeriod + "']")).click();
    }

    public void colorSet(String color) {
        if ("Черный жемчуг".equalsIgnoreCase(color)) {
            this.driver.findElement(this.fieldColorSamokatBlack).click();
        } else if ("Серая безысходность".equalsIgnoreCase(color)) {
            this.driver.findElement(this.fieldColorSamokatGrey).click();
        }
    }

    public void commentSet(String comment) {
        this.driver.findElement(this.fieldComment).sendKeys(new CharSequence[]{comment});
    }

    public void buttonOrderSet() {
        this.driver.findElement(this.buttonOrder).click();
        WebDriverWait wait = new WebDriverWait(this.driver, 3L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.buttonOrderYes));
    }

    public void buttonOrderYesSet() {
        this.driver.findElement(this.buttonOrderYes).click();
    }

    public boolean modalWindowComplete() {
        WebElement Order_Placed_Success = (WebElement)(new WebDriverWait(this.driver, 3L)).until(ExpectedConditions.visibilityOfElementLocated(this.OrderPlacedSuccess));
        return Order_Placed_Success.isDisplayed();
    }
}
