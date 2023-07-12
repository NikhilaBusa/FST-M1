package Activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
    public static void main(String[] args) throws InterruptedException
    {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriver newDriver = new FirefoxDriver();
        newDriver.get("https://training-support.net/selenium/target-practice");
        System.out.println("Title of page is: "+newDriver.getTitle());
        System.out.println("Third header's text is: "+newDriver.findElement(By.xpath("//div/h3")).getText().toString());
        System.out.println("Fifth header's color is: "+newDriver.findElement(By.xpath("//div/h5")).getCssValue("color"));
        System.out.println("Classes of violet button: "+newDriver.findElement(By.xpath("//button[text()='Violet']")).getAttribute("class"));
        System.out.println("Text of grey button: "+newDriver.findElement(By.xpath("//button[text()='Grey']")).getText());
        Thread.sleep(200);
        newDriver.quit();
    }
}
