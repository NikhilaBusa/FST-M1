package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

import static org.testng.Assert.assertEquals;

public class Activity5 {
    WebDriver newDriver;
    @BeforeTest(alwaysRun = true)
    public void beforeMethod() {
        WebDriverManager.firefoxdriver().setup();
        newDriver = new FirefoxDriver();
        newDriver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test (groups = {"HeaderTests", "ButtonTests"})
    public void pageTitleTest() {
        String title = newDriver.getTitle();
        System.out.println("Title is: " + title);
        Assert.assertEquals(title, "Target Practice");
    }

    @Test (dependsOnMethods = {"pageTitleTest"}, groups = {"HeaderTests"})
    public void HeaderTest1() {
        WebElement header3 = newDriver.findElement(By.cssSelector("h3#third-header"));
        Assert.assertEquals(header3.getText(), "Third header");
    }

    @Test (dependsOnMethods = {"pageTitleTest"}, groups = {"HeaderTests"})
    public void HeaderTest2() {
        WebElement header5 = newDriver.findElement(By.cssSelector("h3#third-header"));
        Assert.assertEquals(header5.getCssValue("color"), "rgb(251, 189, 8)");
    }

    @Test (dependsOnMethods = {"pageTitleTest"}, groups = {"ButtonTests"})
    public void ButtonTest1() {
        WebElement button1 = newDriver.findElement(By.cssSelector("button.olive"));
        Assert.assertEquals(button1.getText(), "Olive");
    }

    @Test (dependsOnMethods = {"pageTitleTest"}, groups = {"ButtonTests"})
    public void ButtonTest2() {
        WebElement button2 = newDriver.findElement(By.cssSelector("button.brown"));
        Assert.assertEquals(button2.getCssValue("color"), "rgb(255, 255, 255)");
    }
    @AfterTest(alwaysRun = true)
    public void afterMethod() {
        newDriver.close();
    }

}
