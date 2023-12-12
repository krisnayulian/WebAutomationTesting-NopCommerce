package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "button.button-1.checkout-as-guest-button")
    WebElement checkoutGuestBtn;
    @FindBy(css = "button.button-1.login-button")
    WebElement loginBtn;
    @FindBy(id = "BillingNewAddress_FirstName")
    WebElement fisrstNameTxt;
    @FindBy(id = "BillingNewAddress_LastName")
    WebElement lastNameTxt;
    @FindBy(id = "BillingNewAddress_Email")
    WebElement emailTxt;

    @FindBy(id = "BillingNewAddress_Company")
    WebElement companyTxt;
    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement countryList;
    @FindBy(id = "BillingNewAddress_City")
    WebElement cityTxt;
    @FindBy(id = "BillingNewAddress_Address1")
    WebElement addressTxt;
    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement zipCodeTxt;
    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement phoneNumberTxt;
    @FindBy(css = "button.button-1.new-address-next-step-button")
    WebElement billingContinueBtn;
    @FindBy(id = "shippingoption_1")
    WebElement shippingMethodRdo;
    @FindBy(css = "button.button-1.shipping-method-next-step-button")
    WebElement sippingContinueBtn;
    @FindBy(id = "paymentmethod_0")
    WebElement paymentMethodRdo;
    @FindBy(css = "button.button-1.payment-method-next-step-button")
    WebElement paymentContinueBtn;
    @FindBy(css = "button.button-1.payment-info-next-step-button")
    WebElement paymentInfoContinueBtn;
    @FindBy(css = "a.product-name")
    public WebElement productName;
    @FindBy(css = "button.button-1.confirm-order-next-step-button")
    WebElement confirmBtn;
    @FindBy(xpath ="//strong[contains(text(),\"Your order has been successfully processed!\")]")
    public WebElement confirmOrderMsg;
    @FindBy(linkText = "Click here for order details.")
     WebElement ordersDetailsLink;

    public void RegisteredUserCheckoutProduct(String countryName , String address , String company, String zipCode ,String phone,String city){
        sendTextElementText(companyTxt,company);
        select=new Select(countryList);
        select.selectByVisibleText(countryName);
        sendTextElementText(addressTxt,address);
        sendTextElementText(zipCodeTxt,zipCode);
        sendTextElementText(phoneNumberTxt,phone);
        sendTextElementText(cityTxt,city);
        clickButton(billingContinueBtn);
        clickButton(shippingMethodRdo);
        clickButton(sippingContinueBtn);
        clickButton(paymentMethodRdo);
        clickButton(paymentContinueBtn);
        clickButton(paymentInfoContinueBtn);

    }

    public void GusetUserCheckoutProduct(String firstName,String lastName,String email, String company, String countryName , String address , String zipCode ,String phone,String city){
        clearText(fisrstNameTxt);
        sendTextElementText(fisrstNameTxt,firstName);
        sendTextElementText(lastNameTxt,lastName);
        sendTextElementText(emailTxt,email);
        sendTextElementText(companyTxt,company);
        select=new Select(countryList);
        select.selectByVisibleText(countryName);
        sendTextElementText(addressTxt,address);
        sendTextElementText(zipCodeTxt,zipCode);
        sendTextElementText(phoneNumberTxt,phone);
        sendTextElementText(cityTxt,city);
        clickButton(billingContinueBtn);
        clickButton(shippingMethodRdo);
        clickButton(sippingContinueBtn);
        clickButton(paymentMethodRdo);
        clickButton(paymentContinueBtn);
        clickButton(paymentInfoContinueBtn);

    }

    public void guestUSerGoToCheckoutPage(){
        clickButton(checkoutGuestBtn);
    }

    public void gotoOrderDetailsPage(){
        clickButton(ordersDetailsLink);
    }

    public  void confirmOrder(){
        clickButton(confirmBtn);
    }




}
