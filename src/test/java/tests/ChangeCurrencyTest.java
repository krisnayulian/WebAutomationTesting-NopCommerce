package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase{
   String productName="Lenovo IdeaCentre 600 All-in-One PC";
   HomePage homeObject;
   ProductDetailsPage detailsObject;
   SearchPage searchObject ;

   @Test(priority = 1)
    public void UserCanChangeCurrency(){
       homeObject= new HomePage(driver);
       homeObject.changeCurrency();

   }

    @Test(priority = 2)
    public void UserCanSearchForProduct(){
        searchObject = new SearchPage(driver);
        searchObject.productSearch(productName);
        searchObject.openProductDetailsPage();
        detailsObject=new ProductDetailsPage(driver);
        Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
        Assert.assertTrue(detailsObject.productPriceLbl.getText().contains("€"));
        System.out.println(detailsObject.productPriceLbl.getText());

    }

}
