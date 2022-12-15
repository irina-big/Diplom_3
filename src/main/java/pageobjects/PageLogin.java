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
    public void buttonLogin_click() {
        //   waits.scrollToElement(BUTTON_LOGIN);
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

    protected boolean element_isDisplayed(By element){
        try {
            return driver.findElement(element).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }



}



