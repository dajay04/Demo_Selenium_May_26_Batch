package SeleniumJava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestJava
{
    public static WebDriver driver;
    // Launch browser
    public void setUp(String url)
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        System.out.println("Url opened ");
    }

    // close browser
    public void tearDown()
    {
        driver.quit();
        System.out.println("Browser closed ");
    }


    public void login()
    {
        System.out.println("Login Scuess!!!");
    }


}
