import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.PageAccount;

import java.util.concurrent.TimeUnit;

import static pageObjects.AllLocators.BASE_URL;

public class RegisterTest {


    WebDriver driver;
    PageAccount pageAccount ;
  /*  private final String name;
    private final String surname;
    private final String address;
    private final String phone;
    private final String date;
    private final String buttonPlace;

    public RegisterTest(String name, String surname,String address, String phone, String date, String buttonPlace) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.date = date;
        this.buttonPlace = buttonPlace;
    }

*/
    @Before
    public void startDriver(){
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get(BASE_URL);
        pageAccount = new PageAccount(driver);
    }


   // @DisplayName("Успешная регистрация")




    @After
    public void  quit(){

    //    driver.quit();
    }

}
