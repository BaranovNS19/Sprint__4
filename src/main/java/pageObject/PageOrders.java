package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageOrders {
    private WebDriver driver;
    //Дисклеймер "Такого заказа нет"
    private final By notFoundOrder = By.xpath("//img[@alt='Not found']");
    //Логотип самоката
    private final By logoSamokat = By.xpath("//img[@alt='Scooter']");

    public PageOrders(WebDriver driver){
        this.driver = driver;
    }
    //Ожидание элемента "Такого заказа нет"
    public void expectationNotFound(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(notFoundOrder));
    }

    //Нажатие на логотип самоката
    public void clickLogoSamokat(){
        driver.findElement(logoSamokat).click();
    }
}


