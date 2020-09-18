package com.qa.hubspot.testpackage;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.basepage.Basepage;
import com.qa.hubspot.pages.Homepage;
import com.qa.hubspot.pages.Loginpage;
import com.qa.hubspot.utils.Constants;

public class HomepageTest 
{
WebDriver driver;
Basepage basepage;
Loginpage loginpage;
Homepage homepage;
Properties prop;
@BeforeTest
public void setup()
{
	basepage=new Basepage();
	prop=basepage.init_prop();
	driver=basepage.initialize_driver(prop);
	loginpage=new Loginpage(driver);
	//homepage=new Homepage(driver);
	homepage=loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));

	
}
@Test(priority=2)
public void verifyHomePageTitle()
{
	String title=homepage.getHomePageTitle();
	System.out.println("HomePage Title is "+ title);
	Assert.assertEquals(title, Constants.HomePageTitle,"HomePage Title not matched");
}
@Test(priority=3)
public void verifyAccountName()
{
	String accname=homepage.getAccountName();
	System.out.println("Account name is "+ accname);
	Assert.assertEquals(accname, "excel laundry services","Account Name not matched");
}
@Test(priority=1)
public void verifyHomePageHeader()
{
	String header=homepage.getHomePageHeader();
	System.out.println("HomePage Header is "+ header);
	Assert.assertEquals(header, Constants.HomePageHeader,"HomePage Header not matched");
}
@AfterTest
public void teardown()
{
	driver.quit();
}


}
