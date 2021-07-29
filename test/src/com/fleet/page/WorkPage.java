package com.fleet.page;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.testng.Assert;

import com.fleet.common.ResuableFunctions;


public class WorkPage {
	//locators
	
	WebDriver driver;
	ResuableFunctions rf=new ResuableFunctions();
	By slider = By.id("slick-slide-control01");
	By sliderTitle = By.xpath("//*[@id=\"slick-slide01\"]/div/div[1]/p[1]/span");
	By cards=By.xpath("//*[@id='filter']/div[2]/div[1]/a");
	
	//Constructor
	public WorkPage(WebDriver driver) {
		this.driver=driver;
	}
	//verifying methods
	public void title()
	{
		String title=driver.getTitle();
		System.out.println(title);
		boolean result=rf.StringStartsWith(title,"Works - Fleet Studio");
		System.out.println(result);
	}

	public void verifySliderElements()
	{
		boolean slide=driver.findElement(slider).isDisplayed();
		Assert.assertEquals(true, slide, "Slider Btn2 not found");

		boolean input=driver.findElement(sliderTitle).isEnabled();
		Assert.assertEquals(true, input, "SliderTitle not found");
	}
	
	public void accessSlider()
	{
		driver.findElement(slider).click();
		String sliderTit = driver.findElement(sliderTitle).getText();
		System.out.println(sliderTit);
		Assert.assertEquals(sliderTit, "QA");
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.MILLISECONDS);
	}
public void scrollFilter() throws InterruptedException
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,750)", "");
	Thread.sleep(5000);
	
}
	

public void card()
{
	List<WebElement> lt = driver.findElements(cards);
	for(int i =0;i<=lt.size()-1;i++)
	{
		if(lt.get(i).getText().contains("Gilead"))
		{
			lt.get(i).click();
			break;			
		}
	}
	System.out.println(driver.getTitle());
	Assert.assertEquals(true, driver.getTitle(), "QA");
}
}




