package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static pageobjects.AllLocators.*;

public class PageMain {
    WebDriver driver;
    Waits waits;
    public PageMain(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
    }
    @Step("Клик по кнопке ЛИЧНЫЙ КАБИНЕТ")
    public void buttonAccount_click() throws InterruptedException {
        waits.sleep(5);
        waits.waitWhileElementToBeClickable(BUTTON_ACCOUNT);
        driver.findElement(BUTTON_ACCOUNT).click();
    }
    @Step("Клик по кнопке ВОЙТИ В АККАУНТ на главной")
    public void buttonLoginAccount_click() throws InterruptedException {
        waits.sleep(5);
        waits.waitWhileElementToBeClickable(BUTTON_LOGIN_ACCOUNT);
        driver.findElement(BUTTON_LOGIN_ACCOUNT).click();
    }
    @Step ("Главная страница отображается на экране")
    public boolean mainPage_isDisplayed() throws InterruptedException {
        waits.sleep(5);
        return driver.getCurrentUrl().equals(BASE_URL);
    }
}
