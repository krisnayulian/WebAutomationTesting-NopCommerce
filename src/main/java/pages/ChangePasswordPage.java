package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage extends PageBase{

    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="OldPassword")
    WebElement oldPasswordTxt;

    @FindBy(id = "NewPassword")
    WebElement newPasswordTxt;

    @FindBy(id = "ConfirmNewPassword")
    WebElement confirmPasswordTxt;

    @FindBy(css = "button.button-1.change-password-button")
    WebElement changePasswordBtn;

    @FindBy(css = "p.content")
    public WebElement resultLbl;

    @FindBy(css = "span.close")
    WebElement closeResultLbl;

    public void ChangePassword(String oldPassword ,String newPassword){
        sendTextElementText(oldPasswordTxt,oldPassword);
        sendTextElementText(newPasswordTxt,newPassword);
        sendTextElementText(confirmPasswordTxt,newPassword);
        clickButton(changePasswordBtn);

    }

    public void CloseResultLbl(){
        clickButton(closeResultLbl);
    }

}
