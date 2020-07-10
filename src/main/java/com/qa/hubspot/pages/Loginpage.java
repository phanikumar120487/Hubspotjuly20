package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.basepage.Basepage;

public class Loginpage extends Basepage 
{
	private WebDriver driver;
	//1. By Locators - Object repository(OR)
	
	By username=By.xpath("//input[@id='username']");
	By password=By.xpath("//input[@id='password']");
	By login=By.xpath("//button[@id='loginBtn']");
	By signup=By.xpath("//i18n-string[text()='Sign up']");
	
	//2. create a constructor of page class
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
	}

	// 3.Create Page Actions
	public String getloginpageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifySignupLink()
	{
		return driver.findElement(signup).isDisplayed();
	}
	
	public Homepage doLogin(String username,String password) 
	{
		driver.findElement(this.username).sendKeys(username);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(this.login).click();
		return new Homepage(driver);
	}
}
