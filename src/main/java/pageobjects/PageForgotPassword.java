package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static pageobjects.AllLocators.*;

public class PageForgotPassword {
    public WebDriver driver;
    public Waits waits;

    public PageForgotPassword(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    @Step("Клик по ссылке ВОЙТИ на странице ВОССТАНОВИТЬ ПАРОЛЬ")
    public void linkLogin_click() {
        waits.scrollToElement(LINK_LOGIN);
        waits.waitWhileElementToBeClickable(LINK_LOGIN);
        driver.findElement(LINK_LOGIN).click();
    }
}
