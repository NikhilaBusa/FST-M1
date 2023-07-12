package Activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class Activity5 {
    public static void main(String[] args) throws InterruptedException
    {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriver newDriver = new FirefoxDriver();
        newDriver.get("https://www.training-support.net/selenium/input-events");
        System.out.println("Title: " + newDriver.getTitle());
        Actions action = new Actions(newDriver);
        action.click().pause(1000).build().perform();
        WebElement leftEle = newDriver.findElement(By.xpath("//div[contains(@class,'active')]"));
        System.out.println("Side value on left click is: "+ leftEle.getText());
        action.doubleClick().pause(1000).build().perform();
        System.out.println("Side value on double click is: "+ newDriver.findElement(By.className("active")).getText());
        action.contextClick().pause(1000).build().perform();
        System.out.println("Side value on right click is: "+ newDriver.findElement(By.className("active")).getText());
        newDriver.quit();
    }
}
