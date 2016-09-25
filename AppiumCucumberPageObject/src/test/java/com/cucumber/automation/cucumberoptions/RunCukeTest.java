package com.cucumber.automation.cucumberoptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
    
    @RunWith(Cucumber.class)
    @CucumberOptions(
    		
    		features = "src/test/java/com/cucumber/automation/features",
    		glue = "com.cucumber.automation.stepDefinition",
    		plugin = { 
    					"pretty",
    					"html:target/cucumber",
    				} 
    		)
    public class RunCukeTest {
}



