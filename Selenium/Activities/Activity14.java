package Activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;


public class Activity14 {
    public static void main(String[] args) throws InterruptedException
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver newDriver = new FirefoxDriver();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        newDriver.get("https://training-support.net/selenium/tables");
        System.out.println("Title is: "+newDriver.getTitle());
        List<WebElement> rowsEle = newDriver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));
        List<WebElement> colsEle = newDriver.findElements(By.xpath("//table[@id='sortableTable']/thead/tr/th"));
        System.out.println("No. of rows are " + rowsEle.size() + "and columns are "+colsEle.size());
        System.out.println("Value at 2nd row, 2nd column:" + newDriver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]")).getText());
        newDriver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th")).click();
        System.out.println("Value at 2nd row, 2nd column after sorting:" + newDriver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]")).getText());
        List<WebElement> footEle = newDriver.findElements(By.xpath("//table[@id='sortableTable']/tfoot/tr/th"));
        System.out.println("Footer content:");
        for (WebElement cell : footEle)
            System.out.print(cell.getText() + " ");
        Thread.sleep(300);
        newDriver.quit();

    }
}
