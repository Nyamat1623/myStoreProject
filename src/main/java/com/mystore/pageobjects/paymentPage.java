package com.mystore.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.base.baseClass;

public class paymentPage extends baseClass{

	@FindBy(name="name_on_card")
	WebElement NameonCard_BTN;
	
	@FindBy(name="card_number")
	WebElement Cardnumber_BTN;
	
	@FindBy(name="cvc")
	WebElement cvc_BTN;
	
	@FindBy(name="expiry_month")
	WebElement expiryMonth_BTN;
	
	@FindBy(name="expiry_year")
	WebElement expiryYear_BTN;
	
	@FindBy(id="submit")
	WebElement confirmOrder_BTN;
	
	public paymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public confirmationPage makePayment() {
		NameonCard_BTN.sendKeys("makhd");
		Cardnumber_BTN.sendKeys("21549 2158");
		cvc_BTN.sendKeys("111");
		expiryMonth_BTN.sendKeys("12");
		expiryYear_BTN.sendKeys("2030");
		
		WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(confirmOrder_BTN));
		
		confirmOrder_BTN.click();
		return new confirmationPage();
	}
}
