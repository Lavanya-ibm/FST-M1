package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        driver.get("http://alchemy.hguy.co/orangehrm");
        System.out.println("Title of the page is:"+driver.getTitle());
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(20));
        Actions builder = new Actions(driver);
        WebElement Pim=driver.findElement(By.id("menu_pim_viewPimModule"));
        builder.moveToElement(Pim).perform();
        WebElement addemp=driver.findElement(By.id("menu_pim_addEmployee"));
        WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(20));
        builder.moveToElement(addemp).click().build().perform();
        // addemp.click();
        driver.findElement(By.id("firstName")).sendKeys("xyzz");
        driver.findElement(By.id("lastName")).sendKeys("abc");
        driver.findElement(By.id("btnSave")).click();
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("xyzz");
        driver.findElement(By.id("searchBtn")).click();
        driver.close();
    }
}
