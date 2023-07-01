package com.baseclass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.jls.pageobjects.FormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {

	public static AndroidDriver driver;
	public static AppiumDriverLocalService service;
	public static FormPage formPage;

	public static void configureAppium() throws MalformedURLException {
		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\loges\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("JLSEmulator");
		options.setChromedriverExecutable("C:\\Users\\loges\\eclipse-workspace\\Jlsappium\\Drivers\\chromedriver.exe");
		//options.setApp("C:\\Users\\loges\\eclipse-workspace\\Jlsappium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		options.setApp("C:\\Users\\loges\\eclipse-workspace\\Jlsappium\\src\\test\\java\\resources\\General-Store.apk");

		//		options.setCapability("appPackage", "io.appium.android.apis");
		//
		//		options.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		formPage = new FormPage(driver);
	}

	public static void longPress(WebElement peopleNamesEle) {

		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement) peopleNamesEle).getId(),"duration",2000));
	}

	public static void Scroll() {
		boolean canScrollMore;
		do
		{
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
					"left", 100, "top", 100, "width", 200, "height", 200,
					"direction", "down",
					"percent", 5.0));
			//	tearDown();
		}while(canScrollMore);
	}

	public static void swipe(WebElement image1, String direction) {

		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) image1).getId(),
				"direction", direction,
				"percent", 0.75
				));
	}
	public static void DragandDrop(WebElement dragandDropElement) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) dragandDropElement).getId(),
				"endX", 832,
				"endY", 823
				));
	}
	public static void scrollDown(String scrollElement) {
		driver.findElement(	
				new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
						+ ".scrollIntoView(new UiSelector()" + ".textMatches(\"" + scrollElement + "\").instance(0))"));
	}
	public static double getFormattedAmount(String amout) {
		double price = Double.parseDouble((amout).substring(1));
		return price;
	}
	
	public  void tearDown() {

		driver.quit();
		service.stop();
	}
}
