package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static pageobjects.AllLocators.*;

public class PageRegister extends PageLogin{
    public PageRegister(WebDriver driver) {
        super(driver);
    }
    @Step("Клик по кнопке Зарегистрироваться")
    public void buttonRegistration_click() throws InterruptedException {
        waits.sleep(5);
        waits.waitWhileElementToBeClickable(BUTTON_REGISTRATION);
        driver.findElement(BUTTON_REGISTRATION).click();
    }

    @Step("Заполнили поле Name")
    public void fieldName_fill(String name){
        driver.findElement(FIELD_NAME).clear();
        driver.findElement(FIELD_NAME).sendKeys(name);
    }

    @Step("Заполнить поле Email")
    @Override
    public void fieldEmail_fill(String email){
        driver.findElement(FIELD_EMAIL_REGISTR).clear();
        driver.findElement(FIELD_EMAIL_REGISTR).sendKeys(email);
    }

    @Step("Заполнить поле Password")
    @Override
    public void fieldPassword_fill(String password){
        driver.findElement(FIELD_PASSWORD_REGISTR).clear();
        driver.findElement(FIELD_PASSWORD_REGISTR).sendKeys(password);
    }
   @Step("Заголовок ВХОД появился на экране")
    public boolean headerLogin_isDisplayed() {
       return  element_isDisplayed(HEADER_LOGIN);
    }
    @Step("Сообщение об ошибке НЕКОРРЕКТНЫЙ ПАРОЛЬ появилось на экране")
    public boolean incorrectPassword_isDisplayed(){
        return element_isDisplayed(INCORRECT_PASSWORD);
    }

    @Step("Клик по ссылке ВОЙТИ на странице регистрации")
    public void linkLogin_click() throws InterruptedException {
        waits.sleep(5);
        waits.waitWhileElementToBeClickable(LINK_LOGIN);
        driver.findElement(LINK_LOGIN).click();
    }
}
