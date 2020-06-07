package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage extends BasePage {

	private WebDriver driver;

	// 1. Create By Locators(OR)
	By username = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");

	// 2.Create a constructor for the page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	// 3.Create the page actions
	@Step("get login Page Title....")// this annotation for Allure reports
	public String getloginPageTitle() {
		//using the reusable methods in the Elementutil class
		return elementUtil.waitForTitleToBePresent(Constants.LOGIN_PAGE_TITLE, 10);
	}

	@Step("verify Sign Up Link...")// this annotation for Allure reports
	public boolean verifySignUpLink() {
		return elementUtil.doIsDisplayed(signUpLink);
	}
	
	@Step("login to app with username: {0} and password: {1}...")// this annotation for Allure reports
	public HomePage doLogin(String username, String password) {
		elementUtil.waitForElementToBeVisible(this.username, 10);
		elementUtil.doSendKeys(this.username, username);
		elementUtil.doSendKeys(this.password, password);
		elementUtil.doClick(this.loginButton);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new HomePage(driver);
	}

}
