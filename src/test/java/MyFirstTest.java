import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public void search(String query) {
        searchField.sendKeys(query);
        searchButton.click();
    }

    public void init(final WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @Test
    public void newGoogleSearch() throws InterruptedException {
        init(driver);
        beforeClass();
        delay(10);
        driver.get("https://google.com.ua"); // Open a Google website
        search("THE INFESTATION"); //Locate text area and type in search query
        searchResult.click(); //Find a link to a band group
        afterClass();
    }
}
