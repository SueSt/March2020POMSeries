package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.DealsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utils.Constants;

public class DealsPageTest extends BaseTest {
	HomePage homePage;
	DealsPage dealsPage;
	
	
	@BeforeClass
	public void ContactsSetUp() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		dealsPage= homePage.goToDealsPage();
	}
	
	@Test(priority=1)
	public void verifyDealsPageTitleTest() {
		String title= dealsPage.getDealsPageTitle();
		System.out.println("Deals Page title is : "+ title);
		Assert.assertEquals(title, Constants.DEALS_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifyDealsPageHeaderTest() {
		String headertext= dealsPage.getDealsPageHeader();
		System.out.println("Deals Page Header is: "+headertext);
		Assert.assertEquals(headertext, Constants.DEALS_PAGE_HEADER);
	}
	
	@Test(priority=3)
	public void CreateDealTest() {
		dealsPage.CreateDeal("Purchase", "Presentation Scheduled", "350,000", "New Business");
	}
	
	
	
	
	
	
	
	
}
