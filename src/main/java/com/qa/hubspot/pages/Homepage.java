package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.basepage.Basepage;

public class Homepage extends Basepage {
	private WebDriver driver;
	Basepage basepage;
	Loginpage loginpage;

	By AccountName = By.xpath("//span[@class='account-name ']");
	By Header = By.xpath("//i18n-string[text()='Dashboard Library']");

	public Homepage(WebDriver driver) {
		this.driver = driver;
	}

	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public String getAccountName() {
		return driver.findElement(AccountName).getText();
	}

	public String getHomePageHeader() {
		if (driver.findElement(Header).isDisplayed()) {
			return driver.findElement(Header).getText();
		} else
			return null;
	}

}
