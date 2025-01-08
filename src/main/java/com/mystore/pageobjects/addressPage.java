package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.baseClass;

public class addressPage extends baseClass{

	@FindBy(xpath="//a[@class='btn btn-default check_out']")
	WebElement ProceedAddress_BTN;
	
	public addressPage() {
		PageFactory.initElements(driver, this);
	}
	
	public confirmaddress confirmaddress() {
		ProceedAddress_BTN.click();
		 return new confirmaddress();
	}
}
