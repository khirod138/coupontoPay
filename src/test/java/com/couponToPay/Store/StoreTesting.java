package com.couponToPay.Store;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class StoreTesting {

	@Test
	public void test1() throws Throwable
	{
		System.setProperty("webdriver.gecko.driver", ".\\DriverServer\\geckodriver.exe");
		//System.setProperty("webdriver.chrome.driver", ".\\DriverServer\\chromedriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://google.com");
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(srcFile, new File("D:\\Download_C\\google.png"));
	}
}
