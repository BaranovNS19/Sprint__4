package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AboutRent {
    private WebDriver driver;
    //Когда привезти самокат
    private final By date = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    //Срок аренды
    private final By rentalPeriod = By.xpath("//div[text()='* Срок аренды']");
    //Выпадающий список срок аренды //div[@class='Dropdown-option' and text()='сутки']
    private final By menuDropDown = By.xpath("//div[@class='Dropdown-menu']");
    //Значение из выпадающего списка
    private final By value = By.xpath("//div[@class='Dropdown-option' and text()='сутки']");
    //Цвет самоката
    //Черный жемчуг
    private final By blackColour = By.xpath("//input[@id='black']");
    //Серая безысходность
    private final By greyColour = By.xpath("//input[@id='grey']");
    //Комментарий для курьера
    private final By comment = By.xpath("//input[@placeholder='Комментарий для курьера']");
    //Кнопка "Заказать" нижняя
    private final By buttonOrderDown = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");


    public AboutRent(WebDriver driver){
        this.driver = driver;
    }

    //Ввод даты
    public void inputDate(String dateText){
        driver.findElement(date).sendKeys(dateText);
        driver.findElement(date).sendKeys(Keys.ENTER);
    }
    //Ввод срока аренды
    public void inputRentalPeriod(){
        driver.findElement(rentalPeriod).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(menuDropDown));
        driver.findElement(value).click();
    }

    //Выбор черного цвета самоката
    public void inputBlackColour(){
        driver.findElement(blackColour).click();
    }
    //Выбор серого цвета
    public void inputGreyColour(){
        driver.findElement(greyColour).click();
    }
    //Ввод комментария для курьера
    public void inputComment(String textComment){
        driver.findElement(comment).sendKeys(textComment);
    }
    //Нажать "Заказать"
    public void clickOrderDown(){
        driver.findElement(buttonOrderDown).click();
    }
}


