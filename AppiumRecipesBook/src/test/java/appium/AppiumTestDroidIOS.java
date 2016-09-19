package appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.HideKeyboardStrategy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppiumTestDroidIOS {

  //Ch.7-R.2
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
	//Declaring WebDriver variables
	AppiumDriver driver;
	WebDriverWait wait;

	// setting capabilities
	DesiredCapabilities capabilities = new DesiredCapabilities();
	
        capabilities.setCapability("deviceName", "iOS Phone");
        capabilities.setCapability("testdroid_target", "ios");
        capabilities.setCapability("testdroid_apiKey", "i8SVGxIbnKcolqSPfTMd694g6W8Lb9g4");
        capabilities.setCapability("testdroid_project", "AppiumBookIOS");
        capabilities.setCapability("testdroid_testrun", "Appium Run 2");

	// See available devices at: https://cloud.testdroid.com/#public/devices
        capabilities.setCapability("testdroid_device", "iPhone 5c 7.0.4 A1532"); 
        capabilities.setCapability("testdroid_app", "a88d0b87-af68-4261-943a-ba3bf1722bd2/BitbarIOSSample1.ipa");
	
	// initializing driver object - Grid Node
	driver = new IOSDriver(new URL("http://appium.testdroid.com/wd/hub"), capabilities);

	// initializing waits
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	wait = new WebDriverWait(driver, 10);

	wait.until(ExpectedConditions.elementToBeClickable(By.name("answer1")));
	driver.findElement(By.name("answer1")).click();
        driver.findElement(By.name("userName")).click();
        driver.findElement(By.name("userName")).sendKeys("Testdroid");
        driver.findElement(By.name("Return")).click();
        driver.findElement(By.name("sendAnswer")).click();

       	// close driver
	driver.quit();

    }
}
