import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.MainPage;



@RunWith(Parameterized.class)
public class QuestionsText {
    private WebDriver driver;
    private final String response1;
    private final String response2;
    private final String response3;
    private final String response4;
    private final String response5;
    private final String response6;
    private final String response7;
    private final String response8;



    public QuestionsText(String response1, String response2, String response3, String response4, String response5, String response6, String response7, String response8){
        this.response1 = response1;
        this.response2 = response2;
        this.response3 = response3;
        this.response4 = response4;
        this.response5 = response5;
        this.response6 = response6;
        this.response7 = response7;
        this.response8 = response8;

    }
    @Before
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nikol\\Documents\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Parameterized.Parameters
    public static Object[][]getData(){


        return new Object[][] {
                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой." ,
                "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                "Да, обязательно. Всем самокатов! И Москве, и Московской области."}



        };

    }

    @Test
    public void checkTextResponse(){
        MainPage mainPage = new MainPage(driver);
        mainPage.expectation();
        mainPage.scroll();
        Assert.assertEquals(response1, mainPage.paymentQuestion());
        Assert.assertEquals(response2, mainPage.severalScootersQuestion());
        Assert.assertEquals(response3, mainPage.countingTimeQuestion());
        Assert.assertEquals(response4, mainPage.orderTodayQuestion());
        Assert.assertEquals(response5, mainPage.rentalTimeQuestion());
        Assert.assertEquals(response6, mainPage.chargingWillQuestion());
        Assert.assertEquals(response7, mainPage.cancelTheOrderQuestion());
        mainPage.clickButtonCookie();
        Assert.assertEquals(response8, mainPage.liveOutsideMoscowQuestion());
    }



    @After
    public void closeBrowser(){
        driver.quit();
    }


}


