import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.PageAccount;

import java.util.concurrent.TimeUnit;

import static pageObjects.AllLocators.BASE_URL;

public class ConstructorTest {
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
    public void stellarBurgersMainPageIsDisplayedTest() throws InterruptedException {
        TimeUnit.SECONDS.sleep(10);
        pageAccount.buttonAccount_click();
        //System.out.println(driver.getCurrentUrl());
        TimeUnit.SECONDS.sleep(10);
        pageAccount.stellarBurgersLogo_click();
        //System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(pageAccount.mainPage_isDisplayed());

    }
}
