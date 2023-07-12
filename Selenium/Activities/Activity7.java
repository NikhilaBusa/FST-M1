package Activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity7 {
    public static void main(String[] args)
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver newDriver = new FirefoxDriver();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        newDriver.get("https://training-support.net/selenium/drag-drop");
        System.out.println("Title is: "+newDriver.getTitle());
        WebElement ball = newDriver.findElement(By.xpath("//img[@id = 'draggable']"));
        WebElement dropZone1 = newDriver.findElement(By.id("droppable"));
        WebElement dropZone2 = newDriver.findElement(By.id("dropzone2"));

        Actions actions = new Actions(newDriver);
        actions.dragAndDrop(ball,dropZone1).pause(1000).build().perform();
        WebElement confMsg1Ele = newDriver.findElement(By.xpath("//div[@id='droppable']/p"));
        String confMsg1 = confMsg1Ele.getText();
        System.out.println((confMsg1.length()==0)? "Not dropped in zone 1" : confMsg1);
        actions.clickAndHold(ball).release(dropZone2).pause(1000).build().perform();
        System.out.println((newDriver.findElement(By.xpath("//div[@id='dropzone2']/p")).getText().length() == 0)?"Not dropped in zone 2":newDriver.findElement(By.xpath("//div[@id='dropzone2']/p")).getText());
        newDriver.quit();



    }
}
