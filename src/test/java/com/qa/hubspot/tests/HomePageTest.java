package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.Constants;

public class HomePageTest {

	WebDriver driver;
	Properties prop;
	
	BasePage basePage;
	HomePage homepage;
	LoginPage loginPage;
    HomePage homePage;
	
	
	@BeforeTest
	public void setUp() throws InterruptedException {
		basePage = new BasePage();
		prop= basePage.init_prop();
		driver= basePage.init_driver(prop);
		loginPage= new LoginPage(driver);
		homePage= loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 3)
	public void verifyHomePageTitleTest() {
		String title= homePage.getHomePageTitle();
		System.out.println("Home Page Title is: " +title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE, "Home Page title is not mached");
	}
	
	@Test(priority = 1)
	public void verifyHomePageHeaderTest() {
		String header= homePage.getHomePageHeaderText();
		System.out.println("Home Page Header is: " +header);
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER, "Home Page header is not present");
	}
	
//	@Test(priority = 2)
//	public void verifyLoggedInUserTest() {
//		String loggedInUser= homePage.getLoggedInUser();
//		System.out.println("Home Page loggedInUser is: " +loggedInUser);
//		Assert.assertEquals(loggedInUser, "Sue St", "Home Page loggedInUser is not matched");
//	}

	@Test(priority = 4)
	public void verifyLogoTest() {
		homepage = new HomePage(driver);
		Assert.assertTrue(homepage.verifyLogo(), "Logo dosen't exist");
	}


	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
