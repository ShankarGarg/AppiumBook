package appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppiumSauceLabsAndroid {

  //Ch.7-R.1
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
	
	//Declaring WebDriver variables
	AndroidDriver driver;
	WebDriverWait wait;

	// setting capabilities
	DesiredCapabilities caps = new DesiredCapabilities();
	caps.setCapability("platformName", "ANDROID");
	caps.setCapability("platformVersion", "4.4");
	caps.setCapability("deviceName", "Samsung Galaxy Nexus Emulator");
	caps.setCapability("browserName", "");
	caps.setCapability("appiumVersion", "1.5.3");
	caps.setCapability("app","sauce-storage:ApiDemos-debug.apk");
	
	// initializing driver object - Sauce Labs
	driver = new AndroidDriver(new URL("http://shankargarg1986:14cd9f97-5ee8-4016-8974-fe6360643818@ondemand.saucelabs.com:80/wd/hub"), caps);
	
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
	
	//using content-desc
	driver.findElement(MobileBy.AndroidUIAutomator("description(\"Accessibility\")")).click();
	
	//close driver
	driver.quit();

    }
}
