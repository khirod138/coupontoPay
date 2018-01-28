package com.utilities;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class AutomationUtility {
	
	public static WebDriver currentDriver;

	
	public static Object[][] getDataFromExcel(String sheetName)
	{
		Object[][] obj = new Object[2][4];
		try{
		
			System.out.println(obj.length);
		FileInputStream fis = new FileInputStream("K:\\Selenium\\com.coupontoPay\\src\\test\\resources\\TestData\\TestData.xlsx");
		
		Workbook wb = new XSSFWorkbook(fis);
		
		Sheet sh = wb.getSheet(sheetName);
		
		for(int i = 0; i<2;i++)
		{
			for(int j=0; j<4;j++)
			{
				
				obj[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return obj;
		
		}catch(Exception e)
		{
		e.printStackTrace();	
		}
		
		
		
		
		
		return null;
		
	}
}
