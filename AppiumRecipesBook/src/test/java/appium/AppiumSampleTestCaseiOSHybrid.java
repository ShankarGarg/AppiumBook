package appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppiumSampleTestCaseiOSHybrid {

    //Start - Ch.3-R.3
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
	//Declaring WebDriver variables
	WebDriver driver;
	WebDriverWait wait;

	// setting capabilities
	DesiredCapabilities caps = new DesiredCapabilities();
	caps.setCapability("platform", "iOS");
	caps.setCapability("platformVersion", "9.0");
	caps.setCapability("deviceName", "iPhone 6");

	// relative path to .app file
	final File classpathRoot = new File(System.getProperty("user.dir"));
	final File appDir = new File(classpathRoot, "src/test/resources/apps/");
	final File app = new File(appDir, "WebViewApp.app");
	caps.setCapability("app", app.getAbsolutePath());

	// initializing driver object
	driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

	// initializing waits
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	wait = new WebDriverWait(driver, 10);

	//Enter URL to open WebView
	driver.findElement(By.className("UIATextField")).clear();
	driver.findElement(By.className("UIATextField")).sendKeys("https://github.com/");
	driver.findElement(MobileBy.AccessibilityId("Go")).click();
	
	
	
	//switch context:
	final Set<String> contextNames = ((AppiumDriver) driver).getContextHandles();
	    for (final String contextName : contextNames) {
	      System.out.println(contextName);
	      if (contextName.contains("WEB")) {
		//switch to context containing web its name
	         ((AppiumDriver) driver).context(contextName);
	         System.out.println("context switched to webview");
	      }
	    }
	    
	// click Signup
	wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Sign up for GitHub")));
	driver.findElement(By.linkText("Sign up for GitHub")).click();

	// click Create Account
	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("signup_button")));
	driver.findElement(MobileBy.id("signup_button")).click();

	// close driver
	driver.quit();

    }
	//End - Ch.3-R.3
}
