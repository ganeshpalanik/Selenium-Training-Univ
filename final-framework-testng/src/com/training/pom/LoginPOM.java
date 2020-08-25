package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	private Actions action;
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="formLogin_submitAuth")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//*[@id='Menu_Wmt3OMY3']/nav/ul/li[2]")
	private WebElement sysacct;
	
	@FindBy(xpath="//*[@id='Menu_Wmt3OMY3']/nav/ul/li[2]/ul/li[1]/a/span/span/i")
	private WebElement Login;
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void mouseoveracct() {
		
		action = new Actions(this.driver);
		action.moveToElement(this.sysacct).perform();		
					
	}
	
	public void LoginClick(){
		
		this.Login.click();	
	}
}
