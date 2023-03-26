import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.AboutRent;
import pageObject.ConfirmationOrder;
import pageObject.MainPage;
import pageObject.PersonalData;

@RunWith(Parameterized.class)
public class OrderingEndTwoEnd {
    private WebDriver driver;

    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;
    private final String dateText;
    private final String commentText;





    public OrderingEndTwoEnd(String name, String surname, String address, String metro, String phone, String dateText, String commentText) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.dateText = dateText;
        this.commentText = commentText;



    }

    @Parameterized.Parameters
    public static Object[][]getData(){

        return new Object[][] {
                {"Николай", "Баранов","Москва", "Лубянка", "89032451058", "01.04.2023", "Привет, курьер!"},
                {"Виктор", "Петров", "Мытищи","Медведково", "87779093450", "10.04.2023", "Позвонить по приезду"},
                {"Дарья", "Петькина", "Подольск", "Бунинская аллея", "89067632113", "07.08.2023", "12 этаж"}


        };

    }

    @Before
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nikol\\Documents\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void test(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOrderUpButton();
        PersonalData personalData = new PersonalData(driver);
        personalData.clickNext();
        personalData.expectationAlertName();
        personalData.expectationAlertSurname();
        personalData.expectationAlertMetro();
        personalData.expectationAlertPhone();
        personalData.inputName(name);
        personalData.inputSurname(surname);
        personalData.inputAddress(address);
        personalData.inputMetro(metro);
        personalData.inputPhone(phone);
        personalData.clickNext();
        AboutRent aboutRent = new AboutRent(driver);
        aboutRent.inputDate(dateText);
        aboutRent.inputRentalPeriod();
        aboutRent.inputBlackColour();
        aboutRent.inputGreyColour();
        aboutRent.inputComment(commentText);
        aboutRent.clickOrderDown();
        ConfirmationOrder confirmationOrder = new ConfirmationOrder(driver);
        confirmationOrder.clickYes();
        confirmationOrder.expectationStatus();
        confirmationOrder.clickButtonCheckStatus();
        confirmationOrder.expectationButtonCancel();

    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

}

