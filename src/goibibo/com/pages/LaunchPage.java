package goibibo.com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import goibibo.com.pagesutility.Basepage;

public class LaunchPage extends Basepage {

	@FindBy(xpath="//a[@id='get_sign_in']") public WebElement signinlink;
	
	public LaunchPage(WebDriver driver, ExtentTest test)
	{
		
		super(driver,test);
		
		
	}
	
	
	
	public Loginpage Launchgoibibo(String url)
	{
		
		driver.get(url);
		test.log(LogStatus.INFO, "goibibo url launched");
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		signinlink.click();
		
		
		Loginpage loginpage = new Loginpage(driver, test);
		PageFactory.initElements(driver, loginpage);
		

		return loginpage;
		
	}
	
	
	
}
