package com.mystore.pageobjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mystore.base.baseClass;

public class confirmationPage extends baseClass{

	@FindBy(xpath="//*[@id=\"form\"]/div/div/div/p")
	WebElement Confirmation_MSG;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement Continue_BTN;
	
	public confirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void orderConfirmed() {
		String msg=Confirmation_MSG.getText();
		Assert.assertEquals(msg, "Congratulations! Your order has been confirmed!");
		System.out.println(msg);
		
		Continue_BTN.click();
	}
	
}
