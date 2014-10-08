package scenarios;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;

public class AppiumTest extends BaseScenario {

    @BeforeMethod
    public void setUp() throws Exception {
        setUpAppium();
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


    // Commenting this test as the test fails due to the Appium SendKeys Bug
    @Test
    public void testAddToCart(){
        new LandingPage(driver).chooseToBrowseItems()
                .searchFor("iphone")
                .selectFirstResultFor("iphone")
                .addToCart("iphone")
                .verifyCartShowsTheCount();

    }


    @Test
    public void testSwipeOnHomePage()  {
        new LandingPage(driver).swipeFromLeftToPullMenu();

    }

    @Test
    public  void testScrollUponHomePageAndTapAction(){
        new LandingPage(driver).scrollPageUpAndClickOnRefrigerator();

    }
}

