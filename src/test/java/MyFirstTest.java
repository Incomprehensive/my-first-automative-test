import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Anton Pelianski on 30.06.2017.
 */
public class SeleniumTest {
    @FindBy (xpath = "//span[@class = 'a-like bold']")
    private WebElement loginButtonForm;

    @FindBy (id = "top-login-uname")
    private WebElement username;

    @FindBy (id = "top-login-pwd")
    private WebElement pass;

    @FindBy (xpath = "//div[@class = 'logged-in-as-wrap']/a[2]")
    private WebElement logoutButton;

    @FindBy (id="top-login-btn")
    private WebElement loginButtonConfirm;

    @FindBy (xpath = "//div[@class = 'logged-in-as-wrap']/a[1]")
    private WebElement verify;

    @FindBy (id = "search-text")
    private WebElement searchInput;

    @FindBy (id = "search-submit")
    private WebElement searchSubmit;

    public String user = "kneeninja1";
    public String password = "IY7DP";
    private WebDriver driver;
    WebDriverWait hold;

    @Before
    public void initialize() {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\RemoteDriver\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        WebDriverWait hold =  new WebDriverWait(driver, 10);
    }

    public void login() {
        loginButtonForm.click();
        username.sendKeys(user);
        pass.sendKeys(password);
        loginButtonConfirm.click();
    }

    public void search (String query) {
        searchInput.sendKeys(query);
        searchSubmit.click();
    }

    public void logout() {
        logoutButton.click();
    }

    @Test
    public void testLogin() {
        initialize();
        driver.get("https://rutracker.org");
        login();
        Assert.assertEquals(verify.getText(), user);
        hold.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logout();
    }

    @Test
    public void testLoginSearch() {
        login();
        search("The infestation");
        hold.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logout();
    }

    @After
    public void close() {
        driver.close();
    }
}
