package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mystore.base.baseClass;

public class LoginPage extends baseClass {

	String username=prop.getProperty("usename");
	String pwd=prop.getProperty("password");
	
	@FindBy(name="email")
	WebElement Emailtxt_box;
	
	@FindBy(name="password")
	WebElement passtxt_box;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement login_btn;
	
	@FindBy(xpath="//*[contains(text(),'Logout')]")
	WebElement Logout_btn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public void EnteruNp(String username,String password) {
		Emailtxt_box.sendKeys(username);
		passtxt_box.sendKeys(password);
	}
	
	public homepage loginclick() {
		login_btn.click();
		
		return new homepage();
	}
	
	public void verifyLogin() {
		
		Assert.assertTrue(Logout_btn.isDisplayed(), "Logout button is not displayed");
		System.out.println("Logged in successfully");
		}
}
