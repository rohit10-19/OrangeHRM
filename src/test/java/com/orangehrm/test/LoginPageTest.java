package com.orangehrm.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.generics.CustomListener;
import com.orangehrm.generics.PropertyFileHandle;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.OpenPIMPage;


public class LoginPageTest extends BaseTest
{
	LoginPage loginpage;
	OpenPIMPage openpimpage;
	
	@BeforeMethod
	public void setUp()
	{
		initilizatio();
	     loginpage=new LoginPage();
	}
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}
	@Test(priority=2)
	public void loginTest()
	{
		openpimpage=loginpage.login(PropertyFileHandle.propertyFileHandle("username"), PropertyFileHandle.propertyFileHandle("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
