package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "FullName")
    WebElement fullNameTxt;
    @FindBy(id = "Email")
    WebElement emailTxt;
    @FindBy(id = "Enquiry")
    WebElement enquiryTxt;
    @FindBy(css = "button.button-1.contact-us-button")
    WebElement submitBtn;
    @FindBy(css = "div.result")
    public WebElement successMsg;

    public void contactUs(String fullName ,String email , String message ){
        sendTextElementText(fullNameTxt,fullName);
        sendTextElementText(emailTxt,email);
        sendTextElementText(enquiryTxt,message);
        clickButton(submitBtn);

    }
}
