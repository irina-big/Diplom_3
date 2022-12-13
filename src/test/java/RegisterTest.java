import api.User;
import api.UserClient;
import api.UserGenerator;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.PageAccount;
import pageobjects.PageRegister;

import java.util.concurrent.TimeUnit;

import static org.apache.http.HttpStatus.SC_OK;
import static pageobjects.AllLocators.BASE_URL;
@RunWith(Parameterized.class)
public class RegisterTest {


    WebDriver driver;
    PageRegister pageRegister ;
    UserClient userClient;
    User user;


    public RegisterTest(User user) {
        this.user = user;
    }


    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][] {
                {UserGenerator.getUserWithRandomData()}
               // {UserGenerator.getUserFromParams("", "", "")}

        };
    }
    @Before
    public void startDriver(){
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get(BASE_URL + "register");
        pageRegister = new PageRegister(driver);
        System.out.println(user.getName() + " " + user.getEmail() + " " + user.getPassword());
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void successRegistrationTest() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        pageRegister.fieldName_fill(user.getName());
        pageRegister.fieldEmail_fill(user.getEmail());
        pageRegister.fieldPassword_fill(user.getPassword());
        pageRegister.buttonRegistration_click();

    }



    @After
    public void  quit(){
        userClient = new UserClient();
        ValidatableResponse response = userClient.loginUser(user);
        if (response.extract().statusCode() == SC_OK){
            String token = response.extract().path("accessToken");
            userClient.deleteUser(token);
        }
    //    driver.quit();
    }

}
