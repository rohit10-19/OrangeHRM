package com.orangehrm.commonseleniumactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.orangehrm.base.BaseTest;

public class WebdriverActions extends  BaseTest
{
	public static void openApp(String url)
	{
		driver.get(url);
	}
	public static void selectListBoxOption(WebElement element, int option)
	{
		Select s=new Select(element);
		s.selectByIndex(option);
	}
	public static void mouseAction(WebElement target)
	{
		Actions a=new Actions(driver);
		a.moveToElement(target).perform();
	}
	public static void tearDown()
	{
		driver.close();
	}

}
