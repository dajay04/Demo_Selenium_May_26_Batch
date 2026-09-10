package stepdefinition;

import SeleniumJava.TestJava;
import io.cucumber.java.en.Then;

public class VerifyStepDefn
{
    TestJava testJava = new TestJava();

    @Then("The employee added to list is visible or not")
    public void theEmployeeAddedToListIsVisibleOrNot()
    {
        testJava.tearDown();

    }
}
