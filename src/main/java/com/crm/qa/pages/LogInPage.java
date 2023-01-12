package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LogInPage extends TestBase {


	@FindBy(name = "email")
	@CacheLookup
    WebElement email;
	
	@FindBy(name = "password")
    WebElement password; 
	
	@FindBy(xpath= "//div[starts-with(text(),'Login')]")
	WebElement LogInBtn;
	
	//Initializing the Page Objects:
	
	public LogInPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public String validateLogInPageTitile() {
		return driver.getTitle();
	}
	
	public HomePage LogIn(String Username, String pwd) throws IOException {
		email.sendKeys(Username);
		password.sendKeys(pwd);
		LogInBtn.click();
		
		return new HomePage();
	}
	
	
	
	

}
