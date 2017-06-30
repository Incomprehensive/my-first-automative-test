import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Anton Pelianski on 30.06.2017.
 */
public class SeleniumTest {
    @FindBy (xpath = ".//*[@id='lst-ib']")
    public WebElement searchFieldGoogle;

    @FindBy (xpath = "//*[@type = 'submit']")
    public WebElement submitButton;

    @FindBy (xpath = "//span[contains(text(), 'Вход')]")
    public WebElement logIn;

    @FindBy (xpath = "//div[@class = 'srg']/div[1]//a")
    public WebElement firstResult;

    @FindBy (id = "top-login-uname")
    public WebElement username;

    @FindBy (id = "top-login-pwd")
    public WebElement pass;

    @FindBy (xpath = "//a[contains(text(), 'Выход')]")
    public WebElement logout;

    @FindBy (id="top-login-btn")
    public WebElement loginButton;

    public String expectedTitle = "BitTorrent трекер RuTracker.org";
    private WebDriver driver;

    @Test
    public void startWebDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\RemoteDriver\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        driver.get("https://google.com.ua");
        searchFieldGoogle.sendKeys("rutracker.org");
        submitButton.click();
        WebElement myPause1 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(firstResult));
        firstResult.click();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        WebElement myPause2 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(logIn));
        logIn.click();
        username.sendKeys("kneeninja1");
        pass.sendKeys("IY7DP");
        loginButton.click();
        logout.click();
        driver.close();
    }
}
