package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComparePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToCompareTest extends TestBase{

    String firstProductName="Lenovo IdeaCentre 600 All-in-One PC";
    String secondProductName="Digital Storm VANQUISH 3 Custom Performance PC";

    ProductDetailsPage detailsObject;
    SearchPage searchObject ;

    ComparePage compareObject;


    //1- Search for porduct one

    @Test(priority = 1)
    public void UserCanSearchForProductOneAndAddToCompareList(){
        searchObject = new SearchPage(driver);
        searchObject.productSearch(firstProductName);
        searchObject.openProductDetailsPage();
        detailsObject=new ProductDetailsPage(driver);
        Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(firstProductName));
        detailsObject.addProductToCompare();
    }

    //2- Search for porduct two

    @Test(priority = 2)
    public void UserCanSearchForProductTwoAndAddToCompareList(){
        searchObject = new SearchPage(driver);
        searchObject.productSearch(secondProductName);
        searchObject.openProductDetailsPage();
        detailsObject=new ProductDetailsPage(driver);
        Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(secondProductName));
        detailsObject.addProductToCompare();


    }

    //3- Add to compare

    @Test(priority = 3)
    public void UserCanCompareProducts(){
        detailsObject=new ProductDetailsPage(driver);
        detailsObject.goToProductComparePage();
        compareObject=new ComparePage(driver);
        compareObject.CompareProducts();
        Assert.assertTrue(compareObject.productOneLink.getText().contains("Lenovo IdeaCentre 600 All-in-One PC"));
        Assert.assertTrue(compareObject.productTwoLink.getText().contains("Digital Storm VANQUISH 3 Custom Performance PC"));


    }

    //4- clear list
    @Test(priority = 4)
    public void UserCanRemoveList(){
        compareObject=new ComparePage(driver);
        compareObject.clearCompareList();
        Assert.assertTrue(compareObject.removeDataMsg.getText().contains("You have no items to compare."));

    }

}
