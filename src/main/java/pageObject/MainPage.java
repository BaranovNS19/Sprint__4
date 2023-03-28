package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;
    //Текст заголовок главной страницы
    private final By homeHeader = By.xpath("//div[@class='Home_Header__iJKdX']");
    //Логотип "Яндекс"
    private final By logoYandex = By.xpath("//img[@alt='Yandex']");
    //Страница Яндекс Дзен
    private final By pageYandexDzen = By.xpath("zen-page _browser-name_chrome _browser-base_chromium _theme_white");
    //Кнопки "Заказать"
    private final By orderUp = By.xpath("//button[@class='Button_Button__ra12g']");
    private final By orderDown = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Кнопка "Статус заказа"
    private final By statusOrderButton = By.xpath("//button[text()='Статус заказа']");
    //Поле "Введите номер заказа"
    private final By enterOrderNumber = By.xpath("//input[@placeholder='Введите номер заказа']");
    //Кнопка "Go!"
    private final By buttonGo = By.xpath("//button[text()='Go!']");

    //"Вопросы о важном"
    private final By questionsAboutImportant = By.xpath("//div[text()='Вопросы о важном']");

    // 1 вопрос/ответ
    private final By payment = By.xpath("//div[text()='Сколько это стоит? И как оплатить?']");
    private final By paymentResponse = By.xpath("//p[text()='Сутки — 400 рублей. Оплата курьеру — наличными или картой.']");

    // 2 вопрос/ответ
    private final By severalScooters = By.xpath("//div[text()='Хочу сразу несколько самокатов! Так можно?']");
    private final By severalScootersResponse = By.xpath("//p[text()='Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.']");

    // 3 вопрос/ответ
    private final By countingTime = By.xpath("//div[text()='Как рассчитывается время аренды?']");
    private final By countingTimeResponse = By.xpath("//p[text()='Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.']");

    // 4 вопрос/ответ
    private final By orderToday = By.xpath("//div[text()='Можно ли заказать самокат прямо на сегодня?']");
    private final By orderTodayResponse = By.xpath("//p[text()='Только начиная с завтрашнего дня. Но скоро станем расторопнее.']");

    // 5 вопрос/ответ
    private final By rentalTime = By.xpath("//div[text()='Можно ли продлить заказ или вернуть самокат раньше?']");
    private final By rentalTimeResponse = By.xpath("//p[text()='Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.']");

    // 6 вопрос/ответ
    private final By chargingWill = By.xpath("//div[text()='Вы привозите зарядку вместе с самокатом?']");
    private final By chargingWillResponse = By.xpath("//p[text()='Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.']");

    // 7 вопрос/ответ
    private final By cancelTheOrder = By.xpath("//div[text()='Можно ли отменить заказ?']");
    private final By cancelTheOrderResponse = By.xpath("//p[text()='Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.']");

    // 8 вопрос/ответ
    private final By liveOutsideMoscow = By.xpath("//div[text()='Я жизу за МКАДом, привезёте?']");
    private final By liveOutsideMoscowResponse = By.xpath("//p[text()='Да, обязательно. Всем самокатов! И Москве, и Московской области.']");

    // Кнопка "да все привыкли"
    private final By buttonCookie = By.xpath("//button[text()='да все привыкли']");
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    public String paymentQuestion(){
        driver.findElement(payment).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(paymentResponse));
        String textResponse = driver.findElement(paymentResponse).getText();
        return textResponse;
    }

    public String severalScootersQuestion(){
        driver.findElement(severalScooters).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(severalScootersResponse));
        String textResponse = driver.findElement(severalScootersResponse).getText();
        return textResponse;
    }

    public String countingTimeQuestion(){
        driver.findElement(countingTime).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(countingTimeResponse));
        String textResponse = driver.findElement(countingTimeResponse).getText();
        return textResponse;
    }

    public String orderTodayQuestion(){
        driver.findElement(orderToday).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(orderTodayResponse));
        String textResponse = driver.findElement(orderTodayResponse).getText();
        return textResponse;
    }

    public String rentalTimeQuestion(){
        driver.findElement(rentalTime).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(rentalTimeResponse));
        String textResponse = driver.findElement(rentalTimeResponse).getText();
        return textResponse;
    }

    public String chargingWillQuestion(){
        driver.findElement(chargingWill).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(chargingWillResponse));
        String textResponse = driver.findElement(chargingWillResponse).getText();
        return textResponse;
    }

    public String cancelTheOrderQuestion(){
        driver.findElement(cancelTheOrder).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(cancelTheOrderResponse));
        String textResponse = driver.findElement(cancelTheOrderResponse).getText();
        return textResponse;
    }

    public String liveOutsideMoscowQuestion(){
        driver.findElement(liveOutsideMoscow).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(liveOutsideMoscowResponse));
        String textResponse = driver.findElement(liveOutsideMoscowResponse).getText();
        return textResponse;
    }

    //Нажатие кнопки "Статус заказа"
    public void clickButtonStatusOrder(){
        driver.findElement(statusOrderButton).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(enterOrderNumber));
    }

    //Ввод номера заказа
    public void enterNumberOrder(String number){
        driver.findElement(enterOrderNumber).sendKeys(number);
    }

    //Нажатие кнопки "Go!"
    public void clickButtonGo(){
        driver.findElement(buttonGo).click();
    }


    public void scroll(){
        WebElement element = driver.findElement(questionsAboutImportant);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void expectation(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Сколько это стоит? И как оплатить?']")));


    }

    public void clickOrderUpButton(){
        driver.findElement(orderUp).click();
    }

    public void clickOrderDownButton(){
        driver.findElement(orderDown).click();
    }

    public void clickOrderButton(String xpath){
        driver.findElement(buttonCookie).click();
        driver.findElement(By.xpath(xpath)).click();
    }

    //Ожидание элементов главной страницы
    public void expectElementsMainPage(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(statusOrderButton));
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(orderUp));
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(homeHeader));
    }

    //Нажатие на логотип "Яндекс"
    public void clickLogoYandex(){
        driver.findElement(logoYandex).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(pageYandexDzen));
    }

    //Нажатие на кнопку "да все привыкли"
    public void clickButtonCookie(){
        driver.findElement(buttonCookie).click();
    }

}




