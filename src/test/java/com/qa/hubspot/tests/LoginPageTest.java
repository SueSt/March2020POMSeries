package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.listeners.ExtentReportListener;
import com.qa.hubspot.utils.Constants;


//@Listeners(ExtentReportListener.class) ( It is used here just for debug+
//purpose and if I want to see the report when I run the test case from here not from the .xml file)
public class LoginPageTest extends BaseTest{
	
	@Test(priority=2)
	public void verifyloginPageTitleTest () {
		String title=loginPage.getloginPageTitle();
		System.out.println("login page title is : " +title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "login page title is not matched...");
	}
	
	
	@Test(priority=1)
	public void verifySignUplinkTest() {
		Assert.assertTrue(loginPage.verifySignUpLink(), "sign up link is not displayed...");
	}
	
	@Test(priority=3)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	


}
