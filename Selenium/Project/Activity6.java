package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity6 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("http://alchemy.hguy.co/orangehrm");
        System.out.println("Title of the page is:"+driver.getTitle());
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        Thread.sleep(2000);
        Boolean directoryvisible=driver.findElement(By.id("menu_directory_viewDirectory")).isDisplayed();
System.out.println("Directory item is displayed or not:"+directoryvisible);
        Boolean directoryenable=driver.findElement(By.id("menu_directory_viewDirectory")).isEnabled();
        System.out.println("Directory item is enabled or not:"+directoryenable);
        if(directoryenable.equals(directoryvisible))
        {
            System.out.println("element is clickable");
            driver.findElement(By.id("menu_directory_viewDirectory")).click();
            Thread.sleep(2000);
           // driver.findElement(By.id("//*[@class='toggle tiptip']")).click();
          // String verifyheading=driver.findElement(By.id("//*[@class='toggle tiptip']")).getText();
          // System.out.println("heading of the page matches or not"+verifyheading.equalsIgnoreCase("Search Directory"));
       Boolean check=driver.getPageSource().contains("Search Directory");
       System.out.println("Heading of the page matches or not:"+check);
       driver.close();
        }
        else
        {
            System.out.println("element not clickable");
        }
    }
}
