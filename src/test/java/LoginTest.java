import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pageobjects.*;

import static pageobjects.AllLocators.*;
@RunWith(Parameterized.class)
public class LoginTest {
    WebDriver driver;
    PageLogin pageLogin ;
    PageMain pageMain;
    PageAccount pageAccount;
    PageForgotPassword pageForgotPassword;
    PageRegister pageRegister;
    BrowserOptions browserOptions;
    String browser;
    public LoginTest(String browser){
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
        pageForgotPassword = new PageForgotPassword(driver);
        pageRegister = new PageRegister(driver);
    }
    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void buttonLoginAccountTest() throws InterruptedException {
        pageMain.buttonLoginAccount_click();
        pageLogin.fillAllFieldsAndSignIn("login71@yandex.ru","password929");
        pageMain.buttonAccount_click();
        String expected = "Профиль";
        Assert.assertEquals(expected, pageAccount.textOfElement(HEADER_PROFILE));
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void loginByButtonAccountTest() throws InterruptedException {
        pageMain.buttonAccount_click();
        pageLogin.fillAllFieldsAndSignIn("login71@yandex.ru","password929");
        pageMain.buttonAccount_click();
        String expected = "Профиль";
        Assert.assertEquals(expected, pageAccount.textOfElement(HEADER_PROFILE));
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginByButtonPasswordRecoveryTest() throws InterruptedException {
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
    public void loginByButtonOnRegistrationFormTest() throws InterruptedException {
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
