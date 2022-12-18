import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pageobjects.PageConstructor;

import static pageobjects.AllLocators.BASE_URL;
@RunWith(Parameterized.class)
public class ConstructorTest {
    WebDriver driver;
    PageConstructor pageConstructor ;
    BrowserOptions browserOptions;
    String browser;
    public ConstructorTest(String browser){
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
    @After
    public void quit(){
        driver.quit();
    }
}
