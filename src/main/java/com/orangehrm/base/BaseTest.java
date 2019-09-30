package com.orangehrm.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.orangehrm.generics.Autoconstants;
import com.orangehrm.generics.PropertyFileHandle;
import com.orangehrm.generics.TestUtil;
import com.orangehrm.generics.WebDriverListener;

public class BaseTest 
{
	
	public static WebDriver driver;
	public  static EventFiringWebDriver e_driver;
	public static WebDriverListener eventListener;
	
	public static void initilizatio()
	{
		String browsername = PropertyFileHandle.propertyFileHandle("browser");
		if(browsername.equals("firfox"))
		{
			System.setProperty(Autoconstants.firefoxproperty, Autoconstants.firefoxpath);
			driver=new FirefoxDriver();
		}
		if(browsername.equals("chrome"))
		{
			System.setProperty(Autoconstants.chromeproperty, Autoconstants.chromepath);
			driver=new ChromeDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebDriverListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeouts,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
		driver.get(PropertyFileHandle.propertyFileHandle("url"));
	}

}
