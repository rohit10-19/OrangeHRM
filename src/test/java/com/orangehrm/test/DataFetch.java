package com.orangehrm.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class DataFetch 
{
	@Test
	public void getdata() throws Exception
	{
		String path="E:\\SeleniumFrameWorkplace\\OrangeHRMFramework\\Excel\\OrangeHrmTestData.xlsx";
		FileInputStream file=new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(file);
		Sheet s = wb.getSheet("Sheet1");
		Row r = s.getRow(1);
		Cell c = r.getCell(0);
		String value = c.getStringCellValue();
		System.out.println(value);
	}

}
