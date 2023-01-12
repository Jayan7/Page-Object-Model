package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverListener;


import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListner;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
//	public static WebEventListner eventListner;
//	public static EventFiringWebDriver  e_driver;

	public TestBase() throws IOException {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\QA\\Selenium_workplace\\POM\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void intialization() throws IOException {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\QA\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "C:\\QA\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
//		e_driver =  new WebDriverListener(driver);
//		eventListner = new WebEventListner();
//		e_driver.register(eventListner);
//		driver = e_driver; 
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PageLoadTimeOut));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.ImplicitWait));

		driver.get(prop.getProperty("url"));
	}
}