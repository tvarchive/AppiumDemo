package scenarios;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;

/**
 * Created by sukeshkumar on 15/09/14.
 */
public class IOSTest extends BaseScenario {

    @BeforeMethod
    public void setUp() throws Exception {

        // set up appium
        File app = new File("apps/UICatalog6.1.app.zip");
//        File app = new File("apps/Flipkart.zip");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformVersion", "7.1");
        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("deviceName", "iPhone Simulator");

//        capabilities.setCapability("platformName","iOS");
//        capabilities.setCapability("deviceName","iPhone Retina 4-inch");

        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());

        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    }

    @Test
    public void testSearchWorkflow(){
        System.out.println("device connected");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
