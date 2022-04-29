package Activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity5 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "d16e06b5");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.mms");
        caps.setCapability("appActivity", ".ui.MmsTabActivity");
        caps.setCapability("noReset", true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(remoteUrl, caps);
        wait=new WebDriverWait(driver,10);
    }
    @Test
    public void messaging()
    {
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("description(\"Start new conversation\")")));
        driver.findElement(MobileBy.AndroidUIAutomator("description(\"Start new conversation\")")).click();
        String contactBoxLocator = "resourceId(\"com.android.mms:id/recipients_editor\")";
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(contactBoxLocator)));
        driver.findElement(MobileBy.AndroidUIAutomator(contactBoxLocator)).sendKeys("8317515553");
        ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("resourceId(\"com.android.mms:id/recipients_editor\")")));
        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.android.mms:id/embedded_text_editor\")")).sendKeys("Hello hi");
        driver.findElement(MobileBy.AndroidUIAutomator("resouceId(\"com.android.mms:id/send_button\")")).click();
        String messageLocator = "resourceId(\"com.android.mms:id/message_body\")";
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(messageLocator)));
        String sentMessageText = driver.findElement(MobileBy.AndroidUIAutomator(messageLocator)).getText();
        Assert.assertEquals(sentMessageText, "Hello hi");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}
