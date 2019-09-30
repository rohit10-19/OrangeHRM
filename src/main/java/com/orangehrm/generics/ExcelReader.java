package com.orangehrm.generics;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;






public class ExcelReader
{
	private static Workbook wb;
	private static Sheet s;
	private static Row r;
	private static Cell c;
	
	
	public static int rowCount(String sheetname)
	{
		try 
		{  
			
			//String filelocation = System.getProperty("user.dir")+"\\Excel\\OrangeHrmTestData.xlsx";
			//System.out.println(filelocation);
			FileInputStream flpath = new FileInputStream(Autoconstants.excelpath);
			System.out.println(flpath);
			wb=WorkbookFactory.create(flpath );
			System.out.println(wb.getSheetName(0));
			System.out.println(wb.getSheetIndex("Sheet1"));
			System.out.println("line38");
			
		}
		catch (Exception e){
			
		e.printStackTrace();
		
		} 
		return wb.getSheet(sheetname).getLastRowNum();
	}
	public static int cellCount(String sheetname, int rownum)
	{
		try 
		{
			wb=WorkbookFactory.create(new FileInputStream(Autoconstants.excelpath));
		}
		catch (Exception e)
		{
			
		} 
		return wb.getSheet(sheetname).getRow(rownum).getLastCellNum();
	}
	
	public static String readExcelData(String sheetname, int rownum, int cellnum)
	{
		try 
		{
			wb=WorkbookFactory.create(new FileInputStream(Autoconstants.excelpath));
		}
		catch (Exception e)
		{
			
		} 
		return wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).toString();
	}
	
	public static void writeExcelData(String sheetname, int rownum, int cellnum, String value)
	{
		try 
		{
			wb=WorkbookFactory.create(new FileInputStream(Autoconstants.excelpath));
		}
		catch (Exception e)
		{
			
		} 
		wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).setCellValue(value);
		 try 
		 {
			wb.write(new FileOutputStream(Autoconstants.excelpath));
		} 
		 catch (Exception e) 
		 {
			
		} 
	}

	public static void main(String args[]) {
		
		System.out.println(ExcelReader.rowCount("Sheet1"));
		
		
	}
	
	
	
	
	
}
