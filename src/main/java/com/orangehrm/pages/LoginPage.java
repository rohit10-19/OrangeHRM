package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.base.BaseTest;

public class LoginPage extends BaseTest
{
	@FindBy(xpath="//input[@id='txtUsername']")
	private WebElement usernmae;
	
	@FindBy(xpath="//input[@id='txtPassword']")
	private WebElement password;
	
	
	@FindBy(xpath="//input[@id='btnLogin']")
	private WebElement loginbutton;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public OpenPIMPage login(String un, String pwd)
	{
		usernmae.sendKeys(un);
		password.sendKeys(pwd);
		loginbutton.click();
		
		return new OpenPIMPage();
		
	}

}
