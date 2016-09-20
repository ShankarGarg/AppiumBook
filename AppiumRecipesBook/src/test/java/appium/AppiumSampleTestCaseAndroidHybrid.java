package appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppiumSampleTestCaseAndroidHybrid {

    //Start - Ch.3-R.3
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
	// Declaring WebDriver variables
	AndroidDriver<WebElement> driver;
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
	final File app = new File(appDir, "selendroid-test-app.apk");
	caps.setCapability("app", app.getAbsolutePath());

	// initializing driver object
	driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

	// initializing waits
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	wait = new WebDriverWait(driver, 10);

	// Test Steps
	// click on Chrome icon to start web view
	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("io.selendroid.testapp:id/buttonStartWebview")));
	driver.findElement(MobileBy.id("io.selendroid.testapp:id/buttonStartWebview")).click();

	//Get all Contexts
	Set<String> contexts = driver.getContextHandles();
	for (String context : contexts) {
	    
	    //print Context name
	    System.out.println(context);
	    
	    if (context.contains("WEB")) {
		//switch to context containing web its name
		driver.context(context);
	    }
	}

	final WebElement inputField = driver.findElement(By.id("name_input"));
	inputField.sendKeys("Appium");
	inputField.submit();

	// close driver
	driver.quit();

    }
	//End - Ch.3-R.3
}
