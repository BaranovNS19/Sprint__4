package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalData {
    private WebDriver driver;

    //Поля заполнения данных

    //Кнопка "Далее"
    private final By next = By.xpath("//button[text()='Далее']");
    //Поле "Имя"
    private final By name = By.xpath("//input[@placeholder='* Имя']");
    //Поле "Фамилия"
    private final By surname = By.xpath("//input[@placeholder='* Фамилия']");
    //Поле "Адрес"
    private final By address = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле "Станция метро"
    private final By metro = By.xpath("//input[@placeholder='* Станция метро']");
    //Выпадающий список метро
    private final By metroList = By.xpath("//div[@class='select-search__select']");
    //Поле "Телефон"
    private final By phone = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");


    //Уведомления об обязательности полей

    //Введите корректное имя
    private final By alertName = By.xpath("//div[text()='Введите корректное имя']");
    //Введите корректную фамилию
    private final By alertSurname = By.xpath("//div[text()='Введите корректную фамилию']");
    //Выберете станцию
    private final By alertMetro = By.xpath("//div[text()='Выберите станцию']");
    //Введите корректный номер
    private final By alertPhone = By.xpath("//div[text()='Введите корректный номер']");
    //Логотип Самокат
    private final By logoSamokat = By.xpath("//img[@alt='Scooter']");


    //Конструктор
    public PersonalData(WebDriver driver) {
        this.driver = driver;
    }

    //Методы

    //Нажатие кнопки "Далее"
    public void clickNext() {
        driver.findElement(next).click();
    }
    //Ожидание уведомления "Введите корректное имя"
    public String expectationAlertName() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(alertName));
        String textAlertName = driver.findElement(alertName).getText();
        return textAlertName;
    }

    //Ожидание уведомления "Введите корректную фамилию"
    public String expectationAlertSurname() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(alertSurname));
        String textAlertSurname = driver.findElement(alertSurname).getText();
        return textAlertSurname;
    }

    //Ожидание уведомления "Выберите станцию"
    public String expectationAlertMetro() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(alertMetro));
        String textAlertMetro = driver.findElement(alertMetro).getText();
        return textAlertMetro;

    }

    //Ожидание уведомления "Выберите номер"
    public String expectationAlertPhone() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(alertPhone));
        String textAlertPhone = driver.findElement(alertPhone).getText();
        return textAlertPhone;

    }


    //Заполнение полей

    //Ввод имени
    public void inputName(String textName){
        driver.findElement(name).sendKeys(textName);
    }

    //Ввод фамилии
    public void inputSurname(String textSurname){
        driver.findElement(surname).sendKeys(textSurname);
    }

    //Ввод адреса
    public void inputAddress(String textAddress){
        driver.findElement(address).sendKeys(textAddress);
    }

    //Ввод станции метро
    public void inputMetro(String value){
        driver.findElement(metro).sendKeys(value);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(metroList));
        driver.findElement(metroList).click();

    }

    //Ввод номера телефона
    public void inputPhone(String textPhone){
        driver.findElement(phone).sendKeys(textPhone);
    }

    //Нажатие на логотип самоката
    public void clickLogoSamokat(){
        driver.findElement(logoSamokat).click();
    }
}


