package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ShoppingCartPage extends PageBase{
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
   @FindBy(css = "a.product-name")
   public WebElement productName;

   @FindBy(css = "input.qty-input")
   public WebElement quantityTxt;
   @FindBy(css = "button.remove-btn")
   WebElement removeBtn;
   @FindBy(css = "div.no-data")
   public WebElement removeMsg;
   @FindBy(id = "updatecart")
   WebElement updateCartBtn;
   @FindBy(id = "termsofservice")
   WebElement agreeCheckbox;
   @FindBy(id = "checkout")
   WebElement checkoutBtn;

   public void removeProductFromCart(){
       clickButton(removeBtn);
   }

   public void UpdateProductQuantityInCart(String quantity){
       clearText(quantityTxt);
       sendTextElementText(quantityTxt,quantity);
       clickButton(updateCartBtn);
   }
   public void OpenCheckoutPage(){
       clickButton(agreeCheckbox);
       clickButton(checkoutBtn);
   }


}
