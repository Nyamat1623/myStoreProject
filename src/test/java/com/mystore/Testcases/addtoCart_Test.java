package com.mystore.Testcases;


import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.baseClass;
import com.mystore.pageobjects.LoginPage;

import com.mystore.pageobjects.homepage;
import com.mystore.pageobjects.proceedTocart;

public class addtoCart_Test extends baseClass {


	LoginPage lg;
	homepage hm;
	proceedTocart proceedTocart;
	
	@BeforeMethod
	public void setup() {
		launchapp();
	}
	 
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void test() {
		lg=new LoginPage();
		hm=lg.login(prop.getProperty("username"), prop.getProperty("password"));
		proceedTocart=hm.Viewprod_Click();
		proceedTocart.Enter_quantity();
		
	}
}
