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

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by Anton Pelianski on 30.06.2017.
 */
public class SeleniumTest {
    @FindBy (id = "top-login-uname")
    private WebElement username;

    @FindBy (id = "top-login-pwd")
    private WebElement pass;

    @FindBy (xpath = "//div[@class = 'logged-in-as-wrap']/a[2]")
    private WebElement logoutButton;

    @FindBy (xpath = "//span[@class = 'a-like bold']")
    private WebElement loginButtonForm;

    @FindBy (id="top-login-btn")
    private WebElement loginButtonConfirm;

    @FindBy (xpath = "//div[@class = 'logged-in-as-wrap']/a[1]")
    private WebElement verify;

    @FindBy (id = "search-text")
    private WebElement searchInput;

    @FindBy (id = "search-submit")
    private WebElement searchSubmit;

    File file = new File("C:\\Users\\Anton Pelianski\\IdeaProjects\\AdvancedSeleniumTask-Maven\\src\\test\\java\\login.txt");
    public String line;
    public String user;
    public String password;
    public String keyUser = "login: ";
    public String keyPass = "pasword: ";
    private WebDriver driver;
    WebDriverWait hold;

    public SeleniumTest() throws FileNotFoundException {
    }

    @Before
    public void initialize() {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\RemoteDriver\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        hold =  new WebDriverWait(driver, 10);
    }

    public void read() throws FileNotFoundException {
        Scanner br = new Scanner(file);
        if (br.hasNext(keyUser)) {
            user = br.nextLine();
        }
        if (br.hasNext(keyPass)) {
            password = br.nextLine();
        }
    }

    public void login() {
        hold.until(ExpectedConditions.elementToBeClickable(loginButtonForm));
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
    public void testLogin() throws FileNotFoundException {
        driver.get("https://rutracker.org");
        read();
        login();
        Assert.assertEquals(verify.getText(), user);
        hold.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logout();
    }

    @Test
    public void testLoginSearch() {
        driver.get("https://rutracker.org");
        read();
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
