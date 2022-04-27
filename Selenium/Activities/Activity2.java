package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://www.training-support.net");
        System.out.println(driver.getTitle());
        WebElement usingid=driver.findElement(By.id("about-link"));
        System.out.println(usingid.getText());
        WebElement usingclassname=driver.findElement(By.className("green"));
        System.out.println(usingclassname.getText());
        WebElement usingcss=driver.findElement(By.cssSelector(".green"));
        System.out.println(usingcss.getText());
        WebElement usinglinktext=driver.findElement(By.linkText("About Us"));
        System.out.println(usinglinktext.getText());
driver.close();
    }
}
