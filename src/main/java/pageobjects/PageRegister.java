package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import static pageobjects.AllLocators.*;

public class PageRegister {
    WebDriver driver;
    Waits waits;

    public PageRegister(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
    }
    //*********** действия пользователя ***************

    @Step("Клик по кнопке Зарегистрироваться")
    public void buttonRegistration_click(){
        waits.scrollToElement(BUTTON_REGISTRATION);
        waits.waitWhileElementToBeClickable(BUTTON_REGISTRATION);
        driver.findElement(BUTTON_REGISTRATION).click();
    }

    @Step("Заполнить поле Name")
    public void fieldName_fill(String name){

        driver.findElement(FIELD_NAME).clear();
        driver.findElement(FIELD_NAME).sendKeys(name);
    }

    @Step("Заполнить поле Email")
    public void fieldEmail_fill(String email){
        driver.findElement(FIELD_EMAIL).clear();
        driver.findElement(FIELD_EMAIL).sendKeys(email);
    }
    @Step("Заполнить поле Password")
    public void fieldPassword_fill(String password){
        driver.findElement(FIELD_PASSWORD).clear();
        driver.findElement(FIELD_PASSWORD).sendKeys(password);
    }


    private boolean element_isDisplayed(By element){
        try {
            return driver.findElement(element).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean buttonLogout_isDisplayed()
    {
        return element_isDisplayed(BUTTON_LOGOUT);
    }



}
