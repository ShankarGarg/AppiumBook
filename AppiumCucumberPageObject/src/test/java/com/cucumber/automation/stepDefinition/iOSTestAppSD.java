package com.cucumber.automation.stepDefinition;

import com.cucumber.automation.pages.iOS.HomePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class iOSTestAppSD {

    HomePage hp = new HomePage();
    
    @Given("^user is on Application Home Page$")
    public void user_is_on_Application_Home_Page() {
	hp.verifyHomePage();
    }

    @When("^user enters \"([^\"]*)\" in first field$")
    public void user_enters_in_first_field(String arg1) {
	hp.typeTextField1(arg1);
    }

    @When("^user enters \"([^\"]*)\" in second field$")
    public void user_enters_in_second_field(String arg1) {
	hp.typeTextField2(arg1);
    }

    @When("^clicks on Compute Sum$")
    public void clicks_on_Compute_Sum() {
	hp.clickComputeSum();
    }

    @Then("^user sees computed sum as \"([^\"]*)\"$")
    public void user_sees_computed_sum_as(String arg1) {
	hp.verifyResult(arg1);
    }
}
