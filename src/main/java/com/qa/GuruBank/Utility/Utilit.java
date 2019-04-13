package com.qa.GuruBank.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.GuruBank.Base.GuruBankBase;

public class Utilit extends GuruBankBase {
	
	public static int Page_Load_TimeOut=40;
	public static int Implicit_Wait=40;
	public static int FlashNum=20;
	public static JavascriptExecutor js  = ((JavascriptExecutor)driver);
	
	public void SwitchFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	//***********************Data provide 
	public static Workbook book;
	public static Sheet sheet;
	
	
	public static  Object[][] GetTestData( String SheetName ,String TESTDATA_SHEET_PATH) {
		
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(SheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	//********************************highlight web element 
	public static void FlashElement (WebElement element , WebDriver driver)
	{
		       String ElementColor= element.getCssValue("background color");
		       for (int i=0;i<FlashNum;i++) {
		    	   ChangeColor("rgb(0,200,0)",element , driver);
		    	   ChangeColor(ElementColor ,element , driver);
		       }
	}
	
	public static void ChangeColor(String color ,WebElement element , WebDriver driver) {
		
		js.executeScript("arguments[0].style.backgroundColor= '"+color+"'",element);
		 try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				
			}
	}
	//*******************************************************borders around elements
	
	public static void DrawBorder(WebElement element , WebDriver driver ) {
		
		js.executeScript("arguments[0].style.border='3px solid red '",element);
		
	}
	//*****************create alert to bug 
	public static void CreateBugAlert(String message ,WebDriver driver) {
		js.executeScript("alert('"+message+"')");
	}
	//*********refresh page 
	public static void refreshPage() {
		js.executeScript("history.go(0)");
	}
	
	//***********get page inner text 
	public static String GetInnerText() {
		String PageText=js.executeScript("return document.documentElement.innerText;").toString();
		return PageText;
	}
	

}
