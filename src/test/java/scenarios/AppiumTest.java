package scenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;

import java.io.File;
import java.net.URL;

/**
 * Created by nishant on 12/09/14.
 */
public class AppiumTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {

        // set up appium
        File appDir = new File("/Users/nishant/Development/SampleApps");
        File app = new File(appDir, "Flipkart.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");

        //mandatory capabilities
        capabilities.setCapability("deviceName","Android");
        capabilities.setCapability("platformName","Android");

        //other caps
        capabilities.setCapability(CapabilityType.BROWSER_NAME,  "");
        capabilities.setCapability(CapabilityType.VERSION, "4.4.2");
        capabilities.setCapability(CapabilityType.PLATFORM, "Android");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("app-activity",".LoginActivity");
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void falseLoginTest() throws InterruptedException
    {
        new LoginPage(driver).invalidLogin();
    }

    @Test
    public void testProductSearch(){

        new LandingPage(driver).chooseToBrowseItems()
                                .searchFor("iphone");
    }
}
