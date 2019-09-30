package com.orangehrm.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.generics.PropertyFileHandle;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.OpenPIMPage;

public class OpenPIMPageTest  extends BaseTest
{
	LoginPage loginpage;
	OpenPIMPage openpimpage;
	
	@BeforeMethod
	public void setUp()
	{
		initilizatio();
	     loginpage=new LoginPage();
	     openpimpage=loginpage.login(PropertyFileHandle.propertyFileHandle("username"), PropertyFileHandle.propertyFileHandle("password"));
	}
	
	@Test(priority=2)
	public void openPIMPageTitleTest()
	{
		String title = openpimpage.validateOpenPIMpageTitle();
		Assert.assertEquals(title, "OrangeHRM");
		
	}
	
	@Test(priority=1)
	public void openPIMPage()
	{
		openpimpage.clickOnLink();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
