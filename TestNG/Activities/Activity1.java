package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import static org.testng.AssertJUnit.assertEquals;

public class Activity1 {
    WebDriver newDriver;
    @BeforeTest
    public void initialSetup()
    {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        newDriver= new FirefoxDriver();
        newDriver.get("https://www.training-support.net");
    }
    @Test
    public void openBrowser() throws InterruptedException
    {
        System.out.println("Title of page is: "+newDriver.getTitle());
        assertEquals(newDriver.getTitle(),"Training Support");
        newDriver.findElement(By.id("about-link")).click();
        assertEquals(newDriver.getTitle(),"About Training Support");
        Thread.sleep(400);
    }
    @AfterTest
    public void cleanUp()
    {
        newDriver.close();
    }
}

