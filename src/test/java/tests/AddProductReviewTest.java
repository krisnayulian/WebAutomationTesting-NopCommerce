package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;


public class AddProductReviewTest extends TestBase{
    String productName="Lenovo IdeaCentre 600 All-in-One PC";
    HomePage homeObject ;
    UserRegisterationPage registerObject;
    LoginPage loginObject;
    ProductDetailsPage detailsObject;
    SearchPage searchObject ;
    ProductReviewPage reviewObject;

    String firstName="Test";
    String lastName ="User";
    String email="TestUser14@gmail.com";//Change The Number Before test
    String password="123456";

    //1- user Registeration
    @Test(priority = 1,alwaysRun = true)
    public void userCanregisterSuccessfully(){
        homeObject=new HomePage(driver);
        homeObject.openRegisterationPage();
        registerObject =new UserRegisterationPage(driver);
        registerObject.userRegisteration(firstName,lastName,email,password);
        Assert.assertTrue(registerObject.successMsg.getText().contains("Your registration completed"));

    }
    //2- user Login
    @Test(priority = 2 , dependsOnMethods = {"userCanregisterSuccessfully"})
    public void RegisteredUserCanLogin(){
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.UserLogin(email,password);
        Assert.assertTrue(homeObject.logoutLink.getText().contains("Log out"));
    }


    //3- search for product
    @Test(priority = 3)
    public void UserCanSearchForProduct(){
        searchObject = new SearchPage(driver);
        searchObject.productSearch(productName);
        searchObject.openProductDetailsPage();
        detailsObject=new ProductDetailsPage(driver);
        Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
    }

    //3- add review
    @Test(priority = 4)
    public void UserCanAddReview(){
        detailsObject=new ProductDetailsPage(driver);
        detailsObject.openProductReviewPage();
        reviewObject=new ProductReviewPage(driver);
        reviewObject.AddProductReview("good","the product is very good");
        Assert.assertTrue(registerObject.successMsg.getText().contains("Product review is successfully added."));

    }

    //5-logout
    @Test(priority = 5,dependsOnMethods = {"RegisteredUserCanLogin"})
    public void RegisteredUserCanLogout(){
        homeObject.userLogout();

    }
}
