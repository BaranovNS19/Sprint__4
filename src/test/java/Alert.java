import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.MainPage;
import pageObject.PersonalData;

public class Alert {
    private WebDriver driver;

    @Before
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nikol\\Documents\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void checkAlert(){
        MainPage mainPage = new MainPage(driver);
        mainPage.scroll();
        mainPage.clickOrderDownButton();
        PersonalData personalData = new PersonalData(driver);
        personalData.clickNext();
        String expectedTextName = "Введите корректное имя";
        Assert.assertEquals(expectedTextName, personalData.expectationAlertName());
        String expectedTextSurname = "Введите корректную фамилию";
        Assert.assertEquals(expectedTextSurname, personalData.expectationAlertSurname());
        String expectedTextMetro = "Выберите станцию";
        Assert.assertEquals(expectedTextMetro, personalData.expectationAlertMetro());
        String expectedTextPhone = "Введите корректный номер";
        Assert.assertEquals(expectedTextPhone, personalData.expectationAlertPhone());


    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}


