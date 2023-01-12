package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.SignUpPage;
import com.crm.qa.pages.ValidateEmailPage;
import com.crm.qa.pages.WelcomePage;

public class SignUpPageTest extends TestBase {

	static WelcomePage WelcomePageObj;
	static SignUpPage SignUpPageObj;
	ValidateEmailPage ValidateEmailPageObj;

	public SignUpPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		intialization();
		WelcomePageObj = new WelcomePage();
		SignUpPageObj = WelcomePageObj.SignUp();
	}

	@Test(priority = 1)
	public void verifySignUpPageTitleTest() {
		String SignUpPageTitle = SignUpPageObj.verifySignUpPageTitle();
		Assert.assertEquals(SignUpPageTitle, "Cogmento CRM", "SignUpPageTitle not matched");
	}

	@Test(priority = 2)
	public void FillDeatailsTest() {
		SignUpPageObj.fillDetails();
	}

//	@Test(priority = 3)
	public void ClickOnSubmitBtnTest() {
		
		System.out.println("delete capcha than only test get pass");
		ValidateEmailPageObj = SignUpPageObj.clickOnSubmitBtn();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
