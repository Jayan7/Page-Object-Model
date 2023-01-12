package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LogInPage;
import com.crm.qa.pages.WelcomePage;
import com.crm.qa.util.TestUtil;

public class LogInpageTest extends TestBase {

	WelcomePage WelcomePageObj;
	LogInPage LogInPageObj;
	HomePage HomePageObj;
	String Sheetname = "LogInDetails";
	

	public LogInpageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setUp() throws IOException {
		intialization();
		WelcomePageObj = new WelcomePage();
		LogInPageObj = new LogInPage();
		WelcomePageObj.LogIn();
	}

	@Test(priority = 1)
	public void LogInPagetitleTest() {
		String title = LogInPageObj.validateLogInPageTitile();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@DataProvider
	public Object[][] getLogInTestData() {
		Object data[][] = TestUtil.getTestData(Sheetname);
		return data;
	}

	@Test(priority = 2, dataProvider = "getLogInTestData")
	public void LogIntest(String Emailadd, String Password ) throws IOException {
		HomePageObj = LogInPageObj.LogIn(Emailadd, Password);

	}

	@AfterMethod
	void tearDown() {
		driver.quit();
	}

}
