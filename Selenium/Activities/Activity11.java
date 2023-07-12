package Activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Activity11 {
    public static void main(String[] args)
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver newDriver = new FirefoxDriver();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        newDriver.get("https://training-support.net/selenium/dynamic-controls");
        System.out.println("Title is: "+newDriver.getTitle());
        WebElement checkboxEle = newDriver.findElement(By.xpath("//input[@class='willDisappear']"));
        System.out.println("Checkbox checked? " + checkboxEle.isSelected());
        checkboxEle.click();
        System.out.println("Checkbox checked? " +checkboxEle.isSelected());
        newDriver.quit();

    }
}
