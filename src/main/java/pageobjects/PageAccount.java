package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pageobjects.AllLocators.BUTTON_LOGOUT;

public class PageAccount {
    WebDriver driver;
    Waits waits;
    public PageAccount(WebDriver driver){
        this.driver = driver;
        waits = new Waits(this.driver);
    }
    @Step("Получить текст элемента")
    public String textOfElement (By element) {
        waits.waitUntilElementToBeVisibility(element);
        return driver.findElement(element).getText();
    }
    @Step("Кликнуть по кнопке ВОЙТИ")
    public void buttonLogout_click() {
        waits.waitUntilElementToBeVisibility(BUTTON_LOGOUT);
        driver.findElement(BUTTON_LOGOUT).click();
    }
}
