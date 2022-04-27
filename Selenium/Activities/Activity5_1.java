package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_1 {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        driver.get(" https://training-support.net/selenium/dynamic-controls");
        System.out.println(driver.getTitle());
       Boolean message= driver.findElement(By.xpath("//input[@type='checkbox']")).isDisplayed();
       System.out.println(message);
       driver.findElement(By.id("toggleCheckbox")).click();
        System.out.println(message);
        driver.close();

    }
}
