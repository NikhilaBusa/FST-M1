package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_lol.AN;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertSteps {
    WebDriver driver;
    WebDriverWait wait;
    Alert alert;

    @Given("^User is on the page$")
    public void userOnPage()
    {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
    }

    @When("^User clicks the Simple Alert button$")
    public void clickSimpleAlert()
    {
        driver.findElement(By.id("simple")).click();
    }

    @When("^User clicks the Confirm Alert button$")
    public void clickConfirmAlert()
    {
        driver.findElement(By.id("confirm")).click();
    }

    @When("^User clicks the Prompt Alert button$")
    public void clickPromptAlert()
    {
        driver.findElement(By.id("prompt")).click();
    }

    @Then("^Alert opens$")
    public void alertOpens()
    {
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
    }

    @And("^Read the text from it and print it$")
    public void readTextAndPrint()
    {
        System.out.println("Alert text: " + alert.getText());
    }

    @And("^Close the alert$")
    public void closeAlert()
    {
        alert.accept();
    }

    @And("^Close the alert with Cancel$")
    public void closeWithCancel()
    {
        alert.dismiss();
    }

    /*@And("^Read the result text$")
    public void resultText()
    {
        WebElement pEle = driver.findElement(By.xpath("//p[@id='result']"));
        System.out.println("Para result: " + pEle.getText());
    }*/

    @And("^Write a custom message in it$")
    public void customMessage()
    {
        alert.sendKeys("Something!");
    }

    @And("^Close Browser$")
    public void closeBrowser()
    {
        driver.quit();
    }
}
