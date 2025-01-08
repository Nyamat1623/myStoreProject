package com.mystore.Testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.baseClass;
import com.mystore.pageobjects.*;


public class homePage_Test extends baseClass {

	LoginPage lg;
	homepage hm;
	@BeforeMethod
	public void setup() {
		launchapp();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test
	public void homepage() {
		
		hm=new homepage();
		lg=new LoginPage();
		
		lg.login(prop.getProperty("username"), prop.getProperty("password"));

		String hpurl=hm.HomepagecurrentUrl();
		Assert.assertEquals(hpurl, "https://automationexercise.com/");
		System.out.println("Current URL : "+hpurl);
		
		String hptitle=driver.getTitle();
		Assert.assertEquals(hptitle, "Automation Exercise");
		System.out.println("Current Title : "+hptitle);

		//clicking on view product
		
		





	}
}
