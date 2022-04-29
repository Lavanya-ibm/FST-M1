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

import static org.testng.Assert.assertEquals;

public class Activity3 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "d16e06b5");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.miui.calculator");
        caps.setCapability("appActivity", ".cal.CalculatorActivity");
        caps.setCapability("noReset", true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(remoteUrl, caps);
        wait=new WebDriverWait(driver,10);
    }

    @Test
    public void addtionTest() {
      //  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("btn_5_s")));
        MobileElement digit5 = driver.findElementById("btn_5_s");
        digit5.click();
        MobileElement plus = driver.findElementById("btn_plus_s");
        plus.click();
        MobileElement digit9=driver.findElementById("btn_9_s");
        digit9.click();
        MobileElement equal = driver.findElementById("btn_equal_s");
        equal.click();
        String result = driver.findElementById("result").getText();
        System.out.println(result);
        Assert.assertEquals(result, "14");
    }
    @Test
    public void subtract() {
        driver.findElementById("btn_1_s").click();
        driver.findElementById("btn_0_s").click();
        driver.findElementById("btn_minus_s").click();
        driver.findElementById("btn_5_s").click();
        driver.findElementById("btn_equal_s").click();
        String result = driver.findElementById("result").getText();
        System.out.println(result);
        Assert.assertEquals(result, "5");
    }
    @Test
    public void multiply() {
        driver.findElementById("btn_5_s").click();
        driver.findElementById("btn_mul_s").click();
        driver.findElementById("btn_1_s").click();
        driver.findElementById("btn_0_s").click();
        driver.findElementById("btn_0_s").click();
        driver.findElementById("btn_equal_s").click();
        String result = driver.findElementById("result").getText();
        System.out.println(result);
        Assert.assertEquals(result, "500");
    }
    @Test
    public void divide() {
        driver.findElementById("btn_2_s").click();
        driver.findElementById("btn_0_s").click();
        driver.findElementById("btn_div_s").click();
        driver.findElementById("btn_5_s").click();
        driver.findElementById("btn_equal_s").click();
        String result = driver.findElementById("result").getText();
        System.out.println(result);
        Assert.assertEquals(result, "4");
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
