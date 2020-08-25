package com.training.sanity.tests;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminLoginPOM;
import com.training.pom.LoginCustomerPOM;
import com.training.pom.LoginPOM;
import com.training.pom.DashboardPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TestCase_2 {

	private WebDriver driver;
	private String AdminURL;
	private AdminLoginPOM AdminLoginPOM;
	private DashboardPOM DashboardPOM;
	
	private static Properties properties;
	private ScreenShot screenShot;
	
	private String Dash;
	
	int i=0;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		
		AdminLoginPOM = new AdminLoginPOM(driver);		
		
		AdminURL = properties.getProperty("AdminURL");
		
		screenShot = new ScreenShot(driver); 
		
		driver.get(AdminURL);
		
		//DashboardPOM = new DashboardPOM(driver);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test (priority=1)
	public void validLoginTest() throws Exception {
		
		AdminLoginPOM.SendUserName("admin");
		
		AdminLoginPOM.SendPassword("admin@123");
		
		AdminLoginPOM.clickLogin();
		
		Thread.sleep(1000);
		
		Dash=AdminLoginPOM.Read();
		
		System.out.println(Dash);
		
		Assert.assertEquals("Dashboard", Dash);
		
		DashboardPOM = new DashboardPOM(driver);
		
		DashboardPOM.mouseovercatagory();
		
		Thread.sleep(2000);
		
		DashboardPOM.display();
		
		
		
		
	}
	
}


