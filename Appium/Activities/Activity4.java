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

public class Activity4 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "d16e06b5");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.contacts");
        caps.setCapability("appActivity", ".activities.TwelveKeyDialer");
        caps.setCapability("noReset", true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(remoteUrl, caps);
        wait=new WebDriverWait(driver,10);
    }
    @Test
    public void addcontact() {
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new contact")));
        driver.findElementByAccessibilityId("Create new contact").click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.EditText[@text='First name']")));
        driver.findElementByXPath("//android.widget.EditText[@text='First name']").sendKeys("Lavanya");
       driver.findElementByXPath("//android.widget.EditText[@text='Phone']").sendKeys("8179030082");
        driver.findElementById("button2").click();
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("toolbar_parent")));
        MobileElement mobileCard = driver.findElementById("toolbar_parent");
        Assert.assertTrue(mobileCard.isDisplayed());

        String contactName = driver.findElementById("title").getText();
        Assert.assertEquals(contactName, "Lavanya");

    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
