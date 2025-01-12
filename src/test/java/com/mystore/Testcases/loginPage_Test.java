package com.mystore.Testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.*;

import com.mystore.base.baseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.homepage;

public class loginPage_Test extends baseClass {

	homepage hp;
	LoginPage lg;;
	
	
	@BeforeMethod
	public void setup() {
		launchapp();
	}
	
	@AfterMethod
	public void teardown() {
		getDriver().quit();
	}
	@Test (dataProvider = "Sheet1",dataProviderClass = DataProviders.class)
	public void test(String username,String password) {
		
		lg=new LoginPage();
		 
		lg.EnteruNp(username, password);
		
		lg.loginclick();
		//hp=lg.login(prop.getProperty("username"), prop.getProperty("password"));
		lg.verifyLogin();
	}
}
