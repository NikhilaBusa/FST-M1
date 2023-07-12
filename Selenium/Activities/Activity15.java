package Activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity15 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriver newDriver = new FirefoxDriver();
        newDriver.get("https://training-support.net/selenium/dynamic-attributes");
        System.out.println("Title is: " + newDriver.getTitle());
        WebElement usernameEle = newDriver.findElement(By.cssSelector("input[class^='username-']"));
        usernameEle.sendKeys("admin");
        WebElement pwdEle = newDriver.findElement(By.cssSelector("input[class^='password-']"));
        pwdEle.sendKeys("password");
        newDriver.findElement(By.xpath("//button[contains(.,'Log')]")).click();
        WebDriverWait wait = new WebDriverWait(newDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("action-confirmation")));
        System.out.println(newDriver.findElement(By.id("action-confirmation")).getText());
        Thread.sleep(200);
        newDriver.quit();
    }
}
