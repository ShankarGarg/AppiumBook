package appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppiumTestDroidAndroid {

  //Ch.7-R.2
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
	//Declaring WebDriver variables
	AppiumDriver driver;
	WebDriverWait wait;

	// setting capabilities
	DesiredCapabilities capabilities = new DesiredCapabilities();
        
        capabilities.setCapability("deviceName", "AndroidDevice");
        capabilities.setCapability("testdroid_target", "Android");
        capabilities.setCapability("testdroid_apiKey", "i8SVGxIbnKcolqSPfTMd694g6W8Lb9g4");
        capabilities.setCapability("testdroid_project", "AppiumBook");
        capabilities.setCapability("testdroid_testrun", "Android Run 1");
        
        // See available devices at: https://cloud.testdroid.com/#public/devices
        capabilities.setCapability("testdroid_device", "LG Google Nexus 5 6.0.1 -US"); 
        capabilities.setCapability("testdroid_app", "af9de10f-cddf-4cae-a494-4c86a53e7552/ApiDemos-debug.apk");
	
	// initializing driver object - TestDroid
	driver = new AndroidDriver(new URL("http://appium.testdroid.com/wd/hub"), capabilities);
	
	//initializing  waits
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	wait = new WebDriverWait(driver, 10);

	// click on 'Accessibility' link
	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Accessibility")));
	driver.findElement(MobileBy.AccessibilityId("Accessibility")).click();

	// click on 'Accessibility Node Querying' link
	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Accessibility Node Querying")));
	driver.findElement(MobileBy.AccessibilityId("Accessibility Node Querying")).click();	
	
	driver.navigate().back();
	driver.navigate().back();
	
	//close driver
	driver.quit();

    }
}
