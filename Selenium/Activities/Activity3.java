package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://training-support.net/selenium/simple-form");
        System.out.println(driver.getTitle());
        driver.findElement(By.id("firstName")).sendKeys ("Lavanya");
        driver.findElement(By.id("lastName")).sendKeys("Bojanapu");
        driver.findElement(By.id("email")).sendKeys("lavs@gmail.com");
        driver.findElement(By.id("number")).sendKeys("8765432190");
        WebElement scroll=driver.findElement(By.id("number"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", scroll);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='spaced two fields']/div[1]")).click();
         //driver.close();
    }
}
