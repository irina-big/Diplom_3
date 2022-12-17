import api.User;
import api.UserClient;
import api.UserGenerator;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.PageRegister;

import java.util.Random;

import static org.apache.http.HttpStatus.SC_OK;
import static pageobjects.AllLocators.BASE_URL;

@RunWith(Parameterized.class)
public class RegisterTest {
    WebDriver driver;
    PageRegister pageRegister ;
    User user;
    public RegisterTest(User user) {
        this.user = user;
    }
    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][] {
                {UserGenerator.getUserWithRandomData()}
        };
    }
    @Before
    public void startDriver(){
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get(BASE_URL + "register");
        pageRegister = new PageRegister(driver);
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void successRegistrationTest() {
        pageRegister.fieldName_fill(user.getName());
        pageRegister.fieldEmail_fill(user.getEmail());
        pageRegister.fieldPassword_fill(user.getPassword());
        pageRegister.buttonRegistration_click();
        UserClient userClient = new UserClient();
        ValidatableResponse response = userClient.loginUser(user);
        int statusCodeExpected = response.extract().statusCode();
        if (statusCodeExpected == SC_OK){
            String token = response.extract().path("accessToken");
            userClient.deleteUser(token);
        }
        Assert.assertTrue(pageRegister.headerLogin_isDisplayed() && (statusCodeExpected == SC_OK));
    }
    @Test
    @DisplayName("Ошибка: некорректный пароль!")
    public void incorrectPasswordTest() {
        Random random = new Random();
        user.setPassword("x" + random.nextInt(1000));
        pageRegister.fieldName_fill(user.getName());
        pageRegister.fieldEmail_fill(user.getEmail());
        pageRegister.fieldPassword_fill(user.getPassword());
        pageRegister.buttonRegistration_click();
        Assert.assertTrue(pageRegister.incorrectPassword_isDisplayed());
    }
@After
    public void  quit(){
        driver.quit();
    }
}
