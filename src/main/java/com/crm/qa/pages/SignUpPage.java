package com.crm.qa.pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class SignUpPage extends TestBase {
		
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="terms")
	WebElement checkbox;
	
	@FindBy(xpath="//div[@class='recaptcha-checkbox-border']")
	WebElement notrobot;
	
	@FindBy(xpath="//button[contains(text(),'Sign up')]")
	WebElement SignUpbtn;
	
	
	//Intializing the Page Objects
	
	public SignUpPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	//Actions
	
	public String verifySignUpPageTitle() {
		return driver.getTitle();
	}
	
	public void fillDetails() {
		
		
		email.sendKeys(prop.getProperty("username"));
		checkbox.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.xpath("//iframe[@title='reCAPTCHA']")));
		
		wait.until(ExpectedConditions.elementToBeClickable(notrobot)).click();
	}
	
	public ValidateEmailPage clickOnSubmitBtn() {
		fillDetails();
		SignUpbtn.click();
		return new ValidateEmailPage();
	}

}
