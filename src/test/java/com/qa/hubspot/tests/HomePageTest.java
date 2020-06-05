package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utils.Constants;

public class HomePageTest extends BaseTest {

	HomePage homePage;

	@BeforeClass
	public void homeSetUp()  {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String title = homePage.getHomePageTitle();
		System.out.println("Home Page Title is: " + title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE, "Home Page title is not mached");
	}

	@Test(priority = 2)
	public void verifyHomePageHeaderTest() {
		String header = homePage.getHomePageHeaderText();
		System.out.println("Home Page Header is: " + header);
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER, "Home Page header is not present");
	}

	@Test(priority = 3)
	public void verifyAcctmenuAvatarTest() {
	Assert.assertTrue(homePage.verifyAcctmenuAvatar());
		
	}

	@Test(priority = 4)
	public void verifyLogoTest() {
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.verifyLogo());
		

	}

}
