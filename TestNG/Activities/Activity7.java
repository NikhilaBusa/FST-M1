package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class Activity7 {
    WebDriver newDriver;
    @BeforeClass(alwaysRun = true)
    public void beforeMethod() {
        WebDriverManager.firefoxdriver().setup();
        newDriver = new FirefoxDriver();
        newDriver.get("https://www.training-support.net/selenium/login-form");
    }
    @DataProvider(name = "Authentication")
    public Object[][] credentials()
    {
        return new Object[][]{
                {"username","password"},
                {"admin","password"}
        };
    }
    @Test(dataProvider="Authentication")
    public void loginTest(String username,String password) {
        String title = newDriver.getTitle();
        System.out.println("Title is: " + title);
        newDriver.findElement(By.id("username")).clear();
        newDriver.findElement(By.id("password")).clear();
        newDriver.findElement(By.id("username")).sendKeys(username);
        newDriver.findElement(By.id("password")).sendKeys(password);
        newDriver.findElement(By.xpath("//button[text()='Log in']")).click();
        Assert.assertEquals(newDriver.findElement(By.id("action-confirmation")).getText(),"Welcome Back, admin");
    }

    @AfterClass(alwaysRun = true)
    public void afterMethod() {
        newDriver.close();
    }

}
