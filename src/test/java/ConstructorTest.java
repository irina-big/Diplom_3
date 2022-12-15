import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.PageAccount;
import pageobjects.PageConstructor;

import java.util.concurrent.TimeUnit;

import static pageobjects.AllLocators.BASE_URL;

public class ConstructorTest {
    WebDriver driver;
    PageConstructor pageConstructor ;
    @Before
    public void startDriver(){
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get(BASE_URL);
       // pageConstructor = new PageConstructor(driver);
    }

    @Test
    public void stellarBurgersMainPageIsDisplayedTest() throws InterruptedException {
        TimeUnit.SECONDS.sleep(10);
      //  pageConstructor.buttonAccount_click();
        //System.out.println(driver.getCurrentUrl());
        TimeUnit.SECONDS.sleep(10);
        pageConstructor.stellarBurgersLogo_click();
        //System.out.println(driver.getCurrentUrl());
     //   Assert.assertTrue(pageConstructor.mainPage_isDisplayed());

    }
}
