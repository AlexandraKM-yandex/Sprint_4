import org.example.HomePage;
import org.example.OrderPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestButtonOrder {
    private WebDriver driver;

    public TestButtonOrder() {
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
    public void TestOrderSamokatInHeader() {
        HomePage objHomePage = new HomePage(this.driver);
        objHomePage.openSite();
        objHomePage.clickButtonOrderInHeader();
        OrderPage objOrderPage = new OrderPage(this.driver);
        WebDriverWait wait = new WebDriverWait(this.driver, 5L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(objOrderPage.getHeadingWhoSamokat()));
        WebElement heading = this.driver.findElement(objOrderPage.getHeadingWhoSamokat());
        Assert.assertTrue(heading.isDisplayed());
    }

    @Test
    public void TestOrderSamokatInCenter() {
        HomePage objHomePage = new HomePage(this.driver);
        objHomePage.openSite();
        objHomePage.scrollPageToOrder();
        objHomePage.clickButtonOrderInCenter();
        OrderPage objOrderPage = new OrderPage(this.driver);
        WebDriverWait wait = new WebDriverWait(this.driver, 5L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(objOrderPage.getHeadingWhoSamokat()));
        WebElement heading = this.driver.findElement(objOrderPage.getHeadingWhoSamokat());
        Assert.assertTrue(heading.isDisplayed());
    }
}

