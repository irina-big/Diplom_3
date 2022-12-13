import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.PageAccount;

import static pageObjects.AllLocators.BASE_URL;

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
    //вход по кнопке "Войти в аккаунт" на главной
    @Test
    public void buttonLoginAccountTest(){


    }

    //вход через кнопку «Личный кабинет»
    @Test
    public void buttonAccountTest(){


    }
    //вход через кнопку в форме регистрации

    //вход через кнопку в форме восстановления пароля

    @Test
    public void successLoginTest() {
        //TimeUnit.SECONDS.sleep(10);
        pageAccount.buttonAccount_click();
        pageAccount.fieldEmail_fill("login71@yandex.ru");
        pageAccount.fieldPassword("password929");
        pageAccount.buttonLogin_click();
        // int expected = 10;
        // Assert.assertEquals(expected, 10);
    }

}
