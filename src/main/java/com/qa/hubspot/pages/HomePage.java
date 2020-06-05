package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class HomePage extends BasePage {
	private WebDriver driver;

	By logo = By.id("hs-nav-v4--logo");
	By navBar = By.xpath("(//div[@aria-label='HubSpot Navigation'])[1]");
	By header = By.xpath("//i18n-string[text()='Dashboard Library']");
	By acctMenuAvatar = By.cssSelector("div#account-menu-container");
	By primaryContactLink = By.xpath("(//a[@id='nav-primary-contacts-branch'])[1]");
	By secondaryContactLink = By.xpath("(//a[@id='nav-secondary-contacts'])[1]");
	By saleslink = By.xpath("(//a[@id='nav-primary-sales-branch'])[1]");
	By dealslink= By.xpath("(//a[@id='nav-secondary-deals'])[1]");
	

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	public String getHomePageTitle() {
		// return driver.getTitle();
		return elementUtil.waitForTitleToBePresent(Constants.HOME_PAGE_TITLE, 10);
	}

	public String getHomePageHeaderText() {
		// if(driver.findElement(header).isDisplayed()) {
		// //return driver.findElement(header).getText();
		// }
		// return null;
		if (elementUtil.doIsDisplayed(header)) {
			return elementUtil.doGetText(header);
		}
		return null;
	}

	public boolean verifyAcctmenuAvatar() {
		// driver.findElement(acctMenuAvatar).isDisplayed();
		return elementUtil.doIsDisplayed(acctMenuAvatar);
	}

	public boolean verifyLogo() {
		// driver.findElement(logo).isDisplayed();
		return elementUtil.doIsDisplayed(logo);
	}

	public boolean verifyNavBar() {
		return elementUtil.doIsDisplayed(navBar);

	}
	
	public ContactsPage goToContactsPage() {
		clickOnContacts();
		return new ContactsPage(driver);
	}
	private void clickOnContacts() {
		elementUtil.waitForElementToBeVisible(primaryContactLink, 10);
		elementUtil.doClick(primaryContactLink);
		
		elementUtil.waitForElementPresent(secondaryContactLink, 10);
		elementUtil.doClick(secondaryContactLink);
		//elementUtil.doActionsClick(secondaryContactLink);
	}
	
	public DealsPage goToDealsPage(){
		clickOnSalesLink();
		return new DealsPage(driver);
	}
	
	private void clickOnSalesLink() {
		elementUtil.waitForElementToBeVisible(saleslink, 10);
		elementUtil.doClick(saleslink);
		
		elementUtil.waitForElementToBeVisible(dealslink, 10);
		elementUtil.doClick(dealslink);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
