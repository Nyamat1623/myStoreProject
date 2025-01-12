package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
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
	
	
	@BeforeTest
	public void loadconfig() {
		try {
			prop=new Properties();
			
			
			System.out.println("Super Contructor Invoked");

			FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\Config.properties");
			prop.load(ip);
			//System.out.println(" Driver : "+driver);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void launchapp() {
		WebDriverManager.chromedriver().setup();
		String browsername=prop.getProperty("browser");

		if(browsername.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver=new ChromeDriver();
			
			//set browser to threadLocalMap
			driver.set(new ChromeDriver());
		}
		else if(browsername.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//set browser to threadLocalMap
			driver.set(new FirefoxDriver()); 
		}else if(browsername.contains("ie")) {
			WebDriverManager.iedriver().setup();
			//set browser to threadLocalMap
			driver.set(new InternetExplorerDriver()); 
		}
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(45));
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		getDriver().manage().window().maximize();
		//driver.manage().deleteAllCookies();
	}

}
