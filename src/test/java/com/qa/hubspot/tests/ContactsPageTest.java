package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ExcelUtil;

public class ContactsPageTest extends BaseTest {
	HomePage homePage;
	ContactsPage contactsPage;

	@BeforeClass
	public void ContactsSetUp() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage= homePage.goToContactsPage();
	}

	@Test(priority = 1)
	public void verifyContactsPagetitleTest() {
		String title = contactsPage.getContactsPageTitle();
		System.out.println("contacts page title is: " + title);
		Assert.assertEquals(title, Constants.CONTACTS_PAGE_TITLE, "Title dosen't match");
	}
	
	@DataProvider
	public Object[][] getContactsTestData() {
		Object[][] data =ExcelUtil.getTestData(Constants.CONTACT_SHEET_NAME);
		 return data;
	}
	

	@Test(priority = 2, dataProvider= "getContactsTestData" )
	public void createContactTest(String email, String firstName, String lastName, String jobTitle ) {
		contactsPage.createContact(email, firstName, lastName, jobTitle);
	}

}
