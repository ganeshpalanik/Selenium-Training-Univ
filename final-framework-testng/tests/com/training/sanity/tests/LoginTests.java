package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.LoginCustomerPOM;
import com.training.pom.AdminLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private LoginCustomerPOM LoginCustomerPOM;
	private AdminLoginPOM AdminLoginPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream); 
	}

	@BeforeMethod
	public void setUp() throws Exception {
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		
		loginPOM = new LoginPOM(driver); 
		
		LoginCustomerPOM = new LoginCustomerPOM(driver); 
		
		AdminLoginPOM = new AdminLoginPOM(driver);		
		
		baseUrl = properties.getProperty("baseURL");
		
		screenShot = new ScreenShot(driver); 
		
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(enabled=true,priority=0)
	public void validLoginTest() throws Exception {
		
		loginPOM.mouseoveracct();
		
		loginPOM.LoginClick();		
			
		Thread.sleep(2000);
		
		LoginCustomerPOM.SendEmail("ganesh.palani.k@gmail.com");
		
		LoginCustomerPOM.SendPassword("ganesh123");
		
		LoginCustomerPOM.clickLogin();
	}
	
	
}
