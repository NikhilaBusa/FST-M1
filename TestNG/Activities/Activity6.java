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

public class Activity6 {
    WebDriver newDriver;
    @BeforeClass(alwaysRun = true)
    public void beforeMethod() {
        WebDriverManager.firefoxdriver().setup();
        newDriver = new FirefoxDriver();
        newDriver.get("https://www.training-support.net/selenium/login-form");
    }

    @Test
    @Parameters({"username","password"})
    public void loginTest(String username,String password) {
        String title = newDriver.getTitle();
        System.out.println("Title is: " + title);
        newDriver.findElement(By.id("username")).sendKeys(username);
        newDriver.findElement(By.id("password")).sendKeys(password);
        newDriver.findElement(By.xpath("//button[text()='Log in']")).click();
    }

    @AfterClass(alwaysRun = true)
    public void afterMethod() {
        newDriver.close();
    }

}
