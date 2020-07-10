package com.qa.hubspot.testpackage;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.basepage.Basepage;
import com.qa.hubspot.pages.Loginpage;
import com.qa.hubspot.utils.Constants;

public class LoginpageTest {
	WebDriver driver;
	Basepage basepage;
	Properties prop;
	Loginpage loginpage;

	@BeforeTest
	public void setup() {
		basepage = new Basepage();
		prop=basepage.init_prop();
		driver = basepage.initialize_driver(prop);
		loginpage = new Loginpage(driver);

	}

	@Test(priority = 2)
	public void verifyLoginPageTitleTest() {
		String title = loginpage.getloginpageTitle();
		System.out.println("LoginPage Title is " + title);
		Assert.assertEquals(title, Constants.LoginPageTitile, "LoginPage Title is not matched");

	}

	@Test(priority = 1)
	public void verifySignupLinkTest() {
		Assert.assertTrue(loginpage.verifySignupLink(), "SignUp Link not Displayed");
	}

	@Test(priority = 3)
	public void doLoginPageTest() throws InterruptedException {
		loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
