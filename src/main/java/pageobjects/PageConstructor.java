package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static pageobjects.AllLocators.*;

public class PageConstructor {
    WebDriver driver;
    Waits waits;
    public PageConstructor (WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
    }
    @Step("Клик по кнопке КОНСТРУКТОР")
    public void buttonConstructor_click() {
        driver.findElement(BUTTON_CONSTRUCTOR).click();
    }

    @Step("Клик по логотипу Stellar Burgers")
    public void stellarBurgersLogo_click() {
        waits.waitWhileElementToBeClickable(STELLAR_BURGERS_LOGO);
        driver.findElement(STELLAR_BURGERS_LOGO).click();
    }

    @Step("Переход в раздел БУЛКИ")
    public void buns_click() throws InterruptedException {
        waits.sleep(5);
        waits.waitWhileElementToBeClickable(TAB_BUNS);
        driver.findElement(TAB_BUNS).click();
    }
    @Step("Переход в раздел СОУСЫ")
    public void sauses_click() throws InterruptedException {
        waits.sleep(5);
        waits.waitWhileElementToBeClickable(TAB_SAUSES);
        driver.findElement(TAB_SAUSES).click();
    }
    @Step("Переход в раздел НАЧИНКИ")
    public void fillings_click() throws InterruptedException {
        waits.sleep(5);
        waits.waitWhileElementToBeClickable(TAB_FILLINGS);
        driver.findElement(TAB_FILLINGS).click();
    }
    @Step("Получить текст выбранной вкладки")
    public String textOfSelectTab() throws InterruptedException {
        waits.sleep(5);
        waits.waitUntilElementToBeVisibility(TAB_SELECT);
        return driver.findElement(TAB_SELECT).getText();
    }
}
