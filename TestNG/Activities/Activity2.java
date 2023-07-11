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

public class Activity2 {
    WebDriver newDriver;
    @BeforeTest
    public void initialSetup()
    {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        newDriver= new FirefoxDriver();
        newDriver.get("https://www.training-support.net/selenium/target-practice");
    }
    @Test
    public void openBrowser()
    {
        String title = newDriver.getTitle();
        Assert.assertEquals(title,"Target Practice");
    }
    @Test
    public void wrongAssert()
    {
        WebElement blackEle = newDriver.findElement(By.className("black"));
        Assert.assertEquals(blackEle.getText(),"Green");
    }
    @Test(priority = 1, enabled = false)
    public void skipMethod()
    {
        System.out.println("Should be skipped");
    }
    @Test()
    public void skipByExc()
    {
        String condition = "skip";
        if(condition == "skip")
            throw new SkipException("Is skipped and shown");
    }
    @AfterTest
    public void cleanUp()
    {
        newDriver.close();
    }
}

