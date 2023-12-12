package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToCartTest extends TestBase{

    //1-search product

    String productName="Lenovo IdeaCentre 600 All-in-One PC";
    ProductDetailsPage detailsObject;
    SearchPage searchObject ;

    ShoppingCartPage cartObject;


    @Test(priority = 1)
    public void UserCanSearchForProduct(){
        searchObject = new SearchPage(driver);
        searchObject.productSearch(productName);
        searchObject.openProductDetailsPage();
        detailsObject=new ProductDetailsPage(driver);
        Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));

    }

    //2- add to cart
    @Test(priority = 2)
    public void UserCanAddProductToCart(){
        detailsObject=new ProductDetailsPage(driver);
        detailsObject.addToCart();
        detailsObject.goToShoppingCart();
        cartObject=new ShoppingCartPage(driver);
        Assert.assertTrue(cartObject.productName.getText().equalsIgnoreCase("Lenovo IdeaCentre 600 All-in-One PC"));

    }

    //3- update quantity
    @Test(priority = 3)
    public void UserCanUpdateQuantity(){
        cartObject= new ShoppingCartPage(driver);
        cartObject.UpdateProductQuantityInCart("5");
        Assert.assertEquals(cartObject.quantityTxt.getAttribute("value"),"5");
    }


    //4- remove product
    @Test(priority = 4)
    public void UserCanRemoveProductFromCart(){
        cartObject= new ShoppingCartPage(driver);
        cartObject.removeProductFromCart();
        Assert.assertTrue(cartObject.removeMsg.getText().contains("Your Shopping Cart is empty!"));
    }
}
