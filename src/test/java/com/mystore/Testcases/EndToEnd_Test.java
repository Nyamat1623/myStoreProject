package com.mystore.Testcases;

import org.openqa.selenium.chromium.AddHasLaunchApp;
import org.testng.annotations.*;

import com.mystore.base.baseClass;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.addressPage;
import com.mystore.pageobjects.confirmaddress;
import com.mystore.pageobjects.confirmationPage;
import com.mystore.pageobjects.homepage;
import com.mystore.pageobjects.paymentPage;
import com.mystore.pageobjects.proceedTocart;

public class EndToEnd_Test extends baseClass {

	LoginPage lg;
	homepage hm;
	proceedTocart proceedTocart;
	addressPage adp;
	confirmationPage cnfm;
	confirmaddress cad;
	paymentPage pmnt;
	
	@BeforeMethod
	public void seup() {
		launchapp();
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
		}
	
	@Test
	public void test() {
		lg=new LoginPage();

		hm=lg.login(prop.getProperty("username"), prop.getProperty("password"));
		proceedTocart=hm.Viewprod_Click();
		adp=proceedTocart.Enter_quantity();
		cad=adp.confirmaddress();
		pmnt=cad.clickingPlaceOrder();
		cnfm=pmnt.makePayment();
		cnfm.orderConfirmed();
	}
}
