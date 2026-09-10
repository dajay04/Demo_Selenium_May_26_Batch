package stepdefinition;

import hooksClass.Hooks;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class DashboardStepDefns
{
    WebDriver driver;

    @Then("User should see following dashboard menu items:")
    public void user_should_see_following_dashboard_menu_items(List<String> expectedMenuItems)
    {
        //Step 1: Storing of all menuItems in WebElement List ( findElements)
        List<WebElement> menuItems = driver.findElements(By.cssSelector("ul.oxd-main-menu > li span.oxd-text"));

       // Step 2: Text get from each menuItems like Admin, Dashboard, Claim, PIM.... List < String > --- Actual List
       List<String> actualMenuItems =  menuItems.stream().map(WebElement::getText).collect(Collectors.toList());

       //Step 3: Travser each expected menuItems from acutal menuItems list ... if not found then assert will fail....
       for (String expectedItem:expectedMenuItems)
       {
           Assert.assertTrue("Dashboard menu missing: "+expectedItem,actualMenuItems.contains(expectedItem));
       }
    }

}
