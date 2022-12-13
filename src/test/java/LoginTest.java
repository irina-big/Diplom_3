import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.PageAccount;

import static pageobjects.AllLocators.BASE_URL;

public class LoginTest {

    WebDriver driver;
    PageAccount pageAccount ;
    @Before
    public void startDriver(){
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get(BASE_URL);
        pageAccount = new PageAccount(driver);
    }
    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    public void buttonLoginAccountTest(){


    }

    @Test
    @DisplayName("вход через кнопку «Личный кабинет»")
    public void loginByButtonAccountTest(){


    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginByButtonPasswordRecoveryTest(){

    }
    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginByButtonOnRegistrationFormTest() {
        //TimeUnit.SECONDS.sleep(10);
        pageAccount.buttonAccount_click();
        pageAccount.fieldEmail_fill("login71@yandex.ru");
        pageAccount.fieldPassword("password929");
        pageAccount.buttonLogin_click();
        // int expected = 10;
        // Assert.assertEquals(expected, 10);
    }

}
