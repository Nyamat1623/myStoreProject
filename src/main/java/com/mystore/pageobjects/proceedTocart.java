package com.mystore.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.base.baseClass;

public class proceedTocart extends baseClass {

	@FindBy(xpath="//button[@type='button']")
	WebElement ProceedtoCart_BTN;
	
	@FindBy(id="quantity")
	WebElement select_quantityBTN;
	
	@FindBy(xpath="//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u")
	WebElement cartView_BTN;
	
	public proceedTocart() {
		PageFactory.initElements(driver, this);
	}
	
	public addressPage Enter_quantity() {
		select_quantityBTN.clear();
		select_quantityBTN.sendKeys("3");
		ProceedtoCart_BTN.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(cartView_BTN));
		String AddtocartMSG=driver.findElement(By.xpath("//p[@class='text-center']")).getText();
		System.out.println(AddtocartMSG);
		cartView_BTN.click();
		
		return new addressPage();
	}
}
