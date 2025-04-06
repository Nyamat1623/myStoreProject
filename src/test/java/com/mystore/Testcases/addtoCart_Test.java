package com.mystore.Testcases;


import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.baseClass;
import com.mystore.pageobjects.LoginPage;

import com.mystore.pageobjects.homepage;
import com.mystore.pageobjects.proceedTocart;

public class addtoCart_Test extends baseClass {


	LoginPage lg;
	homepage hm;
	proceedTocart proceedTocart;
	
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	@Parameters("browser")
	public void setup(@Optional("edge") String browser) {
		launchapp(browser);
	}
	 
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teardown() {
		getDriver().quit();
	}
	
	@Test (groups = {"Smoke","Sanity"})
	public void test() {
		lg=new LoginPage();
		lg.EnteruNp(prop.getProperty("username"), prop.getProperty("password"));
		hm=lg.loginclick();
		proceedTocart=hm.Viewprod_Click();
		proceedTocart.Enter_quantity();
		
	}
}
