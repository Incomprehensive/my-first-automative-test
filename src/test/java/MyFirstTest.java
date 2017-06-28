import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import java.lang.String;

import java.awt.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Anton Pelianski on 28.06.2017.
 */
public class MyFirstTest {
    private WebDriver driver;
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\RemoteDriver\\Chrome\\chromedriver.exe"); // Declare a path to remote Chrome driver
        driver = new ChromeDriver(); // Open a Chrome Browser page
    }
    public void afterClass() {
        driver.close(); //close the Browser
    }
    public void delay(int var){
        driver.manage().timeouts().implicitlyWait(var, TimeUnit.SECONDS); //Setting uo Implicid Wait
    }
    @FindBy (id = "lst-ib")
    public WebElement searchField;

    @FindBy (id = "_fZl")
    public WebElement searchButton;

    @FindBy (xpath = "//div[@id='rso']//a[contains(text(), 'THE INFESTATION')]")
    public WebElement searchResult;

    public void search() {
        searchField.sendKeys("querry");
        searchButton.click();
    }

    @Test
    public void newGoogleSearch() throws InterruptedException {
        beforeClass();
        delay(10);
        driver.get("https://google.com.ua"); // Open a Google website
        //search("The Infestation"); //Locate text area nad type in search querry
        searchButton.click(); // Initiate search
        searchResult.click(); //Find a link to a band group
        afterClass();
    }
}
