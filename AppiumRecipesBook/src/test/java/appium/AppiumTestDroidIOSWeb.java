package appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppiumTestDroidIOSWeb {

    //Ch.7-R.2
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
	// Declaring WebDriver variables
	AppiumDriver driver;
	WebDriverWait wait;

	// setting capabilities
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability("deviceName", "iOS Phone");
	capabilities.setCapability("testdroid_target", "safari");
	capabilities.setCapability("testdroid_apiKey", "i8SVGxIbnKcolqSPfTMd694g6W8Lb9g4");
	capabilities.setCapability("testdroid_project", "AppiumBookIOS");
	capabilities.setCapability("testdroid_testrun", "Appium Run 3");
	capabilities.setCapability("testdroid_device", "iPhone 5c 7.0.4 A1532");
	capabilities.setCapability("browserName", "safari");

	// initializing driver object - TestDroid
	driver = new IOSDriver(new URL("http://appium.testdroid.com/wd/hub"), capabilities);

	// initializing waits
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	wait = new WebDriverWait(driver, 10);

	// open github URL
	driver.get("https://github.com/");

	// click Signup
	wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Sign up for GitHub")));
	driver.findElement(By.linkText("Sign up for GitHub")).click();

	// click Create Account
	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("signup_button")));
	driver.findElement(MobileBy.id("signup_button")).click();
	// close driver
	driver.quit();

    }
}
