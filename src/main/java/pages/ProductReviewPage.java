package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase{
    public ProductReviewPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "AddProductReview_Title")
    WebElement reviewTitleTxt;
    @FindBy(id = "AddProductReview_ReviewText")
    WebElement reviewTxt;
    @FindBy(id = "addproductrating_4")
    WebElement rating4RadioBtn;
    @FindBy(css = "button.button-1.write-product-review-button")
    WebElement submitBtn;

    public void AddProductReview(String reviewTitle , String reviewMsg){
        sendTextElementText(reviewTitleTxt,reviewTitle);
        sendTextElementText(reviewTxt,reviewMsg);
        clickButton(rating4RadioBtn);
        clickButton(submitBtn);

    }


}
