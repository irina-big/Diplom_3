package pageObjects;

import io.netty.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    WebDriver driver;

    public Waits(WebDriver driver){
        this.driver = driver;
    }
    public void waitWhileElementToBeClickable (By element){
        // Ожидание, что элемент станет кликабельным
        new WebDriverWait(driver, Duration.ofSeconds(10) )
                .until(ExpectedConditions.elementToBeClickable(element));
    }
    public void scrollToElement(By element){
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(element));
    }
}