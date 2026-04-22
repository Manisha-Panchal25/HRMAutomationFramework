package PageObjects;

import org.openqa.selenium.By;

public class LoginPageObjects {
	public By emailInput=By.xpath("//input[@placeholder='Username']");
	public By passwordInput=By.xpath("//input[@placeholder='Password']");
	public By SubmitButton=By.xpath("//button[@type='submit']");
    public By logoutBtn=By.xpath("//a[contains(text(),'Logout')]");
    public By userDropdown=By.cssSelector("img.oxd-userdropdown-img");
    public By emailRequired=By.xpath("//input[@placeholder='Username']/../..//span[text()='Required']");
    public By passwordRequired=By.xpath("//input[@placeholder='Password']/../..//span[text()='Required']");
    public By invalidCreds=By.xpath("//p[text()='Invalid credentials']");
    public By forgotPasswordLink=By.xpath("//p[text()='Forgot your password? ']");
    public By resetPasswordBtn=By.xpath("//button[text()=' Reset Password ']");
    public By cancelBtn=By.xpath("//button[text()=' Cancel ']");
}
