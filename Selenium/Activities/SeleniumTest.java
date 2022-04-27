package Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://training-support.net");
       System.out.println(driver.getTitle());
       driver.findElement(By.id("about-link")).click();
        System.out.println(driver.getTitle());

        driver.close();
    }
}
