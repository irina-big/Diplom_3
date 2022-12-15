package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pageobjects.AllLocators.BUTTON_CONSTRUCTOR;
import static pageobjects.AllLocators.STELLAR_BURGERS_LOGO;

public class PageConstructor {
    WebDriver driver;
    Waits waits;
    PageConstructor (WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
    }
    public void buttonConstructor_click() {
        driver.findElement(BUTTON_CONSTRUCTOR).click();
    }

    public void stellarBurgersLogo_click() {
        waits.waitWhileElementToBeClickable(STELLAR_BURGERS_LOGO);
        driver.findElement(STELLAR_BURGERS_LOGO).click();

    }
}
