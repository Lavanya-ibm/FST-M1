package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity10_3 {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://training-support.net/selenium/drag-drop");
        System.out.println(driver.getTitle());
        wait.until(ExpectedConditions.elementToBeClickable(By.id("draggable")));
       WebElement ball= driver.findElement(By.id("draggable"));
        WebElement start= driver.findElement(By.id("droppable"));
        WebElement end= driver.findElement(By.id("dropzone2"));
        Actions a=new Actions(driver);
        a.dragAndDrop(ball,start).build().perform();
        wait.until(ExpectedConditions.attributeToBeNotEmpty(start, "background-color"));
        System.out.println("ENTERED DROPZONE 1");
        a.dragAndDrop(ball,end).build().perform();
        wait.until(ExpectedConditions.attributeToBeNotEmpty(end, "background-color"));
        System.out.println("ENTERED DROPZONE 2");
driver.close();
    }
}
