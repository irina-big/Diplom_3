package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import static pageobjects.AllLocators.*;
public class PageLogin {
    public WebDriver driver;
    public Waits waits;

    public PageLogin(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    @Step("Клик по кнопке ВОЙТИ на странице входа")
    public void buttonLogin_click() throws InterruptedException {
        waits.sleep(5);
        waits.waitWhileElementToBeClickable(BUTTON_LOGIN);
        driver.findElement(BUTTON_LOGIN).click();
    }

    @Step("Заполнить поле Email")
    public void fieldEmail_fill(String email){
        driver.findElement(FIELD_EMAIL_LOGIN).clear();
        driver.findElement(FIELD_EMAIL_LOGIN).sendKeys(email);
    }

    @Step("Заполнить поле Password")
    public void fieldPassword_fill(String password){
        driver.findElement(FIELD_PASSWORD_LOGIN).clear();
        driver.findElement(FIELD_PASSWORD_LOGIN).sendKeys(password);
    }

    @Step("Клик по ссылке ВОССТАНОВИТЬ ПАРОЛЬ")
    public void passwordRecovery_click() throws InterruptedException {
        waits.sleep(5);
        waits.waitWhileElementToBeClickable(LINK_PASSWORD_RECOVERY);
        driver.findElement(LINK_PASSWORD_RECOVERY).click();
    }
    protected boolean element_isDisplayed(By element){
        try {
            waits.sleep(5);
            waits.waitWhileElementToBeClickable(element);
            return driver.findElement(element).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void fillAllFieldsAndSignIn(String email, String password) throws InterruptedException {
        fieldEmail_fill(email);
        fieldPassword_fill(password);
        buttonLogin_click();
    }

    @Step ("Страница входа загрузилась")
    public boolean headerLoginOnDisplay() throws InterruptedException {
        waits.sleep(5);
        waits.waitUntilElementToBeVisibility(HEADER_LOGIN);
        return  driver.findElement(HEADER_LOGIN).getText().equals("Вход");
    }
}



