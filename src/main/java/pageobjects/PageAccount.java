package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static pageobjects.AllLocators.*;

public class PageAccount {
    WebDriver driver;
    Waits waits;

    public PageAccount(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
    }
    //*********** действия пользователя ***************
    //Клик по кнопке ВОЙТИ на странице входа
    public void buttonLogin_click(){
        //   waits.scrollToElement(BUTTON_LOGIN);
        waits.waitWhileElementToBeClickable(BUTTON_LOGIN);
        driver.findElement(BUTTON_LOGIN).click();
    }



    private boolean element_isDisplayed(By element){
        try {
            return driver.findElement(element).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean headerProfile_isDisplayed(){
        return element_isDisplayed(HEADER_PROFILE);
    }

    public String textOfElement (By element) throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        //waits.waitWhileElementToBeClickable(element);
        return driver.findElement(element).getText();
    }
    public boolean buttonLogout_isDisplayed()
    {
        return element_isDisplayed(BUTTON_LOGOUT);
    }

    public boolean mainPage_isDisplayed(){
       return driver.getCurrentUrl().equals("https://stellarburgers.nomoreparties.site/");
    }

}
