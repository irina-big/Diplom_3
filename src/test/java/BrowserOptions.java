import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserOptions {
    public final String PROPERTY = "src/test/resources/chromedriver.exe";
    public final String PATH_TO_YANDEX_BROWSER = "C:\\Users\\big_1\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe";
    public ChromeOptions chromeOptions;



    public WebDriver createDriverWithOptions(String browser) {
        if (browser.equals("Yandex")) {
            System.setProperty("webdriver.chrome.driver", PROPERTY);
            chromeOptions = new ChromeOptions();
            chromeOptions.setBinary(PATH_TO_YANDEX_BROWSER);
            return new ChromeDriver(chromeOptions);
        }
        return new ChromeDriver();
    }
}
