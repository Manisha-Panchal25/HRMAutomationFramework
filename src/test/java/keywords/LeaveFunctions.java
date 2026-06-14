package keywords;

import java.time.LocalDate;

import org.openqa.selenium.By;

import PageObjects.LeavePageObjects;
import framework.webDriverCreator;

public class LeaveFunctions {
	private webDriverCreator driver;
	LeavePageObjects leavePageObjects;
	public LeaveFunctions(webDriverCreator driver) {
        this.driver = driver;
        leavePageObjects = new LeavePageObjects();
    }
	public void navigateToLeaveModule()
	{
		driver.page.isElementDisplayed(leavePageObjects.leaveNav);
		driver.page.clickElement(leavePageObjects.leaveNav);
	}
	public void AddEntitlements()
	{
		driver.page.isElementDisplayed(leavePageObjects.entitlementsNav);
		driver.page.clickElement(leavePageObjects.entitlementsNav);
		driver.page.isElementDisplayed(leavePageObjects.addEntitlementsBtn);
		driver.page.clickElement(leavePageObjects.addEntitlementsBtn);
		driver.page.isElementDisplayed(leavePageObjects.userNameElement);
		String userName=driver.page.getTextOfElement(leavePageObjects.userNameElement);
		driver.page.isElementDisplayed(leavePageObjects.individualEmply);
		driver.page.isElementDisplayed(leavePageObjects.multipleEmply);
		driver.page.clickElement(leavePageObjects.multipleEmply);
		driver.page.clickElement(leavePageObjects.individualEmply);
		driver.page.isElementDisplayed(leavePageObjects.emplyNameInput);
		driver.page.enterText(leavePageObjects.emplyNameInput, userName);
		String userFirstName=userName.split(" ")[0];
	    driver.page.isElementDisplayed(By.xpath("//div[@role='listbox']//span[contains(text(), '"+userFirstName+"')]"));
		driver.page.clickElement(By.xpath("//div[@role='listbox']//span[contains(text(), '"+userFirstName+"')]"));
		driver.page.isElementDisplayed(leavePageObjects.leaveTypedropdown);
		driver.page.clickElement(leavePageObjects.leaveTypedropdown);
		driver.page.isElementDisplayed(leavePageObjects.leaveType);
		driver.page.clickElement(leavePageObjects.leaveType);
		driver.page.isElementDisplayed(leavePageObjects.leavePeriod);
		String leavePeriod=driver.page.getTextOfElement(leavePageObjects.leavePeriod);
		leavePeriod=leavePeriod.split("-")[0];
		String year = String.valueOf(LocalDate.now().getYear());
		driver.page.hardAssert(leavePeriod, year);
		driver.page.isElementDisplayed(leavePageObjects.entitlementInput);
		driver.page.enterText(leavePageObjects.entitlementInput, "10");
		driver.page.isElementDisplayed(leavePageObjects.saveEntitlement);
		driver.page.clickElement(leavePageObjects.saveEntitlement);
		driver.page.isElementDisplayed(leavePageObjects.confirmBtn);
		driver.page.clickElement(leavePageObjects.confirmBtn);
		
		//verify Added Entitlement
		driver.page.isElementDisplayed(leavePageObjects.recordFound);
		driver.page.isElementDisplayed(leavePageObjects.verifyLeaveType);
		driver.page.isElementDisplayed(leavePageObjects.leaveStatus);
		driver.page.isElementDisplayed(leavePageObjects.entitlementsDays);
	}
	public void ViewEntitlements()
	{
		driver.page.isElementDisplayed(leavePageObjects.entitlementsNav);
		driver.page.clickElement(leavePageObjects.entitlementsNav);
		driver.page.isElementDisplayed(leavePageObjects.myEntitlements);
		driver.page.clickElement(leavePageObjects.myEntitlements);
		driver.page.isElementDisplayed(leavePageObjects.leaveTypeInput);
		driver.page.clickElement(leavePageObjects.leaveTypeInput);
		driver.page.isElementDisplayed(leavePageObjects.leaveType);
		driver.page.clickElement(leavePageObjects.leaveType);
		driver.page.isElementDisplayed(leavePageObjects.leavePeriod);
		String leavePeriod=driver.page.getTextOfElement(leavePageObjects.leavePeriod);
		leavePeriod=leavePeriod.split("-")[0];
		String year = String.valueOf(LocalDate.now().getYear());
		driver.page.hardAssert(leavePeriod, year);
		driver.page.isElementDisplayed(leavePageObjects.searchBtn);
		driver.page.clickElement(leavePageObjects.searchBtn);
		driver.page.isElementDisplayed(leavePageObjects.totalDays);
		driver.page.isElementDisplayed(leavePageObjects.verifyLeaveType);
		driver.page.isElementDisplayed(leavePageObjects.leaveStatus);
		driver.page.isElementDisplayed(leavePageObjects.entitlementsDays);
	}
	public void ApplyLeave()
	{
		driver.page.isElementDisplayed(leavePageObjects.ApplyNav);
		driver.page.clickElement(leavePageObjects.ApplyNav);
		driver.page.isElementDisplayed(leavePageObjects.leaveTypeInput);
		driver.page.clickElement(leavePageObjects.leaveTypeInput);
		driver.page.isElementDisplayed(leavePageObjects.leaveType);
		driver.page.clickElement(leavePageObjects.leaveType);
		driver.page.isElementDisplayed(leavePageObjects.leaveBalance);
		driver.page.isElementDisplayed(leavePageObjects.fromDateInput);
		driver.page.clickElement(leavePageObjects.fromDateInput);
		driver.page.isElementDisplayed(leavePageObjects.todayBtn);
		driver.page.clickElement(leavePageObjects.todayBtn);
		driver.page.isElementDisplayed(leavePageObjects.toDateInput);
		driver.page.clickElement(leavePageObjects.toDateInput);
		driver.page.isElementDisplayed(leavePageObjects.todayBtn);
		driver.page.isElementDisplayed(leavePageObjects.duration);
		driver.page.isElementDisplayed(leavePageObjects.comments);
		driver.page.enterText(leavePageObjects.comments, "Have Some Work");
		driver.page.isElementDisplayed(leavePageObjects.applybtn);
		driver.page.clickElement(leavePageObjects.applybtn);
	}
	public void VerifyAppliedLeave()
	{
		driver.page.isElementDisplayed(leavePageObjects.myLeaveNav);
		driver.page.clickElement(leavePageObjects.myLeaveNav);
		driver.page.isElementDisplayed(leavePageObjects.leaveTypeInput);
		driver.page.clickElement(leavePageObjects.leaveTypeInput);
		driver.page.isElementDisplayed(leavePageObjects.verifyLeaveType);
		driver.page.clickElement(leavePageObjects.verifyLeaveType);
		driver.page.isElementDisplayed(leavePageObjects.searchBtn);
		driver.page.clickElement(leavePageObjects.searchBtn);
		driver.page.isElementDisplayed(leavePageObjects.LeaveRecord);
	}
	public void CancelLeaveAndRemoveEntitlements()
	{
		driver.page.isElementDisplayed(leavePageObjects.cancelBtn);
		driver.page.clickElement(leavePageObjects.cancelBtn);
		driver.page.isElementDisplayed(leavePageObjects.entitlementsNav);
		driver.page.clickElement(leavePageObjects.entitlementsNav);
		driver.page.isElementDisplayed(leavePageObjects.myEntitlements);
		driver.page.clickElement(leavePageObjects.myEntitlements);
		driver.page.isElementDisplayed(leavePageObjects.verifyLeaveType);
		driver.page.isElementDisplayed(leavePageObjects.deleteBtn);
		driver.page.clickElement(leavePageObjects.deleteBtn);
		driver.page.isElementDisplayed(leavePageObjects.confirmDelete);
		driver.page.clickElement(leavePageObjects.confirmDelete);
	}
}
