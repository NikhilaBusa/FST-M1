package Activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;


public class Activity13 {
    public static void main(String[] args) throws InterruptedException
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver newDriver = new FirefoxDriver();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        newDriver.get("https://training-support.net/selenium/tables");
        System.out.println("Title is: "+newDriver.getTitle());
        List<WebElement> trEle = newDriver.findElements(By.xpath("//table[contains(@class,'striped')]/tbody/tr"));
        System.out.println("No. of rows is: " + trEle.size());
        List<WebElement> thirdEle = newDriver.findElements(By.xpath("//table[contains(@class,'striped')]/tbody/tr[3]/td"));
        System.out.println("Third row:");
        for(WebElement item : thirdEle)
            System.out.print(item.getText() + " ");
        System.out.println("\nContent in second row, second cell:"+newDriver.findElement(By.xpath("//table[contains(@class,'striped')]/tbody/tr[2]/td[2]")).getText());

        Thread.sleep(300);
        newDriver.quit();

    }
}
