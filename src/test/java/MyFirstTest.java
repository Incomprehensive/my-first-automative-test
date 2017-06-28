import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Anton Pelianski on 28.06.2017.
 */
public class MyFirstTest {
    @Test
   public void newGoogleSearch() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\RemoteDriver\\Chrome\\chromedriver.exe"); // Declare a path to remote Chrome driver
        WebDriver driver = new ChromeDriver(); // Open a Chrome Browser page
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); //Setting uo Implicid Wait
        driver.get("https://google.com.ua"); // Open a Google website
        driver.findElement(By.id("lst-ib")).sendKeys("The Infestation"); // Locate a text area and type in search inqury
        driver.findElement(By.id("_fZl")).click(); // Initiate search
        driver.findElement(By.xpath("//div[@id='rso']//a[contains(text(), 'THE INFESTATION')]")).click(); //Find a link to a band group
        driver.close(); //close the Browser

}
}
