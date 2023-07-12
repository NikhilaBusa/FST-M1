package Activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Activity22 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriver newDriver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(newDriver, Duration.ofSeconds(10));
        newDriver.get("https://www.training-support.net/selenium/popups");
        System.out.println("Title of page: " + newDriver.getTitle());
        WebElement toolEle = newDriver.findElement(By.className("orange"));
        Actions action = new Actions(newDriver);
        action.moveToElement(toolEle).pause(1000).build().perform();
        System.out.println("Message is: "+ toolEle.getAttribute("data-tooltip"));
        toolEle.click();
        newDriver.findElement(By.id("username")).sendKeys("admin");
        newDriver.findElement(By.id("password")).sendKeys("password");
        WebElement greenEle = newDriver.findElement(By.xpath("//button[text()='Log in']"));
        greenEle.click();
        System.out.println("Login message is: "+newDriver.findElement(By.id("action-confirmation")).getText());
        Thread.sleep(300);
        newDriver.quit();
    }
}