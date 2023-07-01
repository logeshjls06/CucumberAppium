package org.jls.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

public class AppiumUtils {
	
	AppiumDriver driver;
	
	public AppiumUtils(AppiumDriver driver) {
		this.driver= driver;
	}
	
	public void waitforElementtoAppear(WebElement ele) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains((ele),"text", "Cart"));

	}

}
