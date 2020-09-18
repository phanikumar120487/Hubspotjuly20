package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.basepage.Basepage;

public class CreateUserPage extends Basepage {
	private WebDriver driver;
	Basepage basepage;
	Loginpage loginpage;

	By AccountName = By.xpath("//span[@class='account-name ']");
	By Header = By.xpath("//i18n-string[text()='Dashboard Library']");
	By username=By.xpath("//input[@id='username']");
	By password=By.xpath("//input[@id='password']");
	By login=By.xpath("//button[@id='loginBtn']");
	By signup=By.xpath("//i18n-string[text()='Sign up']");

	public CreateUserPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public String getAccountName() {
		return driver.findElement(AccountName).getText();
	}
	public Homepage doLogin(String username,String password) 
	{
		driver.findElement(this.username).sendKeys(username);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(this.login).click();
		return new Homepage(driver);
	}

	public String getHomePageHeader() {
		if (driver.findElement(Header).isDisplayed()) {
			return driver.findElement(Header).getText();
		} else
			return null;
	}

}
