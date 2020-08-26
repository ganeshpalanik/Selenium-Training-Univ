package com.training.sanity.tests;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminLoginPOM;
import com.training.pom.LoginCustomerPOM;
import com.training.pom.LoginPOM;
import com.training.pom.DashboardPOM;
import com.training.pom.CategoriesPOM;
import com.training.pom.EditCategoryPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Medium_TestCase {

	private static WebDriver driver;
	private static String AdminURL;
	private static AdminLoginPOM AdminLoginPOM;
	private DashboardPOM DashboardPOM;
	private CategoriesPOM CategoriesPOM;
	private static Properties properties;
	private static ScreenShot screenShot;
	private static EditCategoryPOM EditCategoryPOM;
	
	private String Dash;
	
	int i=0;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		
		properties = new Properties();
		
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		
		AdminLoginPOM = new AdminLoginPOM(driver);		
		
		AdminURL = properties.getProperty("AdminURL");
		
		screenShot = new ScreenShot(driver); 
		
		driver.get(AdminURL);
		
		
	}

	@BeforeMethod
	public void setUp() throws Exception {
		
	/*	driver = DriverFactory.getDriver(DriverNames.CHROME);
		
		AdminLoginPOM = new AdminLoginPOM(driver);		
		
		AdminURL = properties.getProperty("AdminURL");
		
		screenShot = new ScreenShot(driver); 
		
		driver.get(AdminURL);*/
		
		//DashboardPOM = new DashboardPOM(driver);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		
		Thread.sleep(1000);
	   //	driver.quit();
	}
	
	@AfterClass
	public void CloseBrowser() throws Exception
	{
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
			
	}
	
	@Test (priority=2)
	
	public void MediumTestCase_1() throws Exception
	{
		// *** 3rd Test Case
		 
		DashboardPOM = new DashboardPOM(driver);
		
		DashboardPOM.mouseovercatagory();
		
		Thread.sleep(2000);			
		
		DashboardPOM.mouseovercatagory();
		
		DashboardPOM.display();
		
		System.out.println(" \n *** --- MEDIUM TEST CASE 1 STEP 1 PASSED --- *** \n " );
		
		DashboardPOM.category();		
		
		CategoriesPOM = new CategoriesPOM(driver); 
		
		Assert.assertEquals("Category Name", CategoriesPOM.cname());
		
		System.out.println(CategoriesPOM.cname());
		
		Assert.assertEquals("Sort Order", CategoriesPOM.sort());
		
		System.out.println(CategoriesPOM.sort());
		
		Assert.assertEquals("Action", CategoriesPOM.Action());
		
		System.out.println(CategoriesPOM.Action());
		
		System.out.println(" \n *** --- MEDIUM TEST CASE 1 STEP 2 PASSED --- *** \n " );
		
		CategoriesPOM.Edit_Click();		
				
		EditCategoryPOM = new EditCategoryPOM(driver);
		
		System.out.println("CATEGORY NAME IS ===>  "+ EditCategoryPOM.Description());
		
		System.out.println(" \n *** --- MEDIUM TEST CASE 1 STEP 3 PASSED --- *** \n " );
	}
	
	
}


