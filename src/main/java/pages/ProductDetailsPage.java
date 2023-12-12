package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "strong.current-item")
    public WebElement productNamebreadCrumb;
    @FindBy(linkText = "Add your review")
    WebElement addReview;
    @FindBy(id = "add-to-cart-button-3")
    WebElement addToCartBtn;
    @FindBy(id = "add-to-wishlist-button-3")
    WebElement addToWhishlistBtn;

    @FindBy(css="button.button-2.add-to-compare-list-button")
    WebElement addToCompareBtn;

    @FindBy(css="button.button-2.email-a-friend-button")
    WebElement emailFriendBtn;

    @FindBy(id = "price-value-3")
    public WebElement productPriceLbl;

    @FindBy(linkText = "wishlist")
    WebElement goToWishlistLink;

    @FindBy(linkText = "product comparison")
    WebElement goToCompareLink;
    @FindBy(linkText = "shopping cart")
    WebElement goToCartLink;


   public void openSendEmail(){
       clickButton(emailFriendBtn);
   }

   public void openProductReviewPage(){
       clickButton(addReview);
   }

   public void addProductToWishlist(){
       clickButton(addToWhishlistBtn);
   }

   public void goToWishlistPage(){
       clickButton(goToWishlistLink);
   }

    public void addProductToCompare(){
        clickButton(addToCompareBtn);
    }
    public void goToProductComparePage(){

       clickButton(goToCompareLink);
    }

    public void addToCart(){
       clickButton(addToCartBtn);
    }
    public void goToShoppingCart(){
      clickButton(goToCartLink);
    }

}
