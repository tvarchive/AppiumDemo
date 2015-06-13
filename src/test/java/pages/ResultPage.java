package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class ResultPage extends HomePage {

    By searchResultHeader = By.id(app_package_name + "product_list_query_text");
    By productHeaderText = By.id(app_package_name + "product_list_product_item_main_text");


    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage selectFirstResultFor(String keyword) {
        waitForVisibilityOf(searchResultHeader);

        if(driver.findElement(searchResultHeader).getText().contains(keyword)){
            List<WebElement> results= driver.findElements(productHeaderText);
                results.get(0).click();
            return new ProductPage(driver);
    }
        System.out.println("Couldn't find the result");
        return null;
    }
}
