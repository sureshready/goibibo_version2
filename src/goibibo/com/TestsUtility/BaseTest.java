package goibibo.com.TestsUtility;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import goibibo.com.utility.ExtentManager;

public class BaseTest  {

	
	public WebDriver driver;
	public ExtentReports extent= ExtentManager.getInstance();
	public ExtentTest test;
	
	
	
	
	//*******************************utility functions******************************************
	
	
	public void init(String browser)
	{
		
		if(browser.equals("chrome"))
		{
		
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\SGONDESI\\Downloads\\chromedriver.exe");
			
			driver=new ChromeDriver();
			
			test.log(LogStatus.INFO, "chrome initiated");
		}else
			
			if(browser.equals("firefox"))
				
				driver= new FirefoxDriver();
				
		test.log(LogStatus.INFO, "ff initiated");
		
	}
	
	
	
	
	public String screenshottaker()
	{
		
	TakesScreenshot srcs= ((TakesScreenshot)driver);
	File src=srcs.getScreenshotAs(OutputType.FILE);
	
	Date date= new Date();
	
	String datepath=date.toString().replaceAll(" ", "").replaceAll(":", "");
	
	String destpath="D:\\report\\"+datepath+".jpg";
	File dest= new File(destpath);
	
	try {
		FileUtils.copyFile(src, dest);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		return destpath;
		
	}
public WebElement elementfinder(String xpath){
		
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
}
	
	
	
	
	
	
	
	
	
	
//**************************test case related******************************	
	
	
	
	public void failtest(String message)
	{
		test.log(LogStatus.FAIL, message);
		String despath2=screenshottaker();
		test.log(LogStatus.INFO, test.addScreenCapture(despath2));
		
	assertEquals("a", "c");
		
	}
	
	public void skiptest(String message)
	{
	test.log(LogStatus.SKIP, message);
	}
	
	public void passtest(String message)
	{
		test.log(LogStatus.PASS, message);
	}
	
}
