package com.cucumber.automation.utils;

import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppiumBase {

    public static WebDriver driver;
    public static WebDriverWait waitVar;

    public void createDriver() throws MalformedURLException, InterruptedException {

	// setting capabilities
	DesiredCapabilities caps = new DesiredCapabilities();
	caps.setCapability("platform", "iOS");
	caps.setCapability("platformVersion", "9.2");
	caps.setCapability("deviceName", "iPhone 6");

	// relative path to .app file
	final File classpathRoot = new File(System.getProperty("user.dir"));
	final File appDir = new File(classpathRoot, "src/test/resources/apps/");
	final File app = new File(appDir, "TestApp.app");
	caps.setCapability("app", app.getAbsolutePath());

	// initializing driver object
	driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

	// initializing waits
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	waitVar = new WebDriverWait(driver, 10);
    }

    public void teardown() {
	// close the app
	driver.quit();
    }
}
