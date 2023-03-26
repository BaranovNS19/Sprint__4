import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.MainPage;
import pageObject.PageOrders;
import pageObject.PersonalData;

public class Redirect {
    private WebDriver driver;
    @Before
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nikol\\Documents\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void redirectOnMainPage(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOrderUpButton();
        PersonalData personalData = new PersonalData(driver);
        personalData.clickLogoSamokat();
        mainPage.expectElementsMainPage();
        mainPage.clickButtonStatusOrder();
        String number = "12345";
        mainPage.enterNumberOrder(number);
        mainPage.clickButtonGo();
        PageOrders pageOrders = new PageOrders(driver);
        pageOrders.clickLogoSamokat();
        mainPage.expectElementsMainPage();

    }

   /*
    Не нашел решение проверки URL в открывшейся вкладке
    @Test
    public void redirectOnYandexDzen(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLogoYandex();

    }*/

    @After
    public void closeBrowser(){
        driver.quit();
    }
}


