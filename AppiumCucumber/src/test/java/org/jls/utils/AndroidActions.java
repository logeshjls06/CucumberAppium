package org.jls.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions {
	
	AndroidDriver driver;
	public AndroidActions (AndroidDriver driver)
	{
		this.driver= driver;
	}
	
	public void longPress(WebElement peopleNamesEle) {

		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement) peopleNamesEle).getId(),"duration",2000));
	}

	public void Scroll() {
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

	public void swipe(WebElement image1, String direction) {

		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) image1).getId(),
				"direction", direction,
				"percent", 0.75
				));
	}
	public void DragandDrop(WebElement dragandDropElement) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) dragandDropElement).getId(),
				"endX", 832,
				"endY", 823
				));
	}
	public void scrollDown(String countryName) {
		driver.findElement(	
				new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
						+ ".scrollIntoView(new UiSelector()" + ".textMatches(\"" + countryName + "\").instance(0))"));
	}
	
	public double getFormattedAmount(String amout) {
		double price = Double.parseDouble((amout).substring(1));
		return price;
	}



}
