import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.PageAccount;
import pageobjects.PageLogin;
import pageobjects.PageMain;

import java.util.concurrent.TimeUnit;

import static pageobjects.AllLocators.*;

public class LoginTest {
    WebDriver driver;
    PageLogin pageLogin ;
    PageMain pageMain;
    PageAccount pageAccount;
    @Before
    public void startDriver(){
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get(BASE_URL);
        pageLogin = new PageLogin(driver);
        pageMain = new PageMain(driver);
        pageAccount = new PageAccount(driver);
    }
    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void buttonLoginAccountTest() throws InterruptedException {
        pageMain.buttonLoginAccount_click();
        pageLogin.fieldEmail_fill("login71@yandex.ru");
        pageLogin.fieldPassword_fill("password929");
        pageLogin.buttonLogin_click();
        pageMain.buttonAccount_click();
        String expected = "Профиль";
        Assert.assertEquals(expected, pageAccount.textOfElement(HEADER_PROFILE));

    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void loginByButtonAccountTest() throws InterruptedException {
        pageMain.buttonAccount_click();
        pageLogin.fieldEmail_fill("login71@yandex.ru");
        pageLogin.fieldPassword_fill("password929");
        pageLogin.buttonLogin_click();
        pageMain.buttonAccount_click();
        String expected = "Профиль";
        Assert.assertEquals(expected, pageAccount.textOfElement(HEADER_PROFILE));

    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginByButtonPasswordRecoveryTest(){

    }
    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginByButtonOnRegistrationFormTest() throws InterruptedException {

    }
    @After
    public void quit(){
        driver.quit();
    }

}
