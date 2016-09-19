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

public class AppiumSampleTestCaseiOS {

    //Start - Ch.3-R.1
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
	//Declaring WebDriver variables
	IOSDriver<WebElement> driver;
	WebDriverWait wait;

	// setting capabilities
	DesiredCapabilities caps = new DesiredCapabilities();
	caps.setCapability("platform", "iOS");
	caps.setCapability("platformVersion", "9.2");
	caps.setCapability("deviceName", "iPhone 6");

	// relative path to .app file
	final File classpathRoot = new File(System.getProperty("user.dir"));
	final File appDir = new File(classpathRoot, "src/test/resources/apps/");
	final File app = new File(appDir, "TestApp.app");
	caps.setCapability("app", app.getAbsolutePath());

	// initializing driver object - Local
	driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	
	//Ch.6-R.2
	// initializing driver object - Grid Node
	//driver =  new IOSDriver<WebElement>(new URL("http://192.168.56.1:4444/wd/hub"), caps);

	// initializing waits
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	wait = new WebDriverWait(driver, 10);

	// Test Steps
	/*
	//Start - Ch.2-R.3
	//enter data in first text box
	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("TextField1")));
	driver.findElement(MobileBy.AccessibilityId("TextField1")).sendKeys("AppiumBook");
	
	//enter data in second text box
	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("TextField2")));
	driver.findElement(MobileBy.AccessibilityId("TextField2")).sendKeys("First TC");
	//End - Ch.2-R.3
	 */

	//Start - Ch.2-R.4
	//enter data in first text box
	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.IosUIAutomation(".textFields()[0]")));
	driver.findElement(MobileBy.IosUIAutomation(".textFields()[0]")).sendKeys("1");

	// enter data in second text box
	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.IosUIAutomation(".textFields()[1]")));
	driver.findElement(MobileBy.IosUIAutomation(".textFields()[1]")).sendKeys("2");

	// click on compute Sum Button
	driver.findElement(MobileBy.IosUIAutomation(".buttons().firstWithPredicate(\"name=='ComputeSumButton'\")")).click();
	
	// print value of ‘???’ label
	System.out.println(driver.findElement(MobileBy.IosUIAutomation(".staticTexts().firstWithPredicate(\"name=='Answer'\")")).getText());
	//End - Ch.2-R.4

       	// close driver
	driver.quit();

    }
	//End - Ch.3-R.1
}
