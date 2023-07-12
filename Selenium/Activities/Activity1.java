package Activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Activity1 {
    public static void main(String[] args) throws InterruptedException
    {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriver newDriver = new FirefoxDriver();
        newDriver.get("https://www.training-support.net/");
        System.out.println("Title of page is: "+newDriver.getTitle());
        newDriver.findElement(By.id("about-link")).click();
        System.out.println("Title of page is: "+newDriver.getTitle());
        Thread.sleep(200);
        newDriver.quit();
    }
}
