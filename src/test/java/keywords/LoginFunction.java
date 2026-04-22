package keywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import PageObjects.LoginPageObjects;
import framework.webDriverCreator;

public class LoginFunction {
	
	private webDriverCreator driver;
	LoginPageObjects loginPageObjects;
	public LoginFunction(webDriverCreator driver) {
        this.driver = driver;
        loginPageObjects = new LoginPageObjects();
    }
	
	public void LoginToHRM(String URL, String username, String password)
	{
		driver.launchApplication(URL);
		driver.page.isElementDisplayed(loginPageObjects.emailInput);
		driver.page.enterText(loginPageObjects.emailInput, username);
		driver.page.isElementDisplayed(loginPageObjects.passwordInput);
		driver.page.enterText(loginPageObjects.passwordInput, password);
		driver.page.isElementDisplayed(loginPageObjects.SubmitButton);
		driver.page.clickElement(loginPageObjects.SubmitButton);
		driver.page.isElementDisplayed(loginPageObjects.userDropdown);
	}
	public void logoutFromHRM()
	{
		driver.page.isElementDisplayed(loginPageObjects.userDropdown);
		driver.page.clickElement(loginPageObjects.userDropdown);
		driver.page.isElementDisplayed(loginPageObjects.logoutBtn);
		driver.page.clickElement(loginPageObjects.logoutBtn);
		driver.page.isElementDisplayed(loginPageObjects.SubmitButton);
	}
    public void EmptyFieldsValidation(String URL)
    {
    	driver.launchApplication(URL);
    	driver.page.isElementDisplayed(loginPageObjects.SubmitButton);
    	driver.page.clickElement(loginPageObjects.SubmitButton);
    	driver.page.isElementDisplayed(loginPageObjects.emailRequired);
    	driver.page.isElementDisplayed(loginPageObjects.passwordRequired);
    }
    public void InvalidCredsValidation() {
    	driver.page.isElementDisplayed(loginPageObjects.emailInput);
		driver.page.enterText(loginPageObjects.emailInput, "admin");
		driver.page.isElementDisplayed(loginPageObjects.passwordInput);
		driver.page.enterText(loginPageObjects.passwordInput, "Admin1234");
		driver.page.isElementDisplayed(loginPageObjects.SubmitButton);
		driver.page.clickElement(loginPageObjects.SubmitButton);
		driver.page.isElementDisplayed(loginPageObjects.invalidCreds);
    }
    public void ForgotPasswordPageValidates() {
    	driver.page.isElementDisplayed(loginPageObjects.forgotPasswordLink);
    	driver.page.clickElement(loginPageObjects.forgotPasswordLink);
    	driver.page.isElementDisplayed(loginPageObjects.resetPasswordBtn);
    	driver.page.clickElement(loginPageObjects.resetPasswordBtn);
    	driver.page.isElementDisplayed(loginPageObjects.emailRequired);
    	driver.page.isElementDisplayed(loginPageObjects.cancelBtn);
    	driver.page.clickElement(loginPageObjects.cancelBtn);
    	driver.page.isElementDisplayed(loginPageObjects.SubmitButton);
    }
}
