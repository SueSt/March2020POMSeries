package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.listeners.ExtentReportListener;
import com.qa.hubspot.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


//@Listeners(ExtentReportListener.class) ( It is used here just for debug+
//purpose and if I want to see the report when I run the test case from here not from the .xml file)

@Epic("Epic - 101: design login page with different features....")//this annotation for Allure reports
@Story("US - 102: design basic login page with signup, title and login form....")//this annotation for Allure reports
public class LoginPageTest extends BaseTest{
	
	@Test(priority=2)
	@Description("verify login Page Title Test .....")// this annotation for Allure reports
	@Severity(SeverityLevel.NORMAL)// this annotation for Allure reports
	public void verifyloginPageTitleTest () {
		String title=loginPage.getloginPageTitle();
		System.out.println("login page title is : " +title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "login page title is not matched...");
	}
	
	
	@Test(priority=1)
	@Description("verify Sig Up ink Test .....")// this annotation for Allure reports
	@Severity(SeverityLevel.CRITICAL)// this annotation for Allure reports
	public void verifySignUplinkTest() {
		Assert.assertTrue(loginPage.verifySignUpLink(), "sign up link is not displayed...");
	}
	
	@Test(priority=3)
	@Description("login Test .....") // this annotation for Allure reports
	@Severity(SeverityLevel.BLOCKER)// this annotation for Allure reports
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	


}
