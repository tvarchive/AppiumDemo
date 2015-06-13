package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage {

    By skip_button = By.id(app_package_name + "btn_skip");
    By annoucement_title = By.id(app_package_name + "announcement_title");

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public HomePage chooseToBrowseItems() {
        skipLogInScreen();
        return new HomePage(driver);
    }

    public void swipeFromLeftToPullMenu() {
        skipLogInScreen();
        waitForVisibilityOf(annoucement_title);

        //Perform the swipeLeftToRight function
        swipeLeftToRight();
        swipeRightToLeft();
    }

    private void skipLogInScreen() {
        waitForVisibilityOf(skip_button);
        driver.findElement(skip_button).click();
        driver.findElement(By.name("Home")).click();
        driver.findElement(By.name("Home")).click();
    }


    public void scrollPageUpAndClickOnRefrigerator() {
        skipLogInScreen();
        waitForVisibilityOf(annoucement_title);

        scrollPageUp();
        scrollPageUp();
        driver.findElement(By.name("Moto G(2nd Gen)")).click();

        System.out.println(driver.findElement(By.className("android.view.View")).getText());

//        waitForVisibilityOf(By.linkText("SHOP NOW Link"));
//
//        driver.findElement(By.linkText("SHOP NOW Link")).click();
//        driver.findElement(By.id(app_package_name + "filter_button")).click();
//        driver.findElement(By.id(app_package_name + "checkbox")).click();
//
//        //Perform tap
//        WebElement applyFilter=driver.findElement(By.id(app_package_name+ "apply_filters"));
//        performTapAction(applyFilter);
//
//        waitForVisibilityOf(By.id(app_package_name + "filter_image"));
    }
}