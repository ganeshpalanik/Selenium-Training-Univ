package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPOM {
	
	private WebDriver driver;  
	
	private String Product_Title =" ";
	
	public ProductDetailPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@class='panel-title']")
	private WebElement ProductList;
	
	@FindBy(xpath="//*[@id='input-name']")
	private WebElement Product_Name;
	
	@FindBy(xpath="//*[@id='input-price']")
	private WebElement Product_Price;
	
	@FindBy(xpath="//*[@id='button-filter']")
	private WebElement Filter;
	
	@FindBy(xpath="//*/div/table/tbody/tr/td[3]")
	private WebElement ProductFilter_Name;
	
	@FindBy(xpath="//*/div/table/tbody/tr/td[5]")
	private WebElement ProductFilter_Price;
	
	
	public String ProductList_Title()
	
	{
		Product_Title = ProductList.getText();
		return Product_Title;
	}
	
	public void ProductName(String Name)
	{
		Product_Name.sendKeys(Name);
	}
	
	public void ClickFilter()
	{
		Filter.click();
		
		Product_Name.clear();
		
		Product_Price.clear();
	}
	
	public String Product_Filter_Name()
	{
		
		return ProductFilter_Name.getText();
	}
	
	public void ProductPrice(String Price)
	{
		Product_Price.sendKeys(Price);
	}
	
	public String Product_Filter_Price()
	{
		
		return ProductFilter_Price.getText();
	}
}
