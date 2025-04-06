package com.mystore.Testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.baseClass;
import com.mystore.pageobjects.*;


public class homePage_Test extends baseClass {

	LoginPage lg;
	homepage hm;
	
	
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	@Parameters("browser")
	public void setup(@Optional("chrome") String browser) {
		launchapp(browser);
	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teardown() {
		getDriver().quit();
	}

	@Test(groups = {"Smoke","Sanity"})
	public void homepage() {
		
		hm=new homepage();
		lg=new LoginPage();
		lg.EnteruNp(prop.getProperty("username"), prop.getProperty("password"));
		//lg.login(prop.getProperty("username"), prop.getProperty("password"));

		lg.loginclick();
		
		String hpurl=hm.HomepagecurrentUrl();
		Assert.assertEquals(hpurl, "https://automationexercise.com/");
		System.out.println("Current URL : "+hpurl);
		
		String hptitle=getDriver().getTitle();
		Assert.assertEquals(hptitle, "Automation Exercise");
		System.out.println("Current Title : "+hptitle);

		//clicking on view product


	}
}
