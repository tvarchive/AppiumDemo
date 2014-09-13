package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LandingPage;

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
        File appDir = new File("/Users/nishant/Development/");
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
        WebDriverWait wait = new WebDriverWait(driver, 30);



        WebElement emailId = driver.findElement(By.id("com.flipkart.android:id/user_id"));
        wait.until(ExpectedConditions.visibilityOf(emailId));

        emailId.sendKeys("someone@testvagrant.com");
        driver.findElement(By.id("com.flipkart.android:id/user_password")).sendKeys("somePassword");

        driver.findElement(By.id("com.flipkart.android:id/checkbox_show_password")).click();
        driver.findElement(By.id("com.flipkart.android:id/btn_login")).click();
    }

    @Test
    public void testProductSearch(){

        new LandingPage(driver).chooseToBrowseItems()
                                .searchFor("iphone");
    }
}
