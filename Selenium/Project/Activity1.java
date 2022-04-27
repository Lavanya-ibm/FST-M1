package Activities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity1 {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        System.out.println("Title of the page is:"+driver.getTitle());
        String title=driver.getTitle();
        if(title.equals("OrangeHRM"))
        {
            driver.close();
        }
    }
}
