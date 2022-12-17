import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.*;

import static pageobjects.AllLocators.*;

public class LoginTest {
    WebDriver driver;
    PageLogin pageLogin ;
    PageMain pageMain;
    PageAccount pageAccount;
    PageForgotPassword pageForgotPassword;
    PageRegister pageRegister;
    @Before
    public void startDriver(){
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get(BASE_URL);
        pageLogin = new PageLogin(driver);
        pageMain = new PageMain(driver);
        pageAccount = new PageAccount(driver);
        pageForgotPassword = new PageForgotPassword(driver);
        pageRegister = new PageRegister(driver);
    }
    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void buttonLoginAccountTest() {
        pageMain.buttonLoginAccount_click();
        pageLogin.fillAllFieldsAndSignIn("login71@yandex.ru","password929");
        pageMain.buttonAccount_click();
        String expected = "Профиль";
        Assert.assertEquals(expected, pageAccount.textOfElement(HEADER_PROFILE));
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void loginByButtonAccountTest() {
        pageMain.buttonAccount_click();
        pageLogin.fillAllFieldsAndSignIn("login71@yandex.ru","password929");
        pageMain.buttonAccount_click();
        String expected = "Профиль";
        Assert.assertEquals(expected, pageAccount.textOfElement(HEADER_PROFILE));
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginByButtonPasswordRecoveryTest() {
        driver.get(LOGIN_URL);
        pageLogin.passwordRecovery_click();
        pageForgotPassword.linkLogin_click();
        pageLogin.fillAllFieldsAndSignIn("login71@yandex.ru","password929");
        pageMain.buttonAccount_click();
        String expected = "Профиль";
        Assert.assertEquals(expected, pageAccount.textOfElement(HEADER_PROFILE));
    }
    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginByButtonOnRegistrationFormTest() {
        driver.get(REGISTER_URL);
        pageRegister.linkLogin_click();
        pageLogin.fillAllFieldsAndSignIn("login71@yandex.ru","password929");
        pageMain.buttonAccount_click();
        String expected = "Профиль";
        Assert.assertEquals(expected, pageAccount.textOfElement(HEADER_PROFILE));
    }
    @After
    public void quit(){
        driver.quit();
    }

}
