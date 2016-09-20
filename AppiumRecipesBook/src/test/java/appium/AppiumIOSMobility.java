package appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.Connection;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppiumIOSMobility {

    // Declaring WebDriver variables
    static IOSDriver<IOSElement> driver;
    static WebDriverWait wait;

    static DesiredCapabilities caps = new DesiredCapabilities();

    public static void main(String[] args) throws InterruptedException, IOException {

	new AppiumIOSMobility().settingCapsAndDriver();

	// new AppiumIOSMobility().taponElement();
	new AppiumIOSMobility().swipeiOS();
	// new AppiumIOSMobility().changeOrientation();
	// new AppiumIOSMobility().appLaunch();

	new AppiumIOSMobility().closeDriver();

    }

    public void settingCapsAndDriver() throws MalformedURLException {
	// setting capabilities
	caps.setCapability("platform", "iOS");
	caps.setCapability("platformVersion", "9.2");
	caps.setCapability("deviceName", "iPhone 6");

	// relative path to .app file
	final File classpathRoot = new File(System.getProperty("user.dir"));
	final File appDir = new File(classpathRoot, "src/test/resources/apps/");
	final File app = new File(appDir, "TestApp.app");
	caps.setCapability("app", app.getAbsolutePath());

	// initializing driver object
	driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

	// initializing waits
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	wait = new WebDriverWait(driver, 20);
    }

    public void closeDriver() {
	// close driver
	driver.quit();
    }

    public void taponElement() throws InterruptedException {
	// Start - Ch.4-R.1
	// Tap
	Point point = driver.findElementById("io.appium.android.apis:id/button_toggle").getLocation();
	driver.tap(1, point.x + 20, point.y + 30, 1000);

	System.out.println(driver.findElementById("io.appium.android.apis:id/button_toggle").getText());
	// End - Ch.4-R.1
    }

    public void swipeiOS() {
	// Start - Ch.4-R.3
	// Horizontal Swipe
	MobileElement slider = driver.findElementByClassName("UIASlider");

	// Scroll left
	slider.swipe(SwipeElementDirection.LEFT, slider.getSize().getWidth() / 2, 0, 3000);
	System.out.println(slider.getAttribute("value"));

	// Scroll Right
	slider.swipe(SwipeElementDirection.RIGHT, 2, 0, 3000);
	System.out.println(slider.getAttribute("value"));
	// End - Ch.4-R.3
    }

    public void changeOrientation() throws InterruptedException {
	// Start - Ch.4-R.4
	System.out.println(driver.getOrientation());
	driver.rotate(ScreenOrientation.LANDSCAPE);
	Thread.sleep(2000);
	System.out.println(driver.getOrientation());
	driver.rotate(ScreenOrientation.PORTRAIT);
	Thread.sleep(2000);
	// End - Ch.4-R.4
    }

    public void appLaunch() {
	// Start - Ch.4-R.5
	// App launch and Close
	// close the app
	driver.closeApp();

	// launch the app again
	driver.launchApp();
	// End - Ch.4-R.5
    }
}
