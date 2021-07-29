package com.fleet.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Base  {
	public WebDriver driver;
	public WebDriver baseMethod() throws Exception {

		Properties pro = new Properties();
		FileInputStream in = new FileInputStream("C:\\Users\\KK\\eclipse-workspace\\test\\src\\com\\fleet\\base\\base.properties");
		pro.load(in);
		String browserName = pro.getProperty("browser");
		if(browserName.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",pro.getProperty("chromedriverPath"));			
		driver = new ChromeDriver();
		}
		else if(browserName.equals("msedge"))
		{
			System.setProperty("webdriver.edge.driver",pro.getProperty("msedgePath"));			
			driver = new EdgeDriver();
		}
		driver.get(pro.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		return driver;
	}
}

