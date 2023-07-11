package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
public class Activity10 {
    WebDriver newDriver;
    @BeforeClass(alwaysRun = true)
    public void setUp()
    {
        newDriver = new FirefoxDriver();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        newDriver.get("https://www.training-support.net/selenium/simple-form");
    }

    public static List<List<String>> fileReading(String filepath) throws IOException
    {
        List<List<String>> data = new ArrayList<List<String>>();
        try {
            FileInputStream file = new FileInputStream(filepath);
            XSSFWorkbook act10 = new XSSFWorkbook(file);
            XSSFSheet sheet = act10.getSheetAt(0);
            for (Row cells : sheet) {
                List<String> rowData = new ArrayList<String>();
                for (Cell item : cells) {
                    if (item != null && item.getCellType().equals(CellType.NUMERIC))
                        rowData.add(String.valueOf((long)(item.getNumericCellValue())));
                    else if(item!=null && item.getCellType().equals(CellType.STRING))
                        rowData.add(item.getStringCellValue());
                }
                data.add(rowData);
            }
            file.close();
            act10.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return data;
    }

    @DataProvider(name="formData")
    public static Object[][] signUpCred() throws IOException
    {
        String filePath = "src/test/resources/Activity10.xlsx";
        List<List<String>> formData = fileReading(filePath);
        return new Object[][]{
                {formData.get(1).get(1),formData.get(1).get(2),formData.get(1).get(3),formData.get(1).get(4)},
                {formData.get(2).get(1),formData.get(2).get(2),formData.get(2).get(3),formData.get(2).get(4)},
                {formData.get(3).get(1),formData.get(3).get(2),formData.get(3).get(3),formData.get(3).get(4)},
                };
    }


    @Test(dataProvider = "formData")
    public void registerTest(String fname, String lname, String email, String mobile) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(newDriver, Duration.ofSeconds(10));
        Thread.sleep(300);
        WebElement firstName = newDriver.findElement(By.xpath("//input[@id='firstName']"));
        WebElement lastName = newDriver.findElement(By.xpath("//input[@id='lastName']"));
        WebElement emailField = newDriver.findElement(By.xpath("//input[@id='email']"));
        WebElement mobileField = newDriver.findElement(By.xpath("//input[@id='number']"));
        WebElement submitButton = newDriver.findElement(By.xpath("//button[@type='submit']"));

        firstName.clear();
        lastName.clear();
        emailField.clear();
        mobileField.clear();

        firstName.sendKeys(fname);
        lastName.sendKeys(lname);
        emailField.sendKeys(email);
        mobileField.sendKeys(mobile);
        newDriver.findElement(By.xpath("//input[contains(@class, 'green')]")).click();

        Alert alert = newDriver.switchTo().alert();
        System.out.println("Text in alert: "+alert.getText());
        alert.accept();
    }

    @AfterClass
    public void close()
    {
        newDriver.quit();
    }

}