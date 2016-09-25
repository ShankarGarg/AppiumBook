package com.cucumber.automation.stepdefinition;

import com.cucumber.automation.pages.iOS.HomePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class iOSTestAppSD {

    HomePage homePage = new HomePage();
    
    @Given("^user is on Application Home Page$")
    public void user_is_on_Application_Home_Page() {
	assertTrue(homePage.isHomePage());
    }

    @When("^user enters \"([^\"]*)\" in first field$")
    public void user_enters_in_first_field(String arg1) {
	homePage.typeTextField1(arg1);
    }

    @When("^user enters \"([^\"]*)\" in second field$")
    public void user_enters_in_second_field(String arg1) {
	homePage.typeTextField2(arg1);
    }

    @When("^clicks on Compute Sum$")
    public void clicks_on_Compute_Sum() {
	homePage.clickComputeSum();
    }

    @Then("^user sees computed sum as \"([^\"]*)\"$")
    public void user_sees_computed_sum_as(String arg1) {
	assertEquals(arg1, homePage.returnResult());
    }
    
}
