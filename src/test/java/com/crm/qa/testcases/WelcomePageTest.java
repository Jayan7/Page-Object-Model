package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.SignUpPage;
import com.crm.qa.pages.WelcomePage;


public class WelcomePageTest extends TestBase{
	
	static WelcomePage WelcomePageObj;
	static SignUpPage SignUpPageObj;
	
 
	public WelcomePageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		intialization();
		WelcomePageObj = new WelcomePage()  ;
	}
	
	@Test (priority=1)
	public void WelcomePageTitleTest() {
		String title = WelcomePageObj.validateWelcomePageTitle();
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
	}
	
	@Test (priority= 2)
	public void ClickOnSignUpBtnTest() throws IOException {
		SignUpPageObj =WelcomePageObj.SignUp();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
