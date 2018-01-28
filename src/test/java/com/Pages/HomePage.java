package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.AutomationUtility;

public class HomePage extends AutomationUtility{
	
//	HomePage(WebDriver driver)
//	{}

	@FindBy(xpath = ".//*[@id='colophon']/div/div[1]/div/div[3]/aside/div/ul/li[3]/a")
	public WebElement contactUs_Link;
	
	
	public ContactUsPage clickOnContactUsLink() throws InterruptedException
	{
		contactUs_Link.click();
		Thread.sleep(6000);
		return PageFactory.initElements(currentDriver, ContactUsPage.class);
	}
}
