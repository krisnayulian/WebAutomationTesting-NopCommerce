package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class SearchPage extends PageBase{

    public SearchPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "small-searchterms")
    WebElement searchTxtBox;
    @FindBy(css = "button.button-1.search-box-button")
    WebElement searchBtn;
    @FindBy(css = "h2.product-title")
    WebElement productTile;


    public void productSearch(String productName){
        sendTextElementText(searchTxtBox,productName);
        clickButton(searchBtn);

    }
    public void openProductDetailsPage(){
        clickButton(productTile);
    }




}
