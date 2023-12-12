package pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class HomePage extends PageBase{


    public HomePage(WebDriver driver) {
        super(driver);
        jsExecutor=(JavascriptExecutor) driver;
        action=new Actions(driver);
    }

    @FindBy(linkText = "Register")
    WebElement registerLink;

    @FindBy(linkText = "Log in")
    WebElement loginLink;

    @FindBy(linkText = "Log out")
    public WebElement logoutLink;

    @FindBy(linkText = "My account")
    public WebElement myAccountLink;

    @FindBy(linkText = "Contact us")
    public WebElement contactUsLink;

    @FindBy(id = "customerCurrency")
    WebElement currencyList;

    public void openRegisterationPage(){
        clickButton(registerLink);
    }

    public void openLoginPage(){
        clickButton(loginLink);
    }

    public void userLogout(){
        clickButton(logoutLink);
    }

    public void openMyAccountPage(){
        clickButton(myAccountLink);
    }


    public void openContactUsPage(){
        scrollToBottom();
        clickButton(contactUsLink);
    }

    public void changeCurrency(){
        select=new Select(currencyList);
        select.selectByVisibleText("Euro");
    }




}
