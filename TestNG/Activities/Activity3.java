package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.SkipException;
import org.testng.annotations.*;
import org.testng.Assert;

public class Activity3 {
    WebDriver newDriver;
    @BeforeTest
    public void initialSetup()
    {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        newDriver= new FirefoxDriver();
        newDriver.get("https://www.training-support.net/selenium/login-form");
    }
    @Test
    public void login()
    {
        newDriver.findElement(By.id("username")).sendKeys("admin");
        newDriver.findElement(By.id("password")).sendKeys("password");
        newDriver.findElement(By.xpath("//button[text()='Log in']")).click();
        Assert.assertEquals(newDriver.findElement(By.id("action-confirmation")).getText(), "Welcome Back, admin");
    }
    @AfterTest
    public void cleanUp()
    {
        newDriver.close();
    }
}

