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
    public String textOfElement (By element) throws InterruptedException {
        //waits.sleep(5);
        waits.waitUntilElementToBeVisibility(element);
        return driver.findElement(element).getText();
    }
    public void buttonLogout_click() {
        //waits.sleep(5);
        waits.waitUntilElementToBeVisibility(BUTTON_LOGOUT);
        driver.findElement(BUTTON_LOGOUT).click(); ;
    }



}
