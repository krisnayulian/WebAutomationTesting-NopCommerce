package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase{
    public EmailFriendPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "FriendEmail")
    WebElement emailFriendTxt;
    @FindBy(id = "PersonalMessage")
    WebElement personalMsgText;

    @FindBy(css = "button.button-1.send-email-a-friend-button")
    WebElement sendEmailBtn;
    @FindBy(css = "div.result")
    public WebElement msgNotification;

    public void sendEmailToFriend(String friendEmail , String personalMsg){
        sendTextElementText(emailFriendTxt,friendEmail);
        sendTextElementText(personalMsgText,personalMsg);
        clickButton(sendEmailBtn);

    }
}
