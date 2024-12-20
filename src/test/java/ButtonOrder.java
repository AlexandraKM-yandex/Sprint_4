import org.example.HomePage;
import org.example.Order;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ButtonOrder {
    private WebDriver driver;

    public ButtonOrder() {
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
    public void OrderSamokatInHeader() {
        HomePage objHomePage = new HomePage(this.driver);
        objHomePage.openSite();
        objHomePage.clickButtonOrderInHeader();
        Order objOrder = new Order(this.driver);
        WebDriverWait wait = new WebDriverWait(this.driver, 5L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(objOrder.getHeadingWhoSamokat()));
        WebElement heading = this.driver.findElement(objOrder.getHeadingWhoSamokat());
        Assert.assertTrue(heading.isDisplayed());
        this.driver.quit();
    }

    @Test
    public void OrderSamokatInCenter() {
        HomePage objHomePage = new HomePage(this.driver);
        objHomePage.openSite();
        objHomePage.scrollPageToOrder();
        objHomePage.clickButtonOrderInCenter();
        Order objOrder = new Order(this.driver);
        WebDriverWait wait = new WebDriverWait(this.driver, 5L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(objOrder.getHeadingWhoSamokat()));
        WebElement heading = this.driver.findElement(objOrder.getHeadingWhoSamokat());
        Assert.assertTrue(heading.isDisplayed());
    }
}

