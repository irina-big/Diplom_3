package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import static pageObjects.AllLocators.*;

public class PageAccount {
    WebDriver driver;
    Waits waits;

    //конструктор класса
    public PageAccount(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
    }
    //*********** действия пользователя ***************

    public void buttonConstructor_click() {
        driver.findElement(BUTTON_CONSTRUCTOR).click();
    }

    public void buttonLogin_click(){
        waits.scrollToElement(BUTTON_LOGIN);
        waits.waitWhileElementToBeClickable(BUTTON_LOGIN);
        driver.findElement(BUTTON_LOGIN).click();
    }

    public void buttonAccount_click(){
        waits.scrollToElement(BUTTON_ACCOUNT);
        waits.waitWhileElementToBeClickable(BUTTON_ACCOUNT);
        driver.findElement(BUTTON_ACCOUNT).click();
    }

    public void fieldEmail_fill(String email){
        driver.findElement(FIELD_EMAIL).clear();
        driver.findElement(FIELD_EMAIL).sendKeys(email);
    }
    public void fieldPassword(String password){
        driver.findElement(FIELD_PASSWORD).clear();
        driver.findElement(FIELD_PASSWORD).sendKeys(password);
    }

    public void stellarBurgersLogo_click() {
        waits.waitWhileElementToBeClickable(STELLAR_BURGERS_LOGO);
        driver.findElement(STELLAR_BURGERS_LOGO).click();

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

    public boolean mainPage_isDisplayed(){
       return driver.getCurrentUrl().equals("https://stellarburgers.nomoreparties.site/");
    }
}
