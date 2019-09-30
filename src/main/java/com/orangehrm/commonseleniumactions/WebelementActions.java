package com.orangehrm.commonseleniumactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.base.BaseTest;

public class WebelementActions extends BaseTest
{
	public static boolean verifyElementDisplay(WebElement element)
	{
		return element.isDisplayed();
		
	}
	public static void verifyAlertPopUp(int timeout)
	{
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public static void handleAlert()
	{
		driver.switchTo().alert().accept();
	}

}
