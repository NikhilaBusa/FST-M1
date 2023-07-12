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

public class Activity9 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver newDriver = new FirefoxDriver();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverWait wait = new WebDriverWait(newDriver, Duration.ofSeconds(10));
        newDriver.get("https://training-support.net/selenium/ajax");
        System.out.println("Title is: "+newDriver.getTitle());
        WebElement buttonEle = newDriver.findElement(By.className("violet"));
        buttonEle.click();
        Thread.sleep(300);
        WebElement helloEle = newDriver.findElement(By.xpath("//div[@id='ajax-content']/h1"));
        wait.until(ExpectedConditions.textToBePresentInElement(helloEle,"HELLO!"));
        System.out.println(helloEle.getText());
        WebElement lateEle = newDriver.findElement(By.tagName("h3"));
        System.out.println(lateEle.getText());
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h3"), "I'm late!"));
        System.out.println(newDriver.findElement(By.tagName("h3")).getText());
        Thread.sleep(300);
        newDriver.quit();
    }
}


