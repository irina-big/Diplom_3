import io.qameta.allure.junit4.DisplayName;
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
        pageConstructor = new PageConstructor(driver);
    }

    @Test
    @DisplayName("Переход в раздел БУЛКИ")
    public void selectBunsTest() throws InterruptedException {
        pageConstructor.fillings_click();
        pageConstructor.buns_click();
        Assert.assertEquals("Булки", pageConstructor.textOfSelectTab());
    }
    @Test
    @DisplayName("Переход в раздел СОУСЫ")
    public void selectSausesTest() throws InterruptedException {
        pageConstructor.fillings_click();
        pageConstructor.sauses_click();
        Assert.assertEquals("Соусы", pageConstructor.textOfSelectTab());
    }
    @Test
    @DisplayName("Переход в раздел НАЧИНКИ")
    public void selectFillingsTest() throws InterruptedException {
        pageConstructor.sauses_click();
        pageConstructor.fillings_click();
        Assert.assertEquals("Начинки", pageConstructor.textOfSelectTab());
    }
}
