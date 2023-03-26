import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.MainPage;
import pageObject.PageOrders;

// Проверка поиска заказа
@RunWith(Parameterized.class)
public class SearchOrder {
    private WebDriver driver;

    private final String number;

    public SearchOrder(String number){
        this.number = number;
    }

    @Parameterized.Parameters
    public static Object[][]getData(){

        return new Object[][] {
                {"000"},
                {"12345"},
                {"10"}



        };

    }
    @Before
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nikol\\Documents\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void checkSearchOrder(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickButtonStatusOrder();
        mainPage.enterNumberOrder(number);
        mainPage.clickButtonGo();
        PageOrders pageOrders = new PageOrders(driver);
        pageOrders.expectationNotFound();

    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

}
