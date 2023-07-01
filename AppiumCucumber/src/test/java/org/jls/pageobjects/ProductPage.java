package org.jls.pageobjects;

import java.util.List;

import org.jls.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductPage extends AndroidActions{
	
	AndroidDriver driver;

	public ProductPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(xpath= "//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> addtoCart;
	
	@AndroidFindBy(id= "com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cart;
	
	public void addtoItemCartbyIndex(int index) {
		addtoCart.get(index).click();
	}
	
	public CartPage gotoCartPage() throws InterruptedException {
		cart.click();
		Thread.sleep(5000);
		return new CartPage(driver);
	}

	
//	driver.findElement(By.id("")).click();
}
