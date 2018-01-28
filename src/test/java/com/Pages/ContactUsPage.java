package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utilities.AutomationUtility;

public class ContactUsPage extends AutomationUtility{

	@FindBy(xpath = "//input[@name = 'name']")
	public WebElement name_txtBox;
	
	@FindBy(xpath = "//input[@name = 'email']")
	public WebElement email_txtBox;
	
	@FindBy(xpath = "//input[@name = 'subject']")
	public WebElement subject_txtBox;
	
	@FindBy(xpath = "//textarea[@placeholder = 'Message']")
	public WebElement message_txtBox;
	
	@FindBy(xpath = "//button[text() = 'Submit']")
	public WebElement submit_btn;
	
	public void fillContactForm(String name, String email, String subject, String message)
	{
		name_txtBox.sendKeys(name);
		email_txtBox.sendKeys(email);
		subject_txtBox.sendKeys(subject);
		message_txtBox.sendKeys(message);
		submit_btn.click();
	}
	
}
