package scenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by sukeshkumar on 15/09/14.
 */
public class BaseScenario {
    protected WebDriver driver;

    protected void setUpAppium() throws MalformedURLException {
        File appDir = new File("/Users/nishant/Development/AppiumDemo/apps");
        File app = new File(appDir, "Flipkart.3.0.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");

        //mandatory capabilities
        capabilities.setCapability("deviceName","Android");
        capabilities.setCapability("platformName","Android");

        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
}
