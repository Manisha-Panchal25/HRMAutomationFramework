package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static helperUtils.ConfigPropertyReader.getProperty;

import framework.PreAndPostTestEvents;
import keywords.LeaveFunctions;
import keywords.LoginFunction;

public class LeaveTest extends PreAndPostTestEvents {
	      LoginFunction LoginPage;
	      LeaveFunctions LeavePage;
	      
	      @BeforeMethod
          public void init()
          {
        	  LoginPage= new LoginFunction(driver); 
        	  LeavePage= new LeaveFunctions(driver);
          }
	      
          @Test(description = "Login To HRM")
          void TC_01LoginToHRM()
          {
        	  LoginPage.LoginToHRM(getProperty("URL"), getProperty("username"), getProperty("userPassword"));
          }
          
          @Test(description = "Navigates to Leave module")
          void TC_02NavigateToLeaveModule()
          {
        	  LeavePage.navigateToLeaveModule();
          }
          
          @Test(description = "Add Entitlements")
          void TC_03AddEntitlements()
          {
        	  LeavePage.AddEntitlements();
          }
          
          @Test(description = "View Employee Entitlements")
          void TC_04ViewEntitlements()
          {
        	  LeavePage.ViewEntitlements();
          }
          
}
