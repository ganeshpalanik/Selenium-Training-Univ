package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCategoryPOM {
	
	
	private WebDriver driver;  
	
	//private Actions action;
	
	public EditCategoryPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this); 
	}	 
		
	@FindBy(xpath="//*[@id='input-name1']")
	private WebElement categoryName_Text;
		
	public String Description() 
	{
		return categoryName_Text.getAttribute("Value");
	}
	
}
