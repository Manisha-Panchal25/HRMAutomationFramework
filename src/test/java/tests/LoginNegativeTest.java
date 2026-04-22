package tests;

import static helperUtils.ConfigPropertyReader.getProperty;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import framework.PreAndPostTestEvents;
import keywords.LoginFunction;

public class LoginNegativeTest extends PreAndPostTestEvents {
LoginFunction LoginPage;
	
	@BeforeMethod
	public void init()
	{
		LoginPage=new LoginFunction(driver);
	}
	@Test(description = "Click On Login Button Without fillout Username and Password")
	public void TC01_EmptyFiledsTest()
	{
		LoginPage.EmptyFieldsValidation(getProperty("URL"));
	}
	@Test(description = "Check Login with Invalid creds")
	public void TC02_InvalidCredsTest()
	{
		LoginPage.InvalidCredsValidation();
	}
	@Test(description = "Check Forgot Password Page validation")
	public void TC03_ForgotPasswordPageValidation()
	{
		LoginPage.ForgotPasswordPageValidates();
	}

}
