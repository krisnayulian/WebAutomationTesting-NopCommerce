package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends PageBase{
    public WishlistPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "a.product-name")
    public WebElement productNameCell;
    @FindBy(css = "h1")
    public WebElement wishlistHeader;
    @FindBy(css="button.remove-btn")
    WebElement removeProduct;
    @FindBy(css = "div.no-data")
    public WebElement removeMsg;

    public void removeProductFromCart(){
        clickButton(removeProduct);
    }


}
