import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.MainPage;

public class QuestionsText {
    private WebDriver driver;
    @Before
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nikol\\Documents\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void checkTextResponse1(){
        MainPage mainPage = new MainPage(driver);
        mainPage.expectation();
        mainPage.scroll();
        String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        Assert.assertEquals(expected,mainPage.paymentQuestion());
    }

    @Test
    public void checkTextResponse2(){
        MainPage mainPage = new MainPage(driver);
        mainPage.expectation();
        mainPage.scroll();
        String expected = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        Assert.assertEquals(expected,mainPage.severalScootersQuestion());
    }

    @Test
    public void checkTextResponse3(){
        MainPage mainPage = new MainPage(driver);
        mainPage.expectation();
        mainPage.scroll();
        String expected = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        Assert.assertEquals(expected,mainPage.countingTimeQuestion());
    }

    @Test
    public void checkTextResponse4(){
        MainPage mainPage = new MainPage(driver);
        mainPage.expectation();
        mainPage.scroll();
        String expected = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        Assert.assertEquals(expected,mainPage.orderTodayQuestion());
    }

    @Test
    public void checkTextResponse5(){
        MainPage mainPage = new MainPage(driver);
        mainPage.expectation();
        mainPage.scroll();
        String expected = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        Assert.assertEquals(expected,mainPage.rentalTimeQuestion());
    }

    @Test
    public void checkTextResponse6(){
        MainPage mainPage = new MainPage(driver);
        mainPage.expectation();
        mainPage.scroll();
        String expected = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        Assert.assertEquals(expected,mainPage.chargingWillQuestion());
    }

    @Test
    public void checkTextResponse7(){
        MainPage mainPage = new MainPage(driver);
        mainPage.expectation();
        mainPage.scroll();
        String expected = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        Assert.assertEquals(expected,mainPage.cancelTheOrderQuestion());
    }

    @Test
    public void checkTextResponse8(){
        MainPage mainPage = new MainPage(driver);
        mainPage.expectation();
        mainPage.scroll();
        String expected = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        Assert.assertEquals(expected,mainPage.liveOutsideMoscowQuestion());
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }


}


