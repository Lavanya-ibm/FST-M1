package Examples;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;

public class Example1 {
    AndroidDriver<MobileElement> driver;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("deviceId","d16e06b5");
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("appPackage","com.miui.calculator");
        caps.setCapability("appActivity",".Calculator");
        caps.setCapability("noReset",true);

        URL remoteUrl=new URL("http://localhost:4723/wd/hub");
        driver=new AndroidDriver<>(remoteUrl,caps);
    }
    @Test
    public void addtionTest()
    {
        MobileElement digit5= driver.findElementById("btn_5_s");
        digit5.click();
        MobileElement plus=driver.findElementById("btn_plus_s");
        plus.click();
        digit5.click();
        MobileElement equal=driver.findElementById("btn_equal_s");
        equal.click();
        String resulttext=driver.findElementById("result").getText();
        System.out.println(resulttext);
        assertEquals(resulttext,"10");
    }
    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
