package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class Activity6{
    WebDriver driver;
    WebDriverWait wait;
    @BeforeTest
    public void setUp()
    {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void testOpen()
    {
        driver.findElement(By.linkText("My Account")).click();
        assertEquals(driver.getTitle(), "My Account – Alchemy LMS");
        driver.findElement(By.xpath("//a[contains(@class, 'ld-login-button')]")).click();
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();
        WebElement adminEle = driver.findElement(By.xpath("//a[text() = 'Howdy, ']"));
        assertEquals(adminEle.getText(), "Howdy, root");
        Actions action = new Actions(driver);
        WebElement hoverEle = driver.findElement(By.xpath("//a[@class='ab-item' and text()='Howdy, ']"));
        action.moveToElement(hoverEle).pause(100).build().perform();
        driver.findElement(By.xpath("//a[text()='Log Out']")).click();
    }

    @AfterTest
    public void cleanUp()
    {
        driver.quit();
    }


}
