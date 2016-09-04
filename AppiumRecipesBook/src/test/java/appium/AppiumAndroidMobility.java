package appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.Connection;

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

public class AppiumAndroidMobility {


 	
    public static void main(String[] args) throws InterruptedException, IOException {
    	
	// Declaring WebDriver variables
 	AndroidDriver<AndroidElement> driver;
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
	driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

	// initializing waits
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	wait = new WebDriverWait(driver, 10);

	/*
	//Start - Ch.4-R.1
	//Tap
	//driver.startActivity("io.appium.android.apis", ".view.Buttons1");
	driver.findElement(MobileBy.AccessibilityId("Views")).click();
	driver.findElement(MobileBy.AccessibilityId("Buttons")).click();
	
	//Point point = driver.findElementById("io.appium.android.apis:id/button_toggle").getLocation();
	//driver.tap(1, point.x + 20, point.y + 30, 1000);
	driver.tap(1, driver.findElementById("io.appium.android.apis:id/button_toggle"), 1000);
	System.out.println(driver.findElementById("io.appium.android.apis:id/button_toggle").getText());
	//End - Ch.4-R.1
	*/
	
	
	
	/*
	//Start - Ch.4-R.2
	//Drag and Drop
	//Open an activity directly
	driver.startActivity("io.appium.android.apis", ".view.DragAndDropDemo");
        
	WebElement dragDot1 = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        WebElement dragDot3 = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_3"));

        //this text should be empty before Drag-Drop
        WebElement dragText = driver.findElement(By.id("io.appium.android.apis:id/drag_text"));
        System.out.println(dragText.getText());

        //perform Drag and Drop
        TouchAction dragNDrop =
            new TouchAction(driver).longPress(dragDot1).moveTo(dragDot3).release().perform();
       
        //Text representing Drag-Drop is successful
        System.out.println((dragText.getText()));
        //End - Ch.4-R.2
        */
	
	/*
	//Start - Ch.4-R.3
	//vertical swipe
	driver.findElementByAccessibilityId("Views").click();
        AndroidElement listView = driver.findElementByClassName("android.widget.ListView");
        MobileElement textView = driver.findElementById("android:id/text1");

        String originalText = textView.getText();

        listView.swipe(SwipeElementDirection.UP, 20, 15, 1000);
        System.out.println( textView.getText());

        listView.swipe(SwipeElementDirection.DOWN, 20, 15, 1000);
        System.out.println( textView.getText());*/
	
	/*
	//horizontal swipe
	//driver.startActivity("io.appium.android.apis", ".view.Gallery1");
	driver.findElementByAccessibilityId("Views").click();
	driver.findElementByAccessibilityId("Gallery").click();
	driver.findElementByAccessibilityId("1. Photos").click();


        AndroidElement gallery = driver.findElementById("io.appium.android.apis:id/gallery");
        int originalImageCount = gallery
            .findElementsByClassName("android.widget.ImageView").size();

        gallery.swipe(SwipeElementDirection.LEFT, 5, 5, 2000);
        System.out.println(gallery
            .findElementsByClassName("android.widget.ImageView").size());

        gallery.swipe(SwipeElementDirection.RIGHT, 5, 5, 2000);
        System.out.println( gallery
            .findElementsByClassName("android.widget.ImageView").size());
        //End - Ch.4-R.3
        */
	
	/*
	//Start - Ch.4-R.4
	//Orientation
	//print current orientation
	System.out.println( driver.getOrientation());
	//change orientation to LANDSCAPE
        driver.rotate(ScreenOrientation.LANDSCAPE);
                
        //print current orientation
        System.out.println(driver.getOrientation());
      	//change orientation to PORTRAIT
        driver.rotate(ScreenOrientation.PORTRAIT); 
        //End - Ch.4-R.4
        */
	
	/*
	//Start - Ch.4-R.5
	//App launch and Close

	//confirm if app is launched: - activity name should be from app
	System.out.println("Current Activity before Close: "+driver.currentActivity());
	//close the app
	driver.closeApp();

	//launch the app again
	driver.launchApp();
	//confirm if app is launched again: - activity name should be from app
	System.out.println("Current Activity after launch: "+driver.currentActivity());
	
	//App Installation
	//check if app is installed
	System.out.println("app installed before remove: "+driver.isAppInstalled("io.appium.android.apis"));
	//remove app
	driver.removeApp("io.appium.android.apis");
	//check app is not installed now
	System.out.println("app installed after remove: "+driver.isAppInstalled("io.appium.android.apis"));
	
	//install app again
	driver.installApp(app.getAbsolutePath());
	//check if app is installed back
	System.out.println("app installed after install: "+driver.isAppInstalled("io.appium.android.apis"));
	//End - Ch.4-R.5
	*/
	
	/*
	//Start - Ch.4-R.6
	//lock device:
	driver.lockDevice();
        System.out.println("After lock is device locked: "+driver.isLocked());
        
        
        driver.unlockDevice();
        System.out.println("After unlock is device locked: "+driver.isLocked());
        //End - Ch.4-R.6
        */
	
	/*
	//Start - Ch.4-R.7
	//Network
	driver.setConnection(Connection.ALL);
	System.out.println(driver.getConnection());
	
	driver.setConnection(Connection.AIRPLANE);
	System.out.println(driver.getConnection());
	
	driver.setConnection(Connection.NONE);
	System.out.println(driver.getConnection());
	
	driver.setConnection(Connection.WIFI);
	System.out.println(driver.getConnection());
	//End - Ch.4-R.7
	*/
	
	// This code is not used in book but would be helpful to readers to experiment on their own
	/*
	//Long Press?
	driver.startActivity("io.appium.android.apis", ".view.Buttons1");
	TouchAction action = new TouchAction(driver);
	action.longPress(driver.findElementById("io.appium.android.apis:id/button_toggle")).release().perform();*/
	
	/*
	//Pinch and Zoom
	 driver.startActivity("io.appium.android.apis", ".ApiDemos");
	 MobileElement e = driver.findElement(MobileBy.AccessibilityId("App"));
	 Thread.sleep(2000);
	 e.zoom();
	 Thread.sleep(2000);
	 e.pinch();
	*/
	
	/*
	//open Notification:
	driver.openNotifications();
        System.out.println(driver
                .findElementsById("com.android.systemui:id/carrier_label").size());*/
	
	/*//Screenshot
	File location=new File("screenshots");
	String screenShotName = location.getAbsolutePath()+File.separator+ "SampleScreenshot"+".png";
	
	FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE),new File(screenShotName));
	*/	
	
	/*//KeyCode
	driver.pressKeyCode(AndroidKeyCode.HOME);
	
	driver.launchApp();
	driver.longPressKeyCode(AndroidKeyCode.HOME);
	 //driver.longPressKeyCode(AndroidKeyCode.HOME, AndroidKeyMetastate.META_SHIFT_ON);
	*/

	// close driver
	driver.quit();

    }

}
