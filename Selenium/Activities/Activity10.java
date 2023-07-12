package Activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Activity10 {
    public static void main(String[] args)
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver newDriver = new FirefoxDriver();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        newDriver.get("https://training-support.net/selenium/dynamic-controls");
        WebElement checkboxEle = newDriver.findElement(By.xpath("//input[@class='willDisappear']"));
        System.out.println("Checkbox present? " + checkboxEle.isDisplayed());
        newDriver.findElement(By.id("toggleCheckbox")).click();
        System.out.println("Checkbox present? " +newDriver.findElement(By.xpath("//input[@class='willDisappear']")).isDisplayed());
        newDriver.quit();

    }
}
