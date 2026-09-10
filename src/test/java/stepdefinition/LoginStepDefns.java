package stepdefinition;

import hooksClass.Hooks;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

import java.util.List;
import java.util.Map;

public class LoginStepDefns
{
    WebDriver driver = Hooks.getDriver();

    LoginPage loginPage = new LoginPage(driver);
    DashboardPage dashboardPage = new DashboardPage(driver);

    @Given("user navigated to login page of orange portal")
    public void user_navigated_to_login_page_of_orange_portal()
    {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @When("user enters username as {string} and password as {string}")
    public void user_enters_username_as_and_password_as(String username, String password)
    {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }
    @Then("user should be redirected to the dashboard page")
    public void user_should_be_redirected_to_the_dashboard_page()
    {
        // Visiblity of Element
       boolean isDashboardVisible=  dashboardPage.isDashboardFieldVisibile();
        Assert.assertTrue(isDashboardVisible);
        // URL Ass
        Assert.assertEquals("Current URL Didn't matched","https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index",driver.getCurrentUrl());
    }

    @Then("user verifies error message as {string}")
    public void user_verifies_error_message_as(String expectedError)
    {
        String actualError = loginPage.getErrorText();
        Assert.assertEquals("Error Message didn't matched",expectedError,actualError);

    }

    @When("user enters username and password as Map:")
    public void user_enters_username_and_password_as_map(io.cucumber.datatable.DataTable dataTable)
    {
      List<Map<String,String>> dataList = dataTable.asMaps(String.class,String.class);
      for (Map<String,String> data:dataList)
      {
          driver.findElement(By.xpath("//input[@name='username']")).sendKeys(data.get("user"));
          driver.findElement(By.xpath("//input[@type='password']")).sendKeys(data.get("pass"));
          driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();
      }
    }


}
