package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;

    // Constructor
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    // Element
    private By dashboardField = By.xpath("//h6[contains(.,'sdasdsa')]");


    //method
    public boolean isDashboardFieldVisibile()
    {
        return driver.findElement(dashboardField).isDisplayed();
    }
}
