package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.base.BaseTest;

public class OpenPIMPage extends BaseTest
{
	@FindBy(xpath="//a[@id='menu_pim_viewPimModule']")
	private WebElement pimlink;
	
	@FindBy(xpath="//a[@id='menu_pim_addEmployee']")
	private WebElement addemployeelink;
	
	
	public OpenPIMPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateOpenPIMpageTitle()
	{
		 return  driver.getTitle();
	}
	
	public AddEmployeePage clickOnLink()
	{
		pimlink.click();
		addemployeelink.click();
		
		return new AddEmployeePage();
	}

}
