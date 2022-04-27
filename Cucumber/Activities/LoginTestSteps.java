package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTestSteps {
    WebDriver driver;
    WebDriverWait wait;
    @Given("^User is on Login page$")
    public void login()
    {
        driver=new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
driver.get(" https://www.training-support.net/selenium/login-form");
    }
    @When("^User enters username and password$")
    public void enterdetails()
    {
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("password");
        driver.findElement(By.xpath("//*[@class='ui button']")).click();
    }
    @When("^User enters \"(.*)\" and \"(.*)\"$")
    public void user_enters_and(String username, String password) throws Throwable {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
@Then("^Read the page title and confirmation message$")
    public void title()
{
    String pagetitle=driver.getTitle();
    System.out.println("title of the page is:"+pagetitle);
    String message=driver.findElement(By.id("action-confirmation")).getText();
    System.out.println("confirmation message is:"+message);
    if(message.contains("admin")) {
        Assert.assertEquals(message, "Welcome Back, admin");
    } else {
        Assert.assertEquals(message, "Invalid Credentials");
    }
}
    @And("^Close the Browser$")
    public void closeBrowser() {
        //Close browser
        driver.close();
    }
}
