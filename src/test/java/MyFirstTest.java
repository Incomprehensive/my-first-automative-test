import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Anton Pelianski on 28.06.2017.
 */
public class MyFirstTest {
    private String expectedTitle = "Google";

    @FindBy (xpath = ".//*[@id='lst-ib']")
    public WebElement searchField;

    @FindBy (id = "_fZl")
    public WebElement searchButton;

    @FindBy (xpath = "//div[@id='rso']//a[contains(text(), 'THE INFESTATION')]")
    public WebElement searchResult;

    private WebDriver driver;

    @Before
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\RemoteDriver\\Chrome\\chromedriver.exe"); // Declare a path to remote Chrome driver
        driver = new ChromeDriver(); // Open a Chrome Browser page
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //Setting uo Implicit Wait
        PageFactory.initElements(driver, this);
    }
    @Test
    public void newGoogleSearch() throws InterruptedException {
        driver.get("https://google.com.ua"); // Open a Google website
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        searchField.sendKeys("THE INFESTATION"); //Locate text area and type in search query
        searchButton.click();
        searchResult.click(); //Find a link to a band group
    }
    @After
    public void afterClass() {

        driver.close(); //close the Browser
    }

}
