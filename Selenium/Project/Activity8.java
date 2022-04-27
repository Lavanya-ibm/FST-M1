package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity8 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("http://alchemy.hguy.co/orangehrm");
        System.out.println("Title of the page is:"+driver.getTitle());
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("menu_dashboard_index")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Apply Leave')]")).click();
        WebElement leavetype=driver.findElement(By.id("applyleave_txtLeaveType"));
Select s=new Select(leavetype);
s.selectByVisibleText("DayOff");
driver.findElement(By.id("applyleave_txtFromDate")).click();
        WebElement month=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        Select monthdrop=new Select(month);
        monthdrop.selectByVisibleText("May");
        WebElement year=driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        Select yeardrop=new Select(year);
        yeardrop.selectByVisibleText("2022");

        WebElement date=driver.findElement(By.xpath("//*[@class='ui-datepicker-calendar']/tbody/tr[4]/td[3]"));
        date.click();
        driver.findElement(By.id("applyleave_txtToDate")).click();
        WebElement tomonth=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        Select tomonthdrop=new Select(tomonth);
        tomonthdrop.selectByVisibleText("May");
        WebElement toyear=driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        Select toyeardrop=new Select(toyear);
        toyeardrop.selectByVisibleText("2022");

        WebElement todate=driver.findElement(By.xpath("//*[@class='ui-datepicker-calendar']/tbody/tr[4]/td[4]"));
        todate.click();

        driver.findElement(By.id("applyBtn")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
        String leavestatus=driver.findElement(By.xpath("//table/tbody/tr[1]/td[6]")).getText();
      System.out.println("leave status is:"+leavestatus);
        driver.close();
    }
}
