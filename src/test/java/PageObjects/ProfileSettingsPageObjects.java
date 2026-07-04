package PageObjects;

import org.openqa.selenium.By;

public class ProfileSettingsPageObjects {
   public By userDropdown=By.xpath("//img[@class='oxd-userdropdown-img']/..");
   public By myInfoNavigatebar=By.xpath("//span[text()='My Info']");
   public By employeeImage=By.xpath("//img[@class='employee-image']");
   public By empImgActionBtn=By.xpath("//button[contains(@class,'employee-image-action')]");
   public By ImgPreview=By.xpath("//input/..//img[@class='employee-image']");
   public By saveBtn=By.xpath("//button[@type='submit']");
   public By PersonalDetailsNav=By.xpath("//a[text()='Personal Details']");
   public By firstName=By.xpath("//input[@name='firstName']");
   public By middleName=By.xpath("//input[@name='middleName']");
   public By lastName=By.xpath("//input[@name='lastName']");
   public By contactdetailsNav=By.xpath("UpdateContactsDetails()");
   public By changePasswordBtn=By.xpath("//a[text()='Change Password']");
   public By currentPassword=By.xpath("//label[text()='Current Password']/ancestor::div[contains(@class, 'oxd-input-group')]//input[@type='password']");
   public By password=By.xpath("//label[text()='Password']/ancestor::div[contains(@class, 'oxd-input-group')]//input[@type='password']");
   public By confirmPassword=By.xpath("//label[text()='Confirm Password']/ancestor::div[contains(@class, 'oxd-input-group')]//input[@type='password']");
}
