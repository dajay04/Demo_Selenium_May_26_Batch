package stepdefinition;

import SeleniumJava.TestJava;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class AddStepDefns
{
    TestJava testJava = new TestJava();


    @Given("An empty employee list")
    public void anEmptyEmployeeList()
    {
        testJava.setUp("https://rahulshettyacademy.com/AutomationPractice/");
    }

    @When("An employee is added in list")
    public void anEmployeeIsAddedInList()
    {
        testJava.login();
    }
}
