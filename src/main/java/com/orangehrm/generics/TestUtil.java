package com.orangehrm.generics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class TestUtil 
{
	public static  long Page_Load_Timeouts=20;
	public static  long Implicit_Wait=20;
	
	public static String excelpath="E:\\SeleniumFrameWorkplace\\OrangeHRMFramework\\Excel\\OrangeHrmTestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] getTestData(String sheetname)
	{
		FileInputStream file=null;
		
		try 
		{
			file=new FileInputStream(excelpath);
		}
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try 
		{
			book=WorkbookFactory.create(file);
		} 
		catch(Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		sheet=book.getSheet(sheetname);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
	



}
