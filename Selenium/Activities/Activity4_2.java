package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/simple-form");
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("lavs");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("lucky");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("lavs@gmail.com");
        driver.findElement(By.xpath("//input[@id='number']")).sendKeys("8176543211");
        driver.findElement(By.xpath("//textarea")).sendKeys("happy message");
        driver.findElement(By.xpath("//input[contains(@class, 'green')]")).click();

    }
}
