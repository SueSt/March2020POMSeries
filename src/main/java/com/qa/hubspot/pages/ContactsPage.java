package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class ContactsPage extends BasePage {
	private WebDriver driver;
	By header = By.xpath("//i18n-string[text()='Contacts']");
	By createContactPrimary = By.xpath("//span[text()='Create contact']");
	By email = By.xpath("//input[@name='textInput']");
	By firstName = By.xpath("//input[@data-field='firstname']");
	By lastName = By.xpath("//input[@data-field='lastname']");
	By jobTitle = By.xpath("//input[@data-field='jobtitle']");
	By createContactSecondary = By
			.xpath("(//span[@class='private-loading-button__content private-button--internal-spacing'])[1]");

	By contactsBackLink = By.xpath("(//*[text()='Contacts'])[position()=1]");

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	public String getContactsPageTitle() {
		return elementUtil.waitForTitleToBePresent(Constants.CONTACTS_PAGE_TITLE, 10);
	}

	public String getContactsPageHeader() {
		elementUtil.waitForElementToBeVisible(header, 10);
		return elementUtil.doGetText(header);
	}

	public void createContact(String email, String firstName, String lastName, String jobTitle) {
		elementUtil.clickWhenReady(createContactPrimary, 10);

		elementUtil.waitForElementToBeVisible(this.email, 5);
		elementUtil.doSendKeys(this.email, email);
		elementUtil.doSendKeys(this.firstName, firstName);
		elementUtil.doSendKeys(this.lastName, lastName);

		elementUtil.waitForElementToBeVisible(this.jobTitle, 5);
		elementUtil.doSendKeys(this.jobTitle, jobTitle);

		
		elementUtil.waitForElementToBeVisible(createContactSecondary, 5);
		elementUtil.doActionsClick(createContactSecondary);

		elementUtil.clickWhenReady(contactsBackLink, 5);
	}

}
