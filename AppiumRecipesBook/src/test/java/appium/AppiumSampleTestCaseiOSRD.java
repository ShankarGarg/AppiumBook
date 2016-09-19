package appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppiumSampleTestCaseiOSRD {

    //Start - Ch.3-R.4
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
	//Declaring WebDriver variables
	WebDriver driver;
	WebDriverWait wait;

	// setting capabilities
	DesiredCapabilities caps = new DesiredCapabilities();
	caps.setCapability("platform", "iOS");
	caps.setCapability("platformVersion", "9.3.4");
	caps.setCapability("deviceName", "iPhone 6");
	caps.setCapability("udid", "46ba868066b970c7c6fe86bfe9d97c63abfeb363");

	// relative path to .app file
	final File classpathRoot = new File(System.getProperty("user.dir"));
	final File appDir = new File(classpathRoot, "src/test/resources/apps/");
	final File app = new File(appDir, "TestApp.app");
	caps.setCapability("app", app.getAbsolutePath());

	// initializing driver object
	driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

	// initializing waits
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	wait = new WebDriverWait(driver, 10);

	// Test Steps
	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.IosUIAutomation(".textFields()[0]")));
	driver.findElement(MobileBy.IosUIAutomation(".textFields()[0]")).sendKeys("1");

	// enter data in second text box
	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.IosUIAutomation(".textFields()[1]")));
	driver.findElement(MobileBy.IosUIAutomation(".textFields()[1]")).sendKeys("2");

	driver.findElement(MobileBy.IosUIAutomation(".buttons().firstWithPredicate(\"name=='ComputeSumButton'\")")).click();

	System.out.println(driver.findElement(MobileBy.IosUIAutomation(".staticTexts().firstWithPredicate(\"name=='Answer'\")")).getText());
	
	// close driver
	driver.quit();

    }
	//End - Ch.3-R.4
}
