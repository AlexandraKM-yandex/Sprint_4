import org.example.HomePage;
import org.example.Order;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

@RunWith(Parameterized.class)
public class MakeAnOrder {
    private WebDriver driver;
    private final String name;
    private final String surname;
    private final String adress;
    private final String metro;
    private final String telephone;
    private final String data;
    private final String rentalPeriod;
    private final String color;
    private final String comment;

    public MakeAnOrder(String name, String surname, String adress, String metro, String telephone, String data, String rentalPeriod, String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.metro = metro;
        this.telephone = telephone;
        this.data = data;
        this.rentalPeriod = rentalPeriod;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] SendOrderDetails() {
        return new Object[][]{{"Александра", "Беликова", "ул. Пушкина, д.10", "Чистые пруды", "+9151234567", "01.01.2025", "сутки", "Черный жемчуг", "Не звонить в дверь"}, {"Ирина", "Авдеева", "Маяковского 6", "Маяковская", "+79657654321", "12.12.2027", "двое суток", "Серая безысходность", "Привезите чистый самокат"}};
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
    public void testOrder() {
        HomePage objHomePage = new HomePage(this.driver);
        objHomePage.openSite();
        objHomePage.clickButtonOrderInHeader();
        Order objOrder = new Order(this.driver);
        objOrder.nameSet(this.name);
        objOrder.surnameSet(this.surname);
        objOrder.adressSet(this.adress);
        objOrder.metroSet(this.metro);
        objOrder.telephoneSet(this.telephone);
        objOrder.buttonNext1Set();
        objOrder.dataSet(this.data);
        objOrder.periodSet(this.rentalPeriod);
        objOrder.colorSet(this.color);
        objOrder.commentSet(this.comment);
        objOrder.buttonOrderSet();
        objOrder.buttonOrderYesSet();
        objOrder.ModalWindowComplete();
    }
}
