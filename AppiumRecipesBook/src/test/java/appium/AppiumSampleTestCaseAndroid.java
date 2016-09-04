package appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppiumSampleTestCaseAndroid {

    //Start - Ch.3-R.1 & Ch.3-R.4
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
	//Declaring WebDriver variables
	WebDriver driver;
	WebDriverWait wait;

	// setting capabilities
	DesiredCapabilities caps = new DesiredCapabilities();
	caps.setCapability("platform", "ANDROID");
	caps.setCapability("platformVersion", "5.0");
	caps.setCapability("deviceName", "ANDROID");
	caps.setCapability("browserName", "");

	// relative path to apk file
	final File classpathRoot = new File(System.getProperty("user.dir"));
	final File appDir = new File(classpathRoot, "src/test/resources/apps/");
	final File app = new File(appDir, "ApiDemos-debug.apk");
	caps.setCapability("app", app.getAbsolutePath());

	// initializing driver object
	driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	
	//initializing  waits
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	wait = new WebDriverWait(driver, 10);

	// Test Steps
	/*
	// Start - Ch.2-R.3
	// click on Accessibility link
	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Accessibility")));
	driver.findElement(MobileBy.AccessibilityId("Accessibility")).click();

	// click on 'Accessibility Node Querying' link
	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Accessibility Node Querying")));
	driver.findElement(MobileBy.AccessibilityId("Accessibility Node Querying")).click();
	// End - Ch.2-R.3
	*/
	
	// Start - Ch.2-R.5
	//using classname and index
	driver.findElement(MobileBy.AndroidUIAutomator("className(\"android.widget.TextView\").index(2)")).click();
	//using text filter
	driver.findElement(MobileBy.AndroidUIAutomator("text(\"Alarm\")")).click();
	
	driver.navigate().back();
	driver.navigate().back();
	
	//using content-desc
	driver.findElement(MobileBy.AndroidUIAutomator("description(\"Accessibility\")")).click();
	// End - Ch.2-R.5
	
	//close driver
	driver.quit();

    }
	//End - Ch.3-R.1 & Ch.3-R.4
}
