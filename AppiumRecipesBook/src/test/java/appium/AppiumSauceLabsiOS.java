package appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppiumSauceLabsiOS {

  //Ch.7-R.1
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
	//Declaring WebDriver variables
	IOSDriver driver;
	WebDriverWait wait;

	// setting capabilities
	DesiredCapabilities caps = new DesiredCapabilities();
	caps.setCapability("appiumVersion", "1.5.3");
	caps.setCapability("deviceName","iPhone 6");
	caps.setCapability("platformVersion","9.2");
	caps.setCapability("platformName", "iOS");
	caps.setCapability("browserName", "");
	caps.setCapability("app","sauce-storage:TestApp.zip");
	
	// initializing driver object - Sauce Labs
	driver =  new IOSDriver(new URL("http://shankargarg1986:14cd9f97-5ee8-4016-8974-fe6360643818@ondemand.saucelabs.com:80/wd/hub"), caps);

	// initializing waits
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	wait = new WebDriverWait(driver, 10);

	
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

       	// close driver
	driver.quit();

    }
}
