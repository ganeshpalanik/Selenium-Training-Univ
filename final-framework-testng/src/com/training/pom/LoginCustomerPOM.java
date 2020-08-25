package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginCustomerPOM {
	
private WebDriver driver; 
	
	private Actions action; 
	
	public LoginCustomerPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);  
	}
	
	@FindBy(id="input-email")
	private WebElement email; 
	
	@FindBy(id="input-password")
	private WebElement password; 
	
	@FindBy(xpath=("//input[@type='submit']"))
	private WebElement Login; 

	
	public void SendEmail(String Email) {
		this.email.sendKeys(Email);
	}
	
	public void SendPassword(String Password) {
		this.password.sendKeys(Password);
	}
	
	public void clickLogin() {
		this.Login.click(); 
	}
	
	
}
