package appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppiumSampleTestCaseiOSWeb {

    //Start - Ch.3-R.2
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
	//Declaring WebDriver variables
	WebDriver driver;
	WebDriverWait wait;

	// setting capabilities
	DesiredCapabilities caps = new DesiredCapabilities();
	caps.setCapability("platform", "iOS");
	caps.setCapability("platformVersion", "9.2");
	caps.setCapability("deviceName", "iPhone 6");
	caps.setCapability("browserName", "safari");

	// initializing driver object - Local
	driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	
	//Ch.6-R.2
	// initializing driver object - Grid Node
	//driver = new IOSDriver(new URL("http://192.168.56.1:4444/wd/hub"), caps);

	// initializing waits
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	wait = new WebDriverWait(driver, 10);

	//open github URL
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
	//End - Ch.3-R.2
}
