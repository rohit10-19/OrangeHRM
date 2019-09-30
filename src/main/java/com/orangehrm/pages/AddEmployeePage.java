package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.base.BaseTest;

public class AddEmployeePage extends BaseTest
{
	@FindBy(xpath="//h1[contains(text(),\"Add Employee\")]")
	private WebElement addemployee;
	
	
	
	@FindBy(id="firstName")
	private WebElement firstname;
	
	@FindBy(id="lastName")
	private WebElement lastname;
	
	@FindBy(id="chkLogin")
	private WebElement checkbox;
	
	@FindBy(id="user_name")
	private WebElement username;
	
	@FindBy(id="user_password")
	private WebElement password;
	
	@FindBy(id="re_password")
	private WebElement rpassword;
	
	
	@FindBy(id="btnSave")
	private WebElement savebutton;
	
	
	public AddEmployeePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyAddEmployeeLabel()
	{
		return addemployee.isDisplayed();
	}
	
	

	public void setCredentials(String FirstName, String LastNmae, String Username, String Password, String RPassword)
	{
		
		firstname.sendKeys(FirstName);
		lastname.sendKeys(LastNmae);
		checkbox.click();
		username.sendKeys(Username);
		password.sendKeys(Password);
		rpassword.sendKeys(RPassword);
		savebutton.click();
		
	}
	
	
	
	
	

}
