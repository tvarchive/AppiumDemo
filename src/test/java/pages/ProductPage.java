package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by nishant on 24/09/14.
 */
public class ProductPage extends BasePage{


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage addToCart(String keyword) {
        driver.findElement(By.id(app_package_name+"product_page_bottom_bar_cart_button")).click();
        return new ProductPage(driver);
    }

    public void verifyCartShowsTheCount(){
        String count = driver.findElement(By.id(app_package_name + "cart_count")).getText();
        Assert.assertEquals(count,"1".toString());
    }

}
