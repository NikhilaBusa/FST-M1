package Activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Activity8 {
    public static void main(String[] args) throws InterruptedException
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver newDriver = new FirefoxDriver();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverWait wait = new WebDriverWait(newDriver, Duration.ofSeconds(10));
        newDriver.get("https://training-support.net/selenium/dynamic-controls");
        System.out.println("Title is:"+newDriver.getTitle());
        newDriver.findElement(By.id("toggleCheckbox")).click();
        Thread.sleep(2000);
        WebElement checkboxEle = newDriver.findElement(By.xpath("//input[@class='willDisappear']"));
        wait.until(ExpectedConditions.invisibilityOf(checkboxEle));
        System.out.println(checkboxEle.isDisplayed());
        newDriver.findElement(By.id("toggleCheckbox")).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(checkboxEle));
        System.out.println(checkboxEle.isDisplayed());
        checkboxEle.click();
        Thread.sleep(2000);
        newDriver.quit();
    }
}
