package goibibo.com.pagesutility;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;

public class utilityfuncs extends Basepage{

	
	
	public utilityfuncs()
	{
		
	}
	
	public utilityfuncs(WebDriver driver, ExtentTest test)
	{
		
	super(driver, test);
	}
	
	
	
	public int framescounter()
	{
		
		int size= driver.findElements(By.tagName("iframe")).size();
		
		System.out.println("number of frames are "+size);
		
		return size;
	}
	
	
	
		public void inputtext(String xpath,String valuekey) throws Exception
	{
		
		
	 driver.findElement(By.xpath(xpath)).sendKeys(valuekey);
	
	}
		
		public void clicker(String xpathlocatorkey)
		{
			
			 driver.findElement(By.xpath(xpathlocatorkey)).click();	
			
		}
		
		
		public void jsclicker(String xpathlocatorkey)
		{
			
			WebElement el = driver.findElement(By.xpath(xpathlocatorkey));
			JavascriptExecutor js = (JavascriptExecutor) driver;  
			js.executeScript("arguments[0].click()", el);
		}
		
		
		
}

