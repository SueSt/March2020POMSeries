package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class LoginPage extends BasePage{

	private WebDriver driver;
	
//1. Create By Locators(OR)
	By username= By.id("username");
	By password= By.id("password");
	By loginButton= By.id("loginBtn");
	By signUpLink= By.linkText("Sign up");
	
//2.Create a constructor for the page class
	public LoginPage(WebDriver driver) {
		this.driver= driver;
	}
	
//3.Create the page actions
	public String getloginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifySignUpLink() {
		return driver.findElement(signUpLink).isDisplayed();
	}
	
	public HomePage doLogin(String username, String password) throws InterruptedException {
		driver.findElement(this.username).sendKeys(username);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(loginButton).click();
		Thread.sleep(5000);
		
		return new HomePage(driver);
	}
	

	
}
