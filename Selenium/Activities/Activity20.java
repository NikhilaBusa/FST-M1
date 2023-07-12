package Activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Activity20 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriver newDriver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(newDriver, Duration.ofSeconds(10));
        newDriver.get("https://training-support.net/selenium/javascript-alerts");
        System.out.println("Title of page: " + newDriver.getTitle());
        newDriver.findElement(By.id("prompt")).click();
        Thread.sleep(300);
        Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());
        newDriver.switchTo().alert();
        System.out.println("Text is: " + alert1.getText());
        alert1.sendKeys("Awesome!");
        Thread.sleep(300);
        alert1.accept();
        Thread.sleep(300);
        newDriver.quit();
    }
}