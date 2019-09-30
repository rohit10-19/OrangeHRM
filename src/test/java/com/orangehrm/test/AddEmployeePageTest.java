package com.orangehrm.test;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.generics.ExcelReader;
import com.orangehrm.generics.PropertyFileHandle;
import com.orangehrm.generics.TestUtil;
import com.orangehrm.pages.AddEmployeePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.OpenPIMPage;


public class AddEmployeePageTest extends BaseTest
{
	LoginPage loginpage;
	OpenPIMPage openpimpage;
	AddEmployeePage addemployeepage;
	String sheetname="Sheet1";
	
	@BeforeMethod
	public void setUp()
	{
		initilizatio();
	     loginpage=new LoginPage();
	     openpimpage=loginpage.login(PropertyFileHandle.propertyFileHandle("username"), PropertyFileHandle.propertyFileHandle("password"));
	     addemployeepage=openpimpage.clickOnLink();
	    
	}
	
	
	@Test(priority=1)
	public void verifyAddEmployeePageLabel()
	{
		Assert.assertTrue(addemployeepage.verifyAddEmployeeLabel(),"addemployeelabel is missing on the page");
	}
	
	/*@DataProvider
	public  Object[][] getHRMTestData()
	{
		Object data[][]=TestUtil.getTestData(sheetname);
		return data;
	}
	
	
	@Test(priority=2,dataProvider="getHRMTestData")
	public void enterData(String FirstName, String LastNmae, String Username, String Password,String RPassword)
	
	{   
		//ExcelReader exl = new ExcelReader();
		//System.out.println(exl.rowCount("Sheet1"));
	
		//System.out.println(ExcelReader.rowCount("Sheet1"));
		String fname = ExcelReader.readExcelData("Sheet1",1 ,0 );
		
		String lname = ExcelReader.readExcelData("Sheet1", 1,1 );
		String un = ExcelReader.readExcelData("Sheet1", 1,2 );
		String pwd = ExcelReader.readExcelData("Sheet1",1,3 );
		String repwd = ExcelReader.readExcelData("Sheet1",1,3 );
		addemployeepage.setCredentials(FirstName,LastNmae,Username,Password,RPassword);
	}*/
	
	@Test(priority=2)
	public void fillData()
	{
       String fname = ExcelReader.readExcelData("Sheet1",1 ,0 );
		
		String lname = ExcelReader.readExcelData("Sheet1", 1,1 );
		String un = ExcelReader.readExcelData("Sheet1", 1,2 );
		String pwd = ExcelReader.readExcelData("Sheet1",1,3 );
		String repwd = ExcelReader.readExcelData("Sheet1",1,3 );
		addemployeepage.setCredentials(fname, lname, un, pwd, repwd);
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
