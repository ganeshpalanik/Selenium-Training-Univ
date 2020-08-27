package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CategoriesPOM {
	
	
	private WebDriver driver;  
	
	private Actions action;
	
	private String Alerttext=" ";
	
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
	
	
	@FindBy(xpath="//*[@id='form-category']/div/table/tbody/tr[2]/td[1]/input")
	private WebElement Chkbox;
	
	
	@FindBy(xpath="//button[@type='button']")
	private WebElement DeleteIcon;
	
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
	
	public void SelectCheckbox()
	{
		
		Chkbox.click();
		
	}
	
	public void DeleteSelectedCheckBox()
	{
		DeleteIcon.click();
	}
	
	public String AcceptOk()
	{
		Alert alert = this.driver.switchTo().alert();
		
		Alerttext = alert.getText();
		
		alert.accept();
		
		return Alerttext;
		
		
	}
}
