package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPOM {
	
	private WebDriver driver; 
	
	private Actions action;
	
	int i=1;
	
	String items= " ";
	
	public DashboardPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//*[@id='menu-catalog']")
	private WebElement catalog;
	
	//List<WebElement> elements = driver.findElements(By.xpath("//*[@id='menu-catalog']/ul/li)"));
	
	@FindAll(@FindBy(xpath = "//*[@id='menu-catalog']/ul/li)"))
	List<WebElement> elements;
	
	
	public void mouseovercatagory() {
		
		action = new Actions(this.driver);
		action.moveToElement(this.catalog).perform();	
								
	}
	
	public void display()
	{
		action = new Actions(this.driver);
	
		for (i=0; i<elements.size();i++)
		{
			
			action.moveToElement(this.elements.get(i)).perform();
			
			
	      System.out.println("CATALOG ITEMS:" + elements.get(i).getAttribute("value"));
	    }
	
	}
}
