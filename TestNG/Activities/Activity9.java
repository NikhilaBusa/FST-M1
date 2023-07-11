package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
public class Activity9 {
    WebDriver newDriver;
    @BeforeClass(alwaysRun = true)
    public void beforeMethod() {
        WebDriverManager.firefoxdriver().setup();
        newDriver = new FirefoxDriver();
        Reporter.log("Starting Test |");
        newDriver.get("https://www.training-support.net/selenium/javascript-alerts");
        Reporter.log("Opened web page |");
        Reporter.log("Title of page is: "+newDriver.getTitle() + " | ");
    }

    @BeforeMethod
    public void defaultTab()
    {
        Reporter.log("Switching to main window |");
        newDriver.switchTo().defaultContent();
    }

    @Test(priority = 0)
    public void simpleAlertTestCase() {
        Reporter.log("Simple alert |");
        newDriver.findElement(By.id("simple")).click();
        Alert simplealert = newDriver.switchTo().alert();
        Reporter.log("Focus shifted to simple alert |");
        System.out.println("Simple alert's text:"+simplealert.getText());
        Assert.assertEquals(simplealert.getText(),"This is a JavaScript Alert!");
        simplealert.accept();
        Reporter.log("Simple alert closed |");
    }

    @Test(priority = 1)
    public void confirmAlertTestCase() {
        newDriver.findElement(By.id("confirm")).click();
        Reporter.log("Confirm alert |");
        Alert confirmAlert = newDriver.switchTo().alert();
        Reporter.log("Focus shifted to confirm alert |");
        System.out.println("Simple alert's text:"+confirmAlert.getText());
        Assert.assertEquals(confirmAlert.getText(),"This is a JavaScript Confirmation!");
        confirmAlert.dismiss();
        Reporter.log("Confirm alert closed |");
    }

    @Test(priority = 2)
    public void promptAlertTestCase() {
        newDriver.findElement(By.id("prompt")).click();
        Reporter.log("Prompt alert |");
        Alert promptAlert = newDriver.switchTo().alert();
        Reporter.log("Focus shifted to prompt alert |");
        System.out.println("Simple alert's text:"+promptAlert.getText());
        Assert.assertEquals(promptAlert.getText(),"This is a JavaScript Prompt!");
        promptAlert.sendKeys("Something!");
        Reporter.log("Text entered in prompt alert |");
        promptAlert.accept();
        Reporter.log("Prompt alert closed |");
    }

    @AfterClass(alwaysRun = true)
    public void afterMethod() {
        newDriver.close();
    }
}
