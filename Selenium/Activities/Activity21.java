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

public class Activity21 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriver newDriver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(newDriver, Duration.ofSeconds(10));
        newDriver.get("https://www.training-support.net/selenium/tab-opener");
        System.out.println("Title of page: " + newDriver.getTitle());
        System.out.println("Current window: "+newDriver.getWindowHandle());
        newDriver.findElement(By.id("launcher")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        System.out.println("Current open windows: " + newDriver.getWindowHandles());
        for(String handle : newDriver.getWindowHandles()) {
            newDriver.switchTo().window(handle);
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.id("actionButton")));
        System.out.println("Page title: " + newDriver.getTitle());
        String pageHeading = newDriver.findElement(By.className("content")).getText();
        System.out.println("Page Heading: " + pageHeading);
        newDriver.findElement(By.id("actionButton")).click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
        for(String handle : newDriver.getWindowHandles()) {
            newDriver.switchTo().window(handle);
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("content")));
        System.out.println("Current tab: " + newDriver.getWindowHandle());
        System.out.println("Page title: " + newDriver.getTitle());
        pageHeading = newDriver.findElement(By.className("content")).getText();
        System.out.println("Page Heading: " + pageHeading);
        newDriver.quit();

    }
}