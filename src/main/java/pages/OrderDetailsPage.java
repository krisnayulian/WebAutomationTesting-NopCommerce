package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class OrderDetailsPage extends PageBase{
    public OrderDetailsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "a.button-2.print-order-button")
    WebElement printBtn;
    @FindBy(css = "a.button-2.pdf-invoice-button")
    WebElement InvoiceBtn;

    public void printOrderDetails(){
        clickButton(printBtn);
    }

    public void downloadPdfInvoice(){
        clickButton(InvoiceBtn);
    }
}
