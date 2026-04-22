package tests;

import static helperUtils.ConfigPropertyReader.getProperty;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import framework.PreAndPostTestEvents;
import keywords.LoginFunction;

public class LoginTest extends PreAndPostTestEvents {
	LoginFunction LoginPage;
	
	@BeforeMethod
	public void init()
	{
		LoginPage=new LoginFunction(driver);
	}
	
	@Test(description = "1. Login to HRM website")
	public void TC01_loginToWbsite()
	{
		LoginPage.LoginToHRM(getProperty("URL"), getProperty("username"), getProperty("userPassword"));
	}
	
	@Test(description = "2. Logout from HRM website")
	public void TC02_logoutFromWebsite()
	{
		LoginPage.logoutFromHRM();
	}

}
