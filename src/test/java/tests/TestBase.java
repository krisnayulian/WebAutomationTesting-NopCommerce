package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import java.time.temporal.ChronoUnit;


public class TestBase {
    public static WebDriver driver;


    @BeforeClass
    @Parameters({"browser"})
    public  void startDriver(@Optional("chrome") String browserName){

        System.setProperty("webdriver.chrome.driver", "/home/krisna/github/chromedriver-linux64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver (options);
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.of(120, ChronoUnit.SECONDS));
        driver.get("https://demo.nopcommerce.com/");
    }

    @AfterClass
    public void stopDriver(){
        driver.quit();
    }
}
