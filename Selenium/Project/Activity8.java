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


public class Activity8{
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
        driver.findElement(By.linkText("Contact")).click();
        assertEquals(driver.getTitle(), "Contact – Alchemy LMS");
        driver.findElement(By.id("wpforms-8-field_0")).sendKeys("Full Name");
        driver.findElement(By.id("wpforms-8-field_1")).sendKeys("fullname.xyz@abc.com");
        driver.findElement(By.id("wpforms-8-field_2")).sendKeys("Good work!");
        driver.findElement(By.id("wpforms-8-field_3")).sendKeys("Appreciation subject");
        driver.findElement(By.id("wpforms-submit-8")).click();
        System.out.println("Confirmation message: " + driver.findElement(By.id("wpforms-confirmation-8")).getText());
    }

    @AfterTest
    public void cleanUp()
    {
        driver.quit();
    }


}
