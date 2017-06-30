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
    public WebElement loginBtn1;

    @FindBy (id = "top-login-uname")
    public WebElement username;

    @FindBy (id = "top-login-pwd")
    public WebElement pass;

    @FindBy (xpath = "//div[@class = 'logged-in-as-wrap']/a[2]")
    public WebElement logoutBtn;

    @FindBy (id="top-login-btn")
    public WebElement loginBtn2;

    @FindBy (xpath = "//div[@class = 'logged-in-as-wrap']/a[1]")
    public WebElement verify;

    private String user = "kneeninja1";
    private String password = "IY7DP";

    private WebDriver driver;

    @Before
    public void initialize() {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\RemoteDriver\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
    }
    @Test
    public void testLogin() {
        WebDriverWait hold =  new WebDriverWait(driver, 10);
        driver.get("https://rutracker.org");
        loginBtn1.click();
        username.sendKeys(user);
        pass.sendKeys(password);
        loginBtn2.click();
        hold.until(ExpectedConditions.elementToBeClickable(logoutBtn));
        Assert.assertEquals(verify.getText(), user);
        logoutBtn.click();
        }
    @After
    public void close() {
        driver.close();
    }
}
