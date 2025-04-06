package com.mystore.Testcases;

import org.openqa.selenium.chromium.AddHasLaunchApp;
import org.testng.annotations.*;

import com.mystore.base.baseClass;
import com.mystore.dataprovider.DataProviders;
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
	
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	@Parameters("browser")
	public void setup(@Optional("edge") String browser) {
		launchapp(browser);
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teardown(){
		getDriver().quit();
		}
	
	@Test (dataProvider = "Sheet1",dataProviderClass = DataProviders.class,groups = {"Regression","Sanity"})
	public void test(String username,String password) {
		lg=new LoginPage();
		lg.EnteruNp(username, password);
		hm=lg.loginclick();
		proceedTocart=hm.Viewprod_Click();
		adp=proceedTocart.Enter_quantity();
		cad=adp.confirmaddress();
		pmnt=cad.clickingPlaceOrder();
		cnfm=pmnt.makePayment();
		cnfm.orderConfirmed();
	}
}
