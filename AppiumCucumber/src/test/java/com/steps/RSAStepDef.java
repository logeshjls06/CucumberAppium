package com.steps;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.jls.pageobjects.ProductPage;

import com.baseclass.BaseClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class RSAStepDef extends BaseClass {
	public static AndroidDriver driver;
	public static AppiumDriverLocalService service;
	
	@Given("Open the RSA App")
	public void open_the_rsa_app() throws MalformedURLException {
		
		configureAppium();
	}

	@When("User should enter the {string}, {string},{string}")
	public void user_should_enter_the(String Country, String UserName, String Gender) {
		
		formPage.setNameField(UserName);
		formPage.setGender(Gender);
		formPage.setCountrySelector(Country);
		
	}

	@Then("User should enter into Login Page")
	public void user_should_enter_into_login_page() {
		ProductPage productpage= formPage.submitForm();
		
	}

}
