package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class WelcomePage extends TestBase {

	// WebElements

	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
    WebElement SignUpBtn;
	

	@FindBy(xpath = "//a[contains(text(),'About')]")
    WebElement AboutBtn;

	@FindBy(xpath = "//a[contains(text(),'Compare')]")
    WebElement CompareBtn;

	@FindBy(xpath = "//span[contains(text(),'Log In')]")
    WebElement LogInBtn;
	
	//Initializing the Page Objects:
	
	public WelcomePage() throws IOException{
		PageFactory.initElements(driver, this);
	}

	// Actions :

	public String validateWelcomePageTitle() {
		return driver.getTitle();
	}

	public SignUpPage SignUp() throws IOException {
		SignUpBtn.click();
		return new SignUpPage();
	}
	public AboutPage About() throws IOException {
		AboutBtn.click();
		return new AboutPage();
	}
	public ComparePage Compare() throws IOException {
		CompareBtn.click();
		return new ComparePage();
	}
	public LogInPage LogIn() throws IOException {
		LogInBtn.click();
		return new LogInPage();
	}

}
