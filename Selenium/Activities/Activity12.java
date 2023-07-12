package Activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Activity12 {
    public static void main(String[] args) throws InterruptedException
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver newDriver = new FirefoxDriver();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        newDriver.get("https://training-support.net/selenium/dynamic-controls");
        System.out.println("Title is: "+newDriver.getTitle());
        WebElement textEle = newDriver.findElement(By.id("input-text"));
        System.out.println("Input enabled? " + textEle.isEnabled());
        Thread.sleep(300);
        newDriver.findElement(By.id("toggleInput")).click();
        System.out.println("Input enabled? " + textEle.isEnabled());
        Thread.sleep(300);
        newDriver.quit();

    }
}
