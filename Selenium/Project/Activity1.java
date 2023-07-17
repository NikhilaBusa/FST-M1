package Activities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class Activity1{
    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp()
    {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void testOpen()
    {
        String title= driver.getTitle();
        System.out.println(title);
        assertEquals(title, "Alchemy LMS – An LMS Application");
    }

    @AfterClass
    public void cleanUp()
    {
        driver.quit();
    }

}
