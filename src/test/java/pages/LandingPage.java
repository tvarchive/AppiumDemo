package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage {

    By flipkart_logo_locator = By.id(app_package_name + "flipkart_logo");

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public HomePage chooseToBrowseItems() {
        waitForVisibilityOf(flipkart_logo_locator);
        driver.findElement(flipkart_logo_locator).click();
        return new HomePage(driver);
    }

}
