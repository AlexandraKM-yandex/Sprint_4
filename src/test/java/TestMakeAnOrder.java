
import org.example.HomePage;
import org.example.OrderPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Parameterized.class)
public class TestMakeAnOrder {
    private WebDriver driver;

    // Параметры для тестирования кнопки "Заказать" (местоположение кнопки) и данных заказа
    private final String buttonLocation;
    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String telephone;
    private final String date;
    private final String rentalPeriod;
    private final String color;
    private final String comment;

    // Конструктор для параметризации
    public TestMakeAnOrder(String buttonLocation, String name, String surname, String address, String metro, String telephone, String date, String rentalPeriod, String color, String comment) {
        this.buttonLocation = buttonLocation;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.telephone = telephone;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.color = color;
        this.comment = comment;
    }

    // Параметры для теста (место кнопки и данные для заказа)
    @Parameterized.Parameters
    public static Object[][] orderDetails() {
        return new Object[][]{
                // Местоположение кнопки, данные для первого заказа
                {"header", "Александра", "Беликова", "ул. Пушкина, д.10", "Чистые пруды", "+9151234567", "01.01.2025", "сутки", "Черный жемчуг", "Не звонить в дверь"},
                // Местоположение кнопки, данные для второго заказа
                {"center", "Ирина", "Авдеева", "Маяковского 6", "Маяковская", "+79657654321", "12.12.2027", "двое суток", "Серая безысходность", "Привезите чистый самокат"}
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
    public void TestOrderAndButton() {
        HomePage objHomePage = new HomePage(this.driver);
        objHomePage.openSite();

        // В зависимости от местоположения кнопки выполняем разные действия
        if (buttonLocation.equals("header")) {
            objHomePage.clickButtonOrderInHeader();
        } else if (buttonLocation.equals("center")) {
            objHomePage.scrollPageToOrder();
            objHomePage.clickButtonOrderInCenter();
        }

        // Проверка видимости кнопки
        OrderPage objOrderPage = new OrderPage(this.driver);
        WebDriverWait wait = new WebDriverWait(this.driver, 5L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(objOrderPage.getHeadingWhoSamokat()));

        WebElement heading = this.driver.findElement(objOrderPage.getHeadingWhoSamokat());
        Assert.assertTrue(heading.isDisplayed());

        // Далее выполняем отправку заказа с использованием параметров для заказа
        objOrderPage.nameSet(this.name);
        objOrderPage.surnameSet(this.surname);
        objOrderPage.adressSet(this.address);
        objOrderPage.metroSet(this.metro);
        objOrderPage.telephoneSet(this.telephone);
        objOrderPage.buttonNext1Set();
        objOrderPage.dataSet(this.date);
        objOrderPage.periodSet(this.rentalPeriod);
        objOrderPage.colorSet(this.color);
        objOrderPage.commentSet(this.comment);
        objOrderPage.buttonOrderSet();
        objOrderPage.buttonOrderYesSet();
        objOrderPage.modalWindowComplete();
    }
}