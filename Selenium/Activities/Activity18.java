package Activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Activity18 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriver newDriver = new FirefoxDriver();
        newDriver.get("https://training-support.net/selenium/selects");
        System.out.println("Title of page: " + newDriver.getTitle());
        WebElement dropdown = newDriver.findElement(By.id("multi-select"));
        Select multiSelect = new Select(dropdown);
        multiSelect.selectByVisibleText("Javascript");
        multiSelect.selectByIndex(3);
        multiSelect.selectByIndex(4);
        multiSelect.selectByIndex(5);
        multiSelect.selectByValue("node");
        multiSelect.deselectByIndex(4);
        List<WebElement> allOptions = multiSelect.getAllSelectedOptions();
        for(WebElement item : allOptions)
            System.out.println(item.getText() + " ");
        Thread.sleep(300);
        newDriver.quit();
    }
}