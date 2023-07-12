package Activities;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class Activity6 {
    public static void main(String[] args)
    {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriver newDriver = new FirefoxDriver();
        newDriver.get("https://training-support.net/selenium/input-events");
        System.out.println("Title is: "+newDriver.getTitle());
        Actions action = new Actions(newDriver);
        action.sendKeys("N").pause(1000).build().perform();
        action.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).pause(1000).build().perform();
        newDriver.quit();
    }
}
