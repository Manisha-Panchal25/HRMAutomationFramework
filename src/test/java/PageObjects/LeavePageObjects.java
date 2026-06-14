package PageObjects;

import org.openqa.selenium.By;

public class LeavePageObjects {
   public By leaveNav= By.xpath("//span[text()='Leave']");
   public By entitlementsNav=By.xpath("//span[text()='Entitlements ']");
   public By addEntitlementsBtn=By.xpath("//a[text()='Add Entitlements']");
   public By userNameElement=By.cssSelector("p.oxd-userdropdown-name");
   public By individualEmply=By.xpath("//label[text()='Individual Employee']");
   public By multipleEmply=By.xpath("//label[text()='Multiple Employees']");
   public By emplyNameInput=By.xpath("//label[text()='Employee Name']/../../..//input[@placeholder='Type for hints...']");
   public By emplyNameDropdown=By.xpath("//div[@class=\"oxd-autocomplete-text-input--after\"]");
   public By leaveType=By.xpath("//div[@role='listbox']//span[text()='CAN - Vacation']");
   public By leaveTypedropdown=By.xpath("//div[@class='oxd-select-text-input']");
   public By leavePeriod=By.xpath("//label[text()='Leave Period']/../..//div[@class='oxd-select-text-input']");
   public By entitlementInput=By.xpath("//label[text()='Entitlement']/../..//input[contains(@class,'oxd-input')]");
   public By saveEntitlement=By.xpath("//button[text()=' Save ']");
   public By confirmationText=By.xpath("//p[text()='Existing Entitlement value 0.00 will be updated to 10.00']");
   public By confirmBtn=By.xpath("//button[text()=' Confirm ']");
   public By recordFound=By.xpath("//span[text()='(1) Record Found']");
   public By verifyLeaveType=By.xpath("//div[contains(@class,'oxd-table-cell')]//div[text()='CAN - Vacation']");
   public By leaveStatus=By.xpath("//div[contains(@class,'oxd-table-cell')]//div[text()='Added']");
   public By entitlementsDays=By.xpath("//div[contains(@class,'oxd-table-cell')]//div[text()='10']");
   public By myEntitlements=By.xpath("//a[text()='My Entitlements']");
   public By leaveTypeInput=By.xpath("//label[text()='Leave Type']/../../../..//div[text()='-- Select --']/../..");
   public By searchBtn=By.xpath("//button[text()=' Search ']");
   public By totalDays=By.xpath("//span[text()='Total 10.00 Day(s)']");
   public By ApplyNav=By.xpath("//a[text()='Apply']");
   public By leaveBalance=By.xpath("//label[text()='Leave Balance']/../../..//p[text()='10.00 Day(s)']");
   public By fromDateInput=By.xpath("//label[text()='From Date']/../../..//input[@placeholder='yyyy-dd-mm']");
   public By todayBtn=By.xpath("//div[@class='oxd-date-input-link' and text()='Today']");
   public By toDateInput=By.xpath("//label[text()='To Date']/../../..//input[@placeholder='yyyy-dd-mm']");
   public By duration=By.xpath("//div[text()='Full Day']");
   public By comments=By.xpath("//label[text()='Comments']/../..//textarea");
   public By applybtn=By.xpath("//button[text()=' Apply ']");
   public By myLeaveNav=By.xpath("//a[text()='My Leave']");
   public By LeaveRecord=By.xpath("//div[contains(@class, 'oxd-table-card') and .//div[text()='Have some work']]");
   public By cancelBtn=By.xpath("//div[contains(@class, 'oxd-table-card') and .//div[text()='have some work']]//button[contains(., 'Cancel')]");
   public By deleteBtn=By.xpath("//div[contains(@class, 'oxd-table-card') and .//div[text()='CAN - Vacation']]//button[i[contains(@class, 'bi-trash')]]");
   public By confirmDelete=By.xpath("//button[text()=' Yes, Delete ']");
};

