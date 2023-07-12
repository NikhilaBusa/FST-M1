package Activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Activity2 {
    public static void main(String[] args) throws InterruptedException
    {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriver newDriver = new FirefoxDriver();
        newDriver.get("https://training-support.net/selenium/login-form");
        System.out.println("Title of page is: "+ newDriver.getTitle());
        newDriver.findElement(By.id("username")).sendKeys("admin");
        newDriver.findElement(By.id("password")).sendKeys("password");
        newDriver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(200);
        newDriver.quit();
    }
}
