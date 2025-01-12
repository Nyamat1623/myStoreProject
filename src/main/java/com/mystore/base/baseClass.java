package com.mystore.base;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.*;



public class baseClass {

	//public static WebDriver driver=null;
	public static Properties prop;

	public static ThreadLocal<RemoteWebDriver> driver=new ThreadLocal<RemoteWebDriver>();

	//get driver from threadlocal map
	public static WebDriver getDriver() {
		return driver.get();
	}

	@BeforeSuite(groups = {"Smoke","Sanity","Regression"})
	public void loadconfig() {
		
		try {
			
			prop=new Properties();


			System.out.println("Super Contructor Invoked");

			FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\Config.properties");
			prop.load(ip);
			//System.out.println(" Driver : "+driver);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	
public static void TakingScreenshot(String filename) {
	String datename=new SimpleDateFormat("yyyymmddhhss").format(new Date());
	
	String destinationFile=System.getProperty("user.dir")+"\\Screenshots"+filename+"_"+datename+" .png";
		File scr=((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyDirectory(scr,new File(destinationFile));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void launchapp(String browsername) {

		//String browsername=prop.getProperty("browser");

		if(browsername.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver=new ChromeDriver();
			//set browser to threadLocalMap
			driver.set(new ChromeDriver());
		}
		else if(browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//set browser to threadLocalMap
			driver.set(new FirefoxDriver()); 
			
			
		}else if(browsername.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			//set browser to threadLocalMap
			driver.set(new EdgeDriver()); 
		}
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		getDriver().manage().window().maximize();
		//driver.manage().deleteAllCookies();
	}

}
