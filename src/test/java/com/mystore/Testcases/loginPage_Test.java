package com.mystore.Testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.*;

import com.mystore.base.baseClass;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.homepage;

public class loginPage_Test extends baseClass {

	homepage hp;
	LoginPage lg;
	
	
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
		
		hp=lg.login(prop.getProperty("username"), prop.getProperty("password"));
		
		lg.verifyLogin();
		
	}
}
