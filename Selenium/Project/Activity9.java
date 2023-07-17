package Activities;

import org.openqa.selenium.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class Activity9 {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeTest
    public void setUp()
    {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://alchemy.hguy.co/lms");
        //driver.manage().window().setSize(new Dimension(1173,2566));
    }

    @Test
    public void lessonTest() throws InterruptedException
    {
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.xpath("//a[contains(@class, 'ld-login-button')]")).click();
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();
        driver.findElement(By.xpath("//a[contains(text(),'All Courses')]")).click();
        WebElement courseEle = driver.findElement(By.xpath("//a[@href=\"https://alchemy.hguy.co/lms/courses/social-media-marketing/\"]"));
        JavascriptExecutor jse =(JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", courseEle);
        jse.executeScript("arguments[0].click();",courseEle);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,\"ld-item-list-item-preview\")]/a/div[contains(@class, \"ld-status-icon\") and not(contains(@class,\"ld-status-complete\"))]")));
        driver.findElement(By.xpath("//div[contains(@class,\"ld-item-list-item-preview\")]/a/div[contains(@class, \"ld-status-icon\") and not(contains(@class,\"ld-status-complete\"))]")).click();
        System.out.println(driver.getTitle());
        assertEquals(driver.getTitle(), "Investment & Marketing  Final Strategies - Alchemy LMS");
        driver.findElement(By.xpath("//form/input[@value=\"Mark Complete\"]")).click();
    }

    @AfterTest
    public void cleanUp()
    {
        driver.quit();
    }
}
