package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmationOrder {
    private WebDriver driver;
    //Модальное окно
    private final By modalOrder = By.xpath("//div[@class='Order_Modal__YZ-d3']");
    //Кнопка "Да"
    private final By buttonYes = By.xpath("//button[text()='Да']");
    //Статус "Заказ оформлен"
    private final By statusFramed = By.xpath("//div[text()='Заказ оформлен']");
    //Кнопка "Посмотреть статус"
    private final By checkStatus = By.xpath("//button[text()='Посмотреть статус']");
    //Кнопка "Отменить заказ"
    private final By cancelOrder = By.xpath("//button[text()='Отменить заказ']");
    public ConfirmationOrder(WebDriver driver){
        this.driver = driver;
    }

    //Нажатие "Да"
    public void clickYes(){
        driver.findElement(buttonYes).click();
    }

    //Ожидание статуса "Заказ оформлен"
    public void expectationStatus(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(statusFramed));
    }

    //Нажатие кнопки "Посмотреть статус"
    public void clickButtonCheckStatus(){
        driver.findElement(checkStatus).click();
    }

    //Ожидание кнопки "Отменить заказ"
    public void expectationButtonCancel(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(cancelOrder));
    }
}


