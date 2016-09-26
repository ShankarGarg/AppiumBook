package com.cucumber.automation.stepdefinition;

import java.net.MalformedURLException;

import com.cucumber.automation.utils.AppiumBase;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
    
    AppiumBase appiumBase = new AppiumBase();
    
    @Before
    public void beforeHookfunction() throws MalformedURLException, InterruptedException{
	appiumBase.createDriver();
    }
 
    @After
    public void afterHookfunction() {
	appiumBase.teardown();
    }

}
