package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class GuestUSerCheckoutProduct extends TestBase{

    String productName="Lenovo IdeaCentre 600 All-in-One PC";
    ProductDetailsPage detailsObject;
    SearchPage searchObject ;
    ShoppingCartPage cartObject;
    CheckoutPage checkoutObject ;

    OrderDetailsPage orderObject;


    //3-search product

    @Test(priority = 1)
    public void UserCanSearchForProduct(){
        searchObject = new SearchPage(driver);
        searchObject.productSearch(productName);
        searchObject.openProductDetailsPage();
        detailsObject=new ProductDetailsPage(driver);
        Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));

    }

    //4-add product to the cart
    @Test(priority = 2)
    public void UserCanAddProductToCart(){
        detailsObject=new ProductDetailsPage(driver);
        detailsObject.addToCart();
        detailsObject.goToShoppingCart();
        cartObject=new ShoppingCartPage(driver);
        Assert.assertTrue(cartObject.productName.getText().equalsIgnoreCase(productName));

    }
    //5-checkout
    @Test(priority = 3)
    public void UserCanCheckoutProduct(){
        cartObject=new ShoppingCartPage(driver);
        cartObject.OpenCheckoutPage();
        checkoutObject=new CheckoutPage(driver);
        checkoutObject.guestUSerGoToCheckoutPage();
        checkoutObject.GusetUserCheckoutProduct("Test","User","TestUser@gmail.com", "RAYA","Indonesia","test address","0000","0123456789","Jakarta");
        Assert.assertTrue(checkoutObject.productName.getText().equalsIgnoreCase(productName));
        checkoutObject.confirmOrder();
        System.out.println(checkoutObject.confirmOrderMsg.getText());
        Assert.assertTrue(checkoutObject.confirmOrderMsg.getText().contains("Your order has been successfully processed!"));

    }

    //6- print Invoice or download
    @Test(priority = 4)
    public void UserCanDownloadInvoice() throws InterruptedException {
        checkoutObject=new CheckoutPage(driver);
        checkoutObject.gotoOrderDetailsPage();
        orderObject=new OrderDetailsPage(driver);
        orderObject.downloadPdfInvoice();
        orderObject.printOrderDetails();
        Thread.sleep(Duration.ofSeconds(3));

    }



}
