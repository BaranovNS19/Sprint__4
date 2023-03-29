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

    private final String questions;
    private final String expectedResponse;
    private final String actualResponse;



    public QuestionsText(String questions, String expectedResponse, String actualResponse){
        this.questions = questions;
        this.expectedResponse = expectedResponse;
        this.actualResponse = actualResponse;

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
                {"//div[text()='Сколько это стоит? И как оплатить?']", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", "//p[text()='Сутки — 400 рублей. Оплата курьеру — наличными или картой.']"
                },
                {"//div[text()='Хочу сразу несколько самокатов! Так можно?']", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", "//p[text()='Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.']"
                },
                {"//div[text()='Как рассчитывается время аренды?']", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", "//p[text()='Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.']"
                },
                {"//div[text()='Можно ли заказать самокат прямо на сегодня?']", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", "//p[text()='Только начиная с завтрашнего дня. Но скоро станем расторопнее.']"
                },
                {"//div[text()='Можно ли продлить заказ или вернуть самокат раньше?']", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", "//p[text()='Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.']"
                },
                {"//div[text()='Вы привозите зарядку вместе с самокатом?']", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", "//p[text()='Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.']"
                },
                {"//div[text()='Можно ли отменить заказ?']", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", "//p[text()='Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.']"
                },
                {"//div[text()='Я жизу за МКАДом, привезёте?']", "Да, обязательно. Всем самокатов! И Москве, и Московской области.", "//p[text()='Да, обязательно. Всем самокатов! И Москве, и Московской области.']"
                }



        };

    }

    @Test
    public void checkTextResponse(){
        MainPage mainPage = new MainPage(driver);
        mainPage.expectation();
        mainPage.scroll();
        Assert.assertEquals(expectedResponse, mainPage.textResponse(questions, actualResponse));

    }



    @After
    public void closeBrowser(){
        driver.quit();
    }


}


