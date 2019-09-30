package com.orangehrm.generics;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.orangehrm.base.BaseTest;

public class ScreenShotHandle extends BaseTest
{
	public static void handleScreenShot(String imagename)
	{
		Date d=new Date();
		SimpleDateFormat s1=new SimpleDateFormat("dd_MM_YYYY");
		String date = s1.format(d);
		TakesScreenshot s=(TakesScreenshot)driver;
		File srcfile = s.getScreenshotAs(OutputType.FILE);
		File destfile=new File(Autoconstants.screenshotpath+imagename+date+".png");
		try 
		{
			FileUtils.copyFile(srcfile, destfile);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
