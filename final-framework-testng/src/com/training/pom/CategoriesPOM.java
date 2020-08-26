package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoriesPOM {
	
	
	private WebDriver driver;  
	
	private Actions action;
	
	public CategoriesPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this); 
	}
	 
	
	@FindBy(linkText="Category Name")
	private WebElement categoryName;
	
	@FindBy(linkText="Sort Order")
	private WebElement Sort;
	
	@FindBy(xpath="//td[contains(text(),'Action')]")
	private WebElement Action;
	
	@FindBy(xpath="//*[td[4]/a/i]")
	private WebElement Editclick;
	
	@FindBy(xpath="//*[@id='form-category']//div//table//tbody//tr[1]//td[4]//a//i")
	private WebElement Editclick1;
	
	//xpath=//td[contains(.,'Action')
	public String cname()
	{
		return categoryName.getText();
	}
	
	public String sort()
	{
		return Sort.getText();
	}
	
	public String Action()
	{
		return Action.getText();
	}
	
	
	
	public void Edit_Click()
	{
		Editclick1.click();
			
	}
}
