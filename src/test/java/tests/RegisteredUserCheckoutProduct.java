package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class RegisteredUserCheckoutProduct extends TestBase {
    String productName="Lenovo IdeaCentre 600 All-in-One PC";
    HomePage homeObject ;
    UserRegisterationPage registerObject;
    LoginPage loginObject;
    ProductDetailsPage detailsObject;
    SearchPage searchObject ;
    ShoppingCartPage cartObject;
    CheckoutPage checkoutObject ;

    OrderDetailsPage orderObject;

    String firstName="Test";
    String lastName ="User";
    String email="TestUser44@gmail.com";
    String password="123456";

    //1- registeration
    @Test(priority = 1,alwaysRun = true)
    public void userCanregisterSuccessfully(){
        homeObject=new HomePage(driver);
        homeObject.openRegisterationPage();
        registerObject =new UserRegisterationPage(driver);
        registerObject.userRegisteration(firstName,lastName,email,password);
        Assert.assertTrue(registerObject.successMsg.getText().contains("Your registration completed"));

    }
    //2-login
    @Test(priority = 2 ,dependsOnMethods = {"userCanregisterSuccessfully"})
    public void RegisteredUserCanLogin(){

        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.UserLogin(email,password);
        Assert.assertTrue(homeObject.logoutLink.getText().contains("Log out"));
    }

    //3-search product

    @Test(priority = 3)
    public void UserCanSearchForProduct(){
        searchObject = new SearchPage(driver);
        searchObject.productSearch(productName);
        searchObject.openProductDetailsPage();
        detailsObject=new ProductDetailsPage(driver);
        Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));

    }

    //4-add product to the cart
    @Test(priority = 4)
    public void UserCanAddProductToCart(){
        detailsObject=new ProductDetailsPage(driver);
        detailsObject.addToCart();
        detailsObject.goToShoppingCart();
        cartObject=new ShoppingCartPage(driver);
        Assert.assertTrue(cartObject.productName.getText().equalsIgnoreCase(productName));

    }
    //5-checkout
    @Test(priority = 5)
    public void UserCanCheckoutProduct(){
        cartObject=new ShoppingCartPage(driver);
        cartObject.OpenCheckoutPage();
        checkoutObject=new CheckoutPage(driver);
        checkoutObject.RegisteredUserCheckoutProduct("Indonesia","Jakarta","RAYA", "00000","089769997797","Jakarta");
        Assert.assertTrue(checkoutObject.productName.getText().equalsIgnoreCase(productName));
        checkoutObject.confirmOrder();
        System.out.println(checkoutObject.confirmOrderMsg.getText());
        Assert.assertTrue(checkoutObject.confirmOrderMsg.getText().contains("Your order has been successfully processed!"));

    }

    //6- print Invoice or download
    @Test(priority = 6)
    public void UserCanDownloadInvoice() throws InterruptedException {
        checkoutObject=new CheckoutPage(driver);
        checkoutObject.gotoOrderDetailsPage();
        orderObject=new OrderDetailsPage(driver);
        orderObject.downloadPdfInvoice();
        orderObject.printOrderDetails();
        Thread.sleep(Duration.ofSeconds(3));

    }
    //7-logout

    @Test(priority = 7 ,dependsOnMethods = {"RegisteredUserCanLogin"})
    public void RegisteredUserCanLogout(){
        homeObject.userLogout();

    }

}
