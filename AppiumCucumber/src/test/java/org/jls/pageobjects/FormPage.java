package org.jls.pageobjects;

import org.jls.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions{

	AndroidDriver driver;

	public FormPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	// driver.findElement(By.id()).sendKeys("LogeshJls");
	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement nameField;

	//driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
	@AndroidFindBy(id= "com.androidsample.generalstore:id/radioMale")
	private WebElement maleOption;

	@AndroidFindBy(id= "com.androidsample.generalstore:id/radioFemale")
	private WebElement femaleOption;

	//driver.findElement(By.id("")).click();
	@AndroidFindBy(id= "android:id/text1")
	private WebElement countrySelector;

	@AndroidFindBy(id= "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;

	public void setNameField(String userName)
	{
		nameField.sendKeys(userName);
		driver.hideKeyboard();
	}

	public void setGender(String Gender)
	{
		if(Gender.contains("Male"))
			maleOption.click();
		else
			femaleOption.click();
	}

	public void setCountrySelector(String countryName)
	{
		countrySelector.click();
		scrollDown(countryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
	}

	public ProductPage submitForm()
	{
		shopButton.click();
		return new ProductPage(driver);
	}
}
