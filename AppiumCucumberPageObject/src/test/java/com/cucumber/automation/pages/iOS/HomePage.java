package com.cucumber.automation.pages.iOS;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import io.appium.java_client.MobileBy;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.cucumber.automation.utils.AppiumBase;

public class HomePage extends AppiumBase{

    
    // All the locators for Home page will be defined here
    By textField1 = MobileBy.AccessibilityId("TextField1");
    By textField2 = MobileBy.AccessibilityId("TextField2");
    By computeSum = MobileBy.AccessibilityId("ComputeSumButton");
    By result = MobileBy.AccessibilityId("Answer");
 
    
    // All the behavior of home page will be defined here in functions
    public void verifyHomePage(){
        waitVar.until(ExpectedConditions.presenceOfElementLocated(computeSum));
        assertTrue(driver.findElement(computeSum).isDisplayed());
    }
    
    public void typeTextField1(String text){
         waitVar.until(ExpectedConditions.presenceOfElementLocated(textField1));
         driver.findElement(textField1).sendKeys(text);
    }
    
    public void typeTextField2(String text){
         waitVar.until(ExpectedConditions.presenceOfElementLocated(textField2));
         driver.findElement(textField2).sendKeys(text);
    }
    
    public void clickComputeSum(){
         waitVar.until(ExpectedConditions.presenceOfElementLocated(computeSum));
         driver.findElement(computeSum).click();
    }
    
    public void verifyResult(String text){
         waitVar.until(ExpectedConditions.presenceOfElementLocated(result));
         assertEquals(text,driver.findElement(result).getText());
    }
}
