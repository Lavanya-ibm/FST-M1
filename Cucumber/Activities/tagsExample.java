package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class tagsExample extends BaseClass{
    @Given("^User is on TS homepage$")
    public void openTSHomePage()
    {
        driver.get("https://training-support.net");
    }
    @When("^User clicks about us button$")
    public void clickAboutusbutton()
    {
        driver.findElement(By.id("about-link")).click();
    }
    @Then("^About Us page should open$")
    public void verifyaboutuspage()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='ui header']")));
        String pagetitle=driver.findElement(By.xpath("//h1[@class='ui header']")).getText();
        Assert.assertEquals("About Us",pagetitle);
    }
}
