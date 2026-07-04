package tests;

import static helperUtils.ConfigPropertyReader.getProperty;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import framework.PreAndPostTestEvents;
import keywords.ProfileSettingsFunction;
import keywords.LoginFunction;

public class ProfileSettingsTest extends PreAndPostTestEvents{
	LoginFunction LoginPage;
	ProfileSettingsFunction profileSettingsPage;
    
    @BeforeMethod
    public void init()
    {
  	  LoginPage= new LoginFunction(driver); 
  	  profileSettingsPage= new ProfileSettingsFunction(driver);
    }
    
    @Test(description = "Login To HRM")
    void TC_01LoginToHRM()
    {
  	  LoginPage.LoginToHRM(getProperty("URL"), getProperty("username"), getProperty("userPassword"));
    }
    @Test(description = "Goto Profile Settings")
    void TC_02GotoProfileSettings()
    {
    	profileSettingsPage.GotoProfileSettings();
    }
    @Test(description = "Change Profile Picture")
    void TC_03ChangeProfilePicture()
    {
    	profileSettingsPage.ChangeProfilePicture();
    }
    @Test(description = "Update Personal Details")
    void TC_04UpdatePersonalDetails()
    {
    	profileSettingsPage.UpdatePersonalDetails();
    }
    @Test(description = "Change password")
    void TC_05ChangePassword()
    {
    	profileSettingsPage.ChangePassword();
    }
}
