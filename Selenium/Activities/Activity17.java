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

public class Activity17 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriver newDriver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(newDriver, Duration.ofSeconds(10));
        newDriver.get("https://training-support.net/selenium/selects");
        System.out.println("Title of page: "+ newDriver.getTitle());
        Select singleSelect = new Select(newDriver.findElement(By.id("single-select")));
        singleSelect.selectByVisibleText("Option 2");
        System.out.println("Selected option is: "+singleSelect.getFirstSelectedOption().getText());
        singleSelect.selectByIndex(3);
        System.out.println("Selected option is: "+singleSelect.getFirstSelectedOption().getText());
        singleSelect.selectByValue("4");
        System.out.println("Selected option is: "+singleSelect.getFirstSelectedOption().getText());
        List<WebElement> options = singleSelect.getOptions();
        System.out.println("All options are: ");
        for (WebElement item : options)
            System.out.println(item.getText() + " ");
        Thread.sleep(300);
        newDriver.quit();
    }
}