package com.fleet.test;

import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.fleet.base.Base;
import com.fleet.page.*;

public class HomeTest {
	WebDriver driver;
	Base bas;
	WorkPage work;
	@BeforeClass
	public void beforeClass() throws Exception {

		bas=new Base();
		driver=bas.baseMethod();
		work =new WorkPage(driver);
	}

	@Test(priority=0)
	public void verifyTitle() throws Exception{
		work.title();
	}
	@Test(priority=1)
	public void verifySlider() throws Exception{
		work.verifySliderElements();
		work.accessSlider();
	}
	@Test(priority=2)
	public void verifyCards() throws Exception{
		work.scrollFilter();
		work.card();
		Thread.sleep(50000);
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
	 
	if(ITestResult.FAILURE==result.getStatus())
	{
	try 
	{
	TakesScreenshot ts=(TakesScreenshot)driver; 
	File source=ts.getScreenshotAs(OutputType.FILE);
	FileHandler.copy(source, new File("./Screenshots/"+result.getName()+".png"));
	System.out.println("Screenshot taken");
	} 
	catch (Exception e)
	{
	System.out.println("Exception while taking screenshot "+e.getMessage());
	} 
	}
	}
	
	@AfterClass
	public void afterClass() throws InterruptedException {

		driver.quit();// dispose driver

	}
}
