package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishlistPage;

public class AddProductToWishlistTest extends TestBase{

    String productName="Lenovo IdeaCentre 600 All-in-One PC";
    ProductDetailsPage detailsObject;
    SearchPage searchObject ;

    WishlistPage wishlistObject;


    @Test(priority = 1)
    public void UserCanSearchForProduct(){
        searchObject = new SearchPage(driver);
        searchObject.productSearch(productName);
        searchObject.openProductDetailsPage();
        detailsObject=new ProductDetailsPage(driver);
        Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));

    }
    @Test(priority = 2 ,dependsOnMethods = {"UserCanSearchForProduct"})
    public void UserCanAddProductToWishlist(){
        detailsObject=new ProductDetailsPage(driver);
        detailsObject.addProductToWishlist();
        detailsObject.goToWishlistPage();
        Assert.assertTrue(driver.getCurrentUrl().contains("wishlist"));
        wishlistObject=new WishlistPage(driver);
        Assert.assertTrue(wishlistObject.productNameCell.getText().equalsIgnoreCase(productName));
        Assert.assertEquals(wishlistObject.wishlistHeader.getText(), "Wishlist");

    }
    @Test(priority = 3 , dependsOnMethods = {"UserCanSearchForProduct","UserCanAddProductToWishlist"})
    public void UserCanRemoveProductFromWishlist(){
        wishlistObject =new WishlistPage(driver);
        wishlistObject.removeProductFromCart();
        Assert.assertTrue(wishlistObject.removeMsg.getText().contains("The wishlist is empty!"));
    }


}
