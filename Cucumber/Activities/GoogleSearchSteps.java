package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchSteps {
    WebDriver driver;
    WebDriverWait wait;
    @Given("^User is on Google Home Page$")
    public void user_is_on_google_home_page() throws Throwable
    {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        driver.get("https://www.google.com");
    }

    @When("^User types in Cheese and hits ENTER$")
    public void user_types_in_cheese_and_hits_enter() throws Throwable
    {
        WebElement queryEle = driver.findElement(By.name("q"));
        queryEle.sendKeys("Cheese", Keys.ENTER);
    }

    @Then("^Show how many search results were shown$")
    public void show_how_many_search_results_were_shown() throws Throwable
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("result-stats"))));
        System.out.println("Results: "+driver.findElement(By.id("result-stats")).getText());
    }

    @And("^Close the browser$")
    public void closeTheBrowser() throws Throwable
    {
        driver.quit();
    }
}
