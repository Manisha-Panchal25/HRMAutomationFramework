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
   public By leaveTypeInput=By.xpath("//div[text()='-- Select --']");
}
