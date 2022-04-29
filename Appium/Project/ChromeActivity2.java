package Activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeActivity2 {
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
    public void loginform1()
    {
        driver.get("https://www.training-support.net/selenium");
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollTextIntoView(\"Login Form\")")).click();
        //   wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("taskInput"))).click();
        driver.findElementById("username").sendKeys("admin");
        driver.findElementById("password").sendKeys("password");
        driver.findElementByXPath("android.view.View/android.widget.Button").click();
        String message=driver.findElementById("action-confirmation").getText();
        Assert.assertEquals(message,"Welcome Back,admin");

    }
    @Test
    public void loginform2()
    {
        driver.get("https://www.training-support.net/selenium");
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollTextIntoView(\"Login Form\")")).click();
        //   wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("taskInput"))).click();
        driver.findElementById("username").sendKeys("admin1");
        driver.findElementById("password").sendKeys("password1");
        driver.findElementByXPath("android.view.View/android.widget.Button").click();
        String message=driver.findElementById("action-confirmation").getText();
        Assert.assertEquals(message,"Invalid Credentials");
    }
    @AfterClass
    public void tearDown() {
        // driver.quit();
    }
}
