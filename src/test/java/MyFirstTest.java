import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Anton Pelianski on 28.06.2017.
 */
public class MyFirstTest {
    @Test

   public void GoogleSearch() throws InterruptedException {

        final String s = System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\RemoteDriver\\Chrome\\chromedriver.exe"); // Declare a path to remote Chrome driver
        WebDriver driver = new ChromeDriver(); // Open a Chrome Browser page
        driver.get("https://google.com.ua"); // Open a Google website
        driver.findElement(By.id("lst-ib")).sendKeys("The Infestation"); // Locate a text area and type in search inqury
        driver.findElement(By.id("_fZl")).click(); // Initiate search
        Thread.sleep (4000);
        System.out.print("Please Wait");
        Thread.sleep(4000);
        driver.findElement(By.partialLinkText("THE INFESTATION")).click(); //Find a link to a band group
        driver.close(); //close the Browser

}
}
