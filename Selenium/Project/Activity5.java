package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity5 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("http://alchemy.hguy.co/orangehrm");
        System.out.println("Title of the page is:"+driver.getTitle());
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();

        driver.findElement(By.id("btnSave")).click();
        driver.findElement(By.id("personal_txtEmpFirstName")).clear();
        driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("lava");
        driver.findElement(By.id("personal_txtEmpLastName")).clear();
        driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("bojanapu");
        driver.findElement(By.id("personal_optGender_2")).click();
        WebElement nation=driver.findElement(By.id("personal_cmbNation"));
        Select drop=new Select(nation);
        drop.selectByVisibleText("Greek");
        WebElement datepicker=driver.findElement(By.xpath("//li//*[@id='personal_DOB']"));
        datepicker.click();
        WebElement month=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        Select monthdrop=new Select(month);
        monthdrop.selectByVisibleText("Sep");
        WebElement year=driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        Select yeardrop=new Select(year);
        yeardrop.selectByVisibleText("1990");

        WebElement date=driver.findElement(By.xpath("//*[@class='ui-datepicker-calendar']/tbody/tr[4]/td[3]"));
date.click();
driver.findElement(By.id("btnSave")).click();
driver.close();
    }
}
