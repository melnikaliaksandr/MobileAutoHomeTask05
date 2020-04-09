package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class CoreTestCase extends TestCase {

    protected AppiumDriver driver;
    private static String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Nokia 7 plus");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("unicodeKeyboard", true);
        capabilities.setCapability("app", "/Users/melnik/IdeaProjects/MobileAutoHomeTask05/apks/wiki.apk");
        driver = new AndroidDriver(new URL(APPIUM_URL), capabilities);
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
        driver.quit();
    }

}
