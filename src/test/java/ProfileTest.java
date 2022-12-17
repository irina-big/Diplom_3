import api.User;
import api.UserClient;
import api.UserGenerator;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.*;

import java.util.concurrent.TimeUnit;

import static pageobjects.AllLocators.*;

public class ProfileTest {
    WebDriver driver;
    PageLogin pageLogin ;
    PageMain pageMain;
    PageAccount pageAccount;
    PageConstructor pageConstructor;

    @Before
    public void startDriver(){
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get(BASE_URL);
        pageLogin = new PageLogin(driver);
        pageMain = new PageMain(driver);
        pageAccount = new PageAccount(driver);
        pageConstructor = new PageConstructor(driver);
    }

    @Test
    @DisplayName("Переход по клику на ЛИЧНЫЙ КАБИНЕТ")
    public void moveToAccountTest() throws InterruptedException {
        driver.get(LOGIN_URL);
        pageLogin.fillAllFieldsAndSignIn("login71@yandex.ru","password929");
        pageMain.buttonAccount_click();
        String expected = "Профиль";
        Assert.assertEquals(expected, pageAccount.textOfElement(HEADER_PROFILE));
    }
    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на КОНСТРУКТОР")
    public void moveToConstructorFromProfileTest(){
        driver.get(LOGIN_URL);
        pageLogin.fillAllFieldsAndSignIn("login71@yandex.ru","password929");
        pageMain.buttonAccount_click();
        pageConstructor.buttonConstructor_click();
        Assert.assertTrue(pageMain.mainPage_isDisplayed());

    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип Stellar Burgers")
    public void moveToConstructorFromLogoStellarTest(){
        driver.get(LOGIN_URL);
        pageLogin.fillAllFieldsAndSignIn("login71@yandex.ru","password929");
        pageMain.buttonAccount_click();
        pageConstructor.stellarBurgersLogo_click ();
        Assert.assertTrue(pageMain.mainPage_isDisplayed());
    }

    @Test
    @DisplayName("Выход из аккаунта по кнопке ВЫЙТИ в личном кабинете")
    public void logoutTest() throws InterruptedException {
        driver.get(LOGIN_URL);
        pageLogin.fillAllFieldsAndSignIn("login71@yandex.ru","password929");
        pageMain.buttonAccount_click();
        pageAccount.buttonLogout_click();
        Assert.assertTrue(pageLogin.headerLoginOnDisplay());
    }

    @After
    public void quit(){
        driver.quit();
    }

}
