package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;


public class ContactUsTest extends TestBase{

    ContactUsPage contactObject ;
    HomePage homeObject;

    String fullName ="Test User";
    String email ="TestUser24@gmail.com";

    String msg="Hello Test , this is for test";


    @Test
    public void UserCanUseContactUs(){
        homeObject=new HomePage(driver);
        homeObject.openContactUsPage();
        contactObject=new ContactUsPage(driver);
        contactObject.contactUs(fullName,email,msg);
        Assert.assertTrue(contactObject.successMsg.getText().contains("Your enquiry has been successfully sent to the store owner."));
    }

}
