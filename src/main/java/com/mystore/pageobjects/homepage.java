package com.mystore.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.baseClass;

public class homepage extends baseClass {

	@FindBy(xpath="/html/body/section[2]/div[1]/div/div[2]/div[1]/div[4]/div/div[2]/ul/li/a")
	WebElement viewproduct1_BTN;
	
	@FindBy(xpath="//*[@id=\"header\"]/div/div/div/div[1]/div/a/img")
	WebElement Logo_BTN;
	
	public homepage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public proceedTocart Viewprod_Click() {
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", viewproduct1_BTN);
		
		viewproduct1_BTN.click();
		
//		Actions actions = new Actions(driver);
//		actions.moveToElement(viewproduct1_BTN).click().perform();

		return new proceedTocart();
	}
	
	public String HomepagecurrentUrl() {
		String homepager_url=getDriver().getCurrentUrl();
		return homepager_url;
	}
}
