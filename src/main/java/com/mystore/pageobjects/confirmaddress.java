package com.mystore.pageobjects;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.baseClass;

public class confirmaddress extends baseClass{

	@FindBy(xpath="//a[@Class='btn btn-default check_out']")
	WebElement PlaceOrder_BTN;
	
	public confirmaddress() {
		PageFactory.initElements(driver, this);
	}
	
	public paymentPage clickingPlaceOrder() {
		JavascriptExecutor js=(JavascriptExecutor)driver ;
		js.executeScript("arguments[0].scrollIntoView(true);", PlaceOrder_BTN);
		
		PlaceOrder_BTN.click();
		return new paymentPage();
		
			
			
		
	
}
}