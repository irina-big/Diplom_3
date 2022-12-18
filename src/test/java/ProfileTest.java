import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pageobjects.PageAccount;
import pageobjects.PageConstructor;
import pageobjects.PageLogin;
import pageobjects.PageMain;

import static pageobjects.AllLocators.*;
@RunWith(Parameterized.class)
public class ProfileTest {
    WebDriver driver;
    PageLogin pageLogin ;
    PageMain pageMain;
    PageAccount pageAccount;
    PageConstructor pageConstructor;
    BrowserOptions browserOptions;
    String browser;
    public ProfileTest(String browser){
        this.browser = browser;
    }
    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][] {
                {"Chrome"},
                {"Yandex"}
        };
    }
    @Before
    public void startDriver(){
        browserOptions = new BrowserOptions();
        driver = browserOptions.createDriverWithOptions(browser);
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
    public void moveToConstructorFromProfileTest() throws InterruptedException {
        driver.get(LOGIN_URL);
        pageLogin.fillAllFieldsAndSignIn("login71@yandex.ru","password929");
        pageMain.buttonAccount_click();
        pageConstructor.buttonConstructor_click();
        Assert.assertTrue(pageMain.mainPage_isDisplayed());
    }
    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип Stellar Burgers")
    public void moveToConstructorFromLogoStellarTest() throws InterruptedException {
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
