package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class DealsPage extends BasePage {

	WebDriver driver;

	By header = By.xpath("//i18n-string[text()='Deals']");
	By createDealBtnPrimary = By.xpath("//button[@data-onboarding='new-object-button']");

	By dealName = By.xpath("//input[@data-field='dealname']");
	By dealStage = By.xpath(
			"(//span[@class='uiDropdown__buttonCaret private-dropdown__caret private-dropdown__caret--form'])[4]");
	By presSchedule = By.xpath("//button[@title='Presentation scheduled']");
	By amount = By.xpath("//input[@data-field='amount']");
	By closeDate = By.xpath("//div[@data-field='closedate']");
	By dealtype = By.xpath("//div[@data-selenium-test='property-input-dealtype']");
	By CreateBtn = By.xpath("(//li[@class='uiListItem private-list__item p-bottom-1'])[1]");

	public DealsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	public String getDealsPageTitle() {
		return elementUtil.waitForTitleToBePresent(Constants.DEALS_PAGE_TITLE, 10);
	}

	public String getDealsPageHeader() {
		elementUtil.waitForElementToBeVisible(header, 10);
		return elementUtil.doGetText(header);
	}

	public void CreateDeal(String dealName, String dealStage, String amount, String dealtype) {
		elementUtil.clickWhenReady(createDealBtnPrimary, 10);

		elementUtil.waitForElementToBeVisible(this.dealName, 5);
		elementUtil.doSendKeys(this.dealName, dealName);

		/*elementUtil.waitForElementToBeVisible(this.dealStage, 5);
		elementUtil.doSelectByVisibleText(this.dealStage, dealStage);*/

		elementUtil.waitForElementToBeVisible(this.amount, 5);
		elementUtil.doSendKeys(this.amount, amount);

		elementUtil.waitForElementToBeVisible(this.dealtype, 5);
		elementUtil.doSelectByVisibleText(this.dealtype, dealtype);

		elementUtil.waitForElementPresent(CreateBtn, 5);
		elementUtil.doClick(CreateBtn);

	}

}
