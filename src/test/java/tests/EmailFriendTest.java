package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class EmailFriendTest extends TestBase{
    String productName="Lenovo IdeaCentre 600 All-in-One PC";
    HomePage homeObject ;
    UserRegisterationPage registerObject;
    LoginPage loginObject;
    ProductDetailsPage detailsObject;
    SearchPage searchObject ;
    EmailFriendPage emailObject;

    String firstName="Test";
    String lastName ="User";
    String email="TestUser33@gmail.com";
    String password="123456";



    //1- user registeration
    @Test(priority = 1,alwaysRun = true)
    public void userCanregisterSuccessfully(){
        homeObject=new HomePage(driver);
        homeObject.openRegisterationPage();
        registerObject =new UserRegisterationPage(driver);
        registerObject.userRegisteration(firstName,lastName,email,password);
        Assert.assertTrue(registerObject.successMsg.getText().contains("Your registration completed"));

    }
    //2- user login
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

    //4-email to friend
    @Test(priority = 4)
    public void RegisteredUserCanSendProductToFriend(){
        detailsObject=new ProductDetailsPage(driver);
        detailsObject.openSendEmail();
        emailObject = new EmailFriendPage(driver);
        emailObject.sendEmailToFriend("FrienUser@gmail.com","Hello My Fried , this product is good");
        Assert.assertTrue(emailObject.msgNotification.getText().contains("Your message has been sent."));

    }

    //4-logout
    @Test(priority = 5 ,dependsOnMethods = {"RegisteredUserCanLogin"})
    public void RegisteredUserCanLogout(){
        homeObject.userLogout();

    }
}
