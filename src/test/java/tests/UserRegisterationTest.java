package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTest extends TestBase{

  HomePage homeObject ;
  UserRegisterationPage registerObject;

  LoginPage loginObject;

    String firstName="Test";
    String lastName ="User";
    String email="TestUser1@gmail.com";
    String password="123456";

    @Test(priority = 1,alwaysRun = true)
    public void userCanregisterSuccessfully(){
        homeObject=new HomePage(driver);
        homeObject.openRegisterationPage();
        registerObject =new UserRegisterationPage(driver);
        registerObject.userRegisteration(firstName,lastName,email,password);
        Assert.assertTrue(registerObject.successMsg.getText().contains("Your registration completed"));

    }

    @Test(dependsOnMethods = {"userCanregisterSuccessfully"})
    public void RegisteredUserCanLogin(){
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.UserLogin(email,password);
        Assert.assertTrue(homeObject.logoutLink.getText().contains("Log out"));
    }

    @Test(dependsOnMethods = {"RegisteredUserCanLogin"})
    public void RegisteredUserCanLogout(){
        homeObject.userLogout();

    }
}
