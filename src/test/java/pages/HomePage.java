package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by nishant on 13/09/14.
 */
public class HomePage extends BasePage {

    By search_button_locator = By.id(app_package_name + "abs__search_button");
    By search_textbox_locator = By.id(app_package_name + "abs__search_src_text");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchFor(String keyword) {
        waitForClickabilityOf(search_button_locator);
        driver.findElement(search_button_locator).click();
        driver.findElement(search_button_locator).click();
        waitForVisibilityOf(search_textbox_locator);
        clearText(driver.findElement(search_textbox_locator));
        driver.findElement(search_textbox_locator).sendKeys(keyword);

    }

    void clearText(WebElement elementToBeCleared){
        elementToBeCleared.sendKeys("x");
        elementToBeCleared.clear();
    }
}
