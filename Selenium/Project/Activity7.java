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


public class Activity7{
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
        driver.findElement(By.xpath("//a[text() = 'All Courses']")).click();
        List<WebElement> coursesEle = driver.findElements(By.xpath("//div[@class='ld-course-list-items row']/div"));
        System.out.println("Number of courses: "+coursesEle.size());
    }

    @AfterTest
    public void cleanUp()
    {
        driver.quit();
    }


}
