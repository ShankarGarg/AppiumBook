package com.cucumber.automation.stepDefinition;

import java.net.MalformedURLException;

import com.cucumber.automation.utils.AppiumBase;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
    
    AppiumBase ab = new AppiumBase();
    
    @Before
    public void beforeHookfunction() throws MalformedURLException, InterruptedException{
        ab.createDriver();
    }
 
    @After
    public void afterHookfunction() {
        ab.teardown();
    }

}
