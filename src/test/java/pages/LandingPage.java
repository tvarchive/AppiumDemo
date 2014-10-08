package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        driver.findElement(By.name("Refrigerators")).click();
        waitForVisibilityOf(By.id(app_package_name +"product_list_query_text"));

        driver.findElement(By.name("Choose offers and other filters here")).click();

        //Perform tap
        WebElement sortBy=driver.findElement(By.id(app_package_name+ "sort_by_text"));
        performTapAction(sortBy);
        waitForVisibilityOf(By.id(app_package_name + "title"));
    }
}