package com.tests;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Pages.ContactUsPage;
import com.Pages.HomePage;
import com.utilities.AutomationUtility;

public class ContactusTest extends AutomationUtility {

	static WebDriver  driver;
	HomePage homePage;
	
	public String getProperty(String propertyFilePath, String propertyName){
		
		try{
		FileInputStream fis = new FileInputStream(propertyFilePath);
		Properties prop = new Properties();
		prop.load(fis);
		
		return prop.getProperty(propertyName);
		
		}catch(Exception e){
			
			
		}
		return null;
	}
	
	
	
	@BeforeMethod
	public void bMetod() throws InterruptedException
	{
		if(getProperty(".\\src\\test\\resources\\config.properties","Browser").equals("Firefox")){
		System.setProperty("webdriver.gecko.driver", ".\\DriverServer\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://www.coupontopay.com");
		
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		homePage = PageFactory.initElements(driver, HomePage.class);
		currentDriver =driver;
		}else if(getProperty(".\\src\\test\\resources\\config.properties","Browser").equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", ".\\DriverServer\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://www.coupontopay.com");
			
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			homePage = PageFactory.initElements(driver, HomePage.class);
			currentDriver =driver;
		}
	}
	@Test(dataProvider = "getData")
	public void testCase1(String name, String email, String subject, String message) throws Throwable
	{
		ContactUsPage clickOnContactUsPage = homePage.clickOnContactUsLink();
		clickOnContactUsPage.fillContactForm(name, email, subject, message);
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = AutomationUtility.getDataFromExcel("ContactUs");
		
		return data;
	}
	
	@AfterMethod
	public void aMethod()
	{
		driver.quit();
	}
	
	
}
