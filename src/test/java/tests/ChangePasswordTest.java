package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;


public class ChangePasswordTest extends TestBase{

    HomePage homeObject;
    UserRegisterationPage registerObject;
    LoginPage loginObject;
    ChangePasswordPage changePasswordObject;
    MyAccountPage myAccountObject;

    String firstName = "Krisnanda";
    String lastName ="Yulian";
    String email="TestUser23@gmail.com";
    String oldPassword ="123456";

    String newPassword="123456789";

    @Test(priority = 1,alwaysRun = true)
    public void userCanregisterSuccessfully(){
        homeObject=new HomePage(driver);
        homeObject.openRegisterationPage();
        registerObject =new UserRegisterationPage(driver);
        registerObject.userRegisteration(firstName,lastName,email,oldPassword);
        Assert.assertTrue(registerObject.successMsg.getText().contains("Your registration completed"));

    }

    @Test(priority = 2)
    public void RegisteredUserCanLogin(){
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.UserLogin(email,oldPassword);
        Assert.assertTrue(homeObject.logoutLink.getText().contains("Log out"));
    }

    @Test(priority = 3)
    public void RegisteredUserCanChangePassword(){
        homeObject=new HomePage(driver);
        homeObject.openMyAccountPage();
        myAccountObject=new MyAccountPage(driver);
        myAccountObject.openChangePasswordPage();
        changePasswordObject =new ChangePasswordPage(driver);
        changePasswordObject.ChangePassword(oldPassword,newPassword);
        Assert.assertTrue(changePasswordObject.resultLbl.getText().contains("Password was changed"));
        changePasswordObject.CloseResultLbl();


    }

    @Test(priority = 4)
    public void RegisteredUserCanLogout(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click()", homeObject.logoutLink);


    }

    @Test(priority = 5)
    public void RegisteredUserCanLogin2(){
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.UserLogin(email,newPassword);
        Assert.assertTrue(homeObject.logoutLink.getText().contains("Log out"));
    }
}
