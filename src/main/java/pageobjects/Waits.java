package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Waits {
    WebDriver driver;

    public Waits(WebDriver driver){
        this.driver = driver;
    }
    public void waitWhileElementToBeClickable (By element){
        // Ожидание, пока элемент станет кликабельным
        new WebDriverWait(driver, Duration.ofSeconds(10) )
                .until(ExpectedConditions.elementToBeClickable(element));
    }
    public void scrollToElement(By element){
        //скролл до элемента
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(element));
    }

    public void sleep(int seconds) throws InterruptedException {
        TimeUnit.SECONDS.sleep(seconds);
    }

    public void waitUntilElementToBeVisibility(By element) {
        // Ожидание, пока элемент станет видимым
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(element));
    }

}