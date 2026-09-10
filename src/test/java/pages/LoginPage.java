package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage
{
    private WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver)
    {
        this.driver= driver;
    }

    // Elements
    private By usernameField = By.xpath("//input[@name='username']");
    private By passwordField= By.xpath("//input[@type='password']");
    private By loginBtn = By.xpath("//button[contains(.,'Login')]");
    private By errorText = By.xpath("//p[contains(.,'Invalid credentials')]");

    // actionable items

    public void enterUsername(String username)
    {
        driver.findElement(usernameField).sendKeys(username);
    }
    public void enterPassword(String password)
    {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickLogin()
    {
        driver.findElement(loginBtn).click();
    }

    public String getErrorText()
    {
       return driver.findElement(errorText).getText();
    }
}
