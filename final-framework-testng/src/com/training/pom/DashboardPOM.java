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
	
	@FindAll(@FindBy(xpath = "//*[@id='menu-catalog']/ul/li"))
	List<WebElement> elements;
	
	@FindBy(xpath = "//*[@id='menu-catalog']/ul/li[1]")
	private WebElement category;
	
	
	public void mouseovercatagory() {
		
		action = new Actions(this.driver);
		action.moveToElement(this.catalog).perform();	
								
	}
	
	public void display()
	{
		for (int i=0;i<elements.size();i++)
		{
		
			System.out.println(elements.get(i).getText());
		
		}
		
		
	}
	
	public void category()
	{
		category.click();
	}
}
