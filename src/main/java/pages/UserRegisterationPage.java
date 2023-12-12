package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterationPage extends PageBase {

    public UserRegisterationPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "gender-female")
    WebElement genderBtn ;

    @FindBy(id = "FirstName")
    WebElement fnTxtBox ;

    @FindBy(id = "LastName")
    WebElement lnTxtBox ;

    @FindBy(id = "Email")
    WebElement emailTxtBox ;

    @FindBy(id="Password")
    WebElement passwordTxtBox;

    @FindBy(id="ConfirmPassword")
    WebElement confirmPasswordTxtBox;

    @FindBy(id="register-button")
    WebElement registerBtn;

    @FindBy(css="div.result")
    public WebElement successMsg;

    public void userRegisteration(String firstName , String lastName ,String email , String password ){
        clickButton(genderBtn);

        fnTxtBox.sendKeys(firstName);
        sendTextElementText(fnTxtBox,firstName);
        sendTextElementText(lnTxtBox,lastName);
        sendTextElementText(emailTxtBox,email);
        sendTextElementText(passwordTxtBox,password);
        sendTextElementText(confirmPasswordTxtBox,password);
        clickButton(registerBtn);


    }

}
