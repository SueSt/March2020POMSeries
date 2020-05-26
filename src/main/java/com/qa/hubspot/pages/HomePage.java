package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class HomePage extends BasePage{
	private WebDriver driver;
	

	By logo= By.id("hs-nav-v4--logo");
	By navBar= By.xpath("(//div[@aria-label='HubSpot Navigation'])[1]");
	By header= By.xpath("//i18n-string[text()='Dashboard Library']");
	By acctName= By.cssSelector("//div[text()='Sue St']");
	By acctMenu= By.className("//img[@src='https://api.hubspot.com/userpreferences/v1/avatar/f4c67b59b85e29f2c04e3c9362fa4894/100 ']");
	
	
	public HomePage(WebDriver driver) {
		this.driver= driver;
	}
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public String getHomePageHeaderText() {
		if(driver.findElement(header).isDisplayed()) {
			return driver.findElement(header).getText();
		}
		return null;
		}
	
//	public String getLoggedInUser() {
//		driver.findElement(acctMenu).click();
//		if(driver.findElement( acctName).isDisplayed()) {
//			return driver.findElement(acctName).getText();
//		}
//		return null;
//		}
	
	public boolean verifyLogo() {
		return driver.findElement(logo).isDisplayed();
	}
	
	public boolean verifyNavBar() {
		return driver.findElement(navBar).isDisplayed();
	}
	
	
}
