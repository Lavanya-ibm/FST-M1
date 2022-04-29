package Activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ChromeActivity1 {
    WebDriverWait wait;
    AndroidDriver<MobileElement> driver = null;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "d16e06b5");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 10);


    }
    @Test
    public void googlechrome()
    {
        driver.get("https://www.training-support.net/selenium");
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollTextIntoView(\"To-Do List\")")).click();
     //   wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("taskInput"))).click();
        driver.findElementById("taskInput").sendKeys("Add tasks to list");
        driver.findElementByXPath("android.view.View[1]/android.widget.Button").click();
        driver.findElementById("taskInput").sendKeys("Get number of tasks");
        driver.findElementByXPath("android.view.View[1]/android.widget.Button").click();
        driver.findElementById("taskInput").sendKeys("Clear the list");
        driver.findElementByXPath("android.view.View[1]/android.widget.Button").click();
        driver.findElementByXPath("android.view.View[2]/android.widget.TextView").click();
        driver.findElementByXPath("android.view.View[3]/android.widget.TextView").click();
        driver.findElementByXPath("android.view.View[4]/android.widget.TextView").click();
        driver.findElementByXPath("android.view.View[3]/android.widget.TextView[2]").click();

    }
    @AfterClass
    public void tearDown() {
       // driver.quit();
    }
}
