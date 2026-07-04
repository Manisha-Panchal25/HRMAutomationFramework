package keywords;

import java.io.File;

import org.openqa.selenium.By;

import PageObjects.ProfileSettingsPageObjects;
import framework.webDriverCreator;

public class ProfileSettingsFunction {
	private webDriverCreator driver;
	ProfileSettingsPageObjects profileSettingsPageObjects;
	public ProfileSettingsFunction(webDriverCreator driver) {
        this.driver = driver;
        profileSettingsPageObjects = new ProfileSettingsPageObjects();
    }
	public void GotoProfileSettings()
	{
		driver.page.isElementDisplayed(profileSettingsPageObjects.userDropdown);
		driver.page.clickElement(profileSettingsPageObjects.userDropdown);
		driver.page.isElementDisplayed(profileSettingsPageObjects.myInfoNavigatebar);
		driver.page.clickElement(profileSettingsPageObjects.myInfoNavigatebar);
	}
	public void ChangeProfilePicture()
	{
		driver.page.isElementDisplayed(profileSettingsPageObjects.employeeImage);
		driver.page.clickElement(profileSettingsPageObjects.employeeImage);
		driver.page.isElementDisplayed(profileSettingsPageObjects.empImgActionBtn);
		String profilePhoto = System.getProperty("user.dir") + File.separator + "media" + File.separator + "images" + File.separator + "profilePic.jpg";
		driver.getDriver().findElement(By.xpath("//input[@type='file']")).sendKeys(profilePhoto);
		driver.page.verifyElementAttributeNotContains(profileSettingsPageObjects.ImgPreview,"src","/web/images/default-photo.png");
		driver.page.isElementDisplayed(profileSettingsPageObjects.saveBtn);
		driver.page.clickElement(profileSettingsPageObjects.saveBtn);
		driver.page.wait.hardWait(5);
		driver.page.verifyElementAttributeContains(profileSettingsPageObjects.ImgPreview,"src","https://opensource-demo.orangehrmlive.com/web/images/default-photo.png");
		
	}
	public void UpdatePersonalDetails()
	{
		driver.page.isElementDisplayed(profileSettingsPageObjects.PersonalDetailsNav);
		driver.page.clickElement(profileSettingsPageObjects.PersonalDetailsNav);
		driver.page.isElementDisplayed(profileSettingsPageObjects.firstName);
		driver.page.clearAndTypeTextInEditBox(profileSettingsPageObjects.firstName, "Manisha");
		driver.page.isElementDisplayed(profileSettingsPageObjects.middleName);
		driver.page.clearAndTypeTextInEditBox(profileSettingsPageObjects.middleName, "The");
		driver.page.isElementDisplayed(profileSettingsPageObjects.lastName);
		driver.page.clearAndTypeTextInEditBox(profileSettingsPageObjects.lastName, "Panchal");
		driver.page.isElementDisplayed(profileSettingsPageObjects.saveBtn);
		driver.page.clickElement(profileSettingsPageObjects.saveBtn);
	}
	public void ChangePassword(){
		driver.page.isElementDisplayed(profileSettingsPageObjects.userDropdown);
		driver.page.clickElement(profileSettingsPageObjects.userDropdown);
		driver.page.isElementDisplayed(profileSettingsPageObjects.changePasswordBtn);
		driver.page.clickElement(profileSettingsPageObjects.changePasswordBtn);
		driver.page.isElementDisplayed(profileSettingsPageObjects.currentPassword);
		driver.page.enterText(profileSettingsPageObjects.currentPassword,"admin123");
		driver.page.isElementDisplayed(profileSettingsPageObjects.password);
		driver.page.enterText(profileSettingsPageObjects.password, "admin1234");
		driver.page.isElementDisplayed(profileSettingsPageObjects.confirmPassword);
		driver.page.enterText(profileSettingsPageObjects.confirmPassword, "admin1234");
		driver.page.isElementDisplayed(profileSettingsPageObjects.saveBtn);
		driver.page.clickElement(profileSettingsPageObjects.saveBtn);
	}
}
