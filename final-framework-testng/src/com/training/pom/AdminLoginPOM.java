package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPOM {
	
	private WebDriver driver;  
	
	
	public AdminLoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement Login; 
	
	@FindBy(name="Login")
	private WebElement Btn; 
	
	@FindBy(xpath="//div[@id='content']/div/div/h1")
	private WebElement Dash;

	
	public void SendUserName(String UserName) {
		this.userName.sendKeys(UserName);
	}
	
	public void SendPassword(String Password) {
		this.password.sendKeys(Password);
	}
	
	public void clickLogin() {
		this.Login.click(); 
		
	}
	
	public String Read()
	{
		return Dash.getText();
	}
}
