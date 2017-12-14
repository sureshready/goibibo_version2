package goibibo.com.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import goibibo.com.TestsUtility.BaseTest;
import goibibo.com.constants.ibiboconstants;
import goibibo.com.pages.Flightfarepage;
import goibibo.com.pages.Flightspage;
import goibibo.com.pages.LaunchPage;
import goibibo.com.pages.Loginpage;

public class onewayflightbookTest extends BaseTest{
	
	
	@Test
	public void onewayflightbook() throws Exception
	{
		
		test=extent.startTest("onewayflightbookTest");
		

		
		init("chrome");
		
		test.log(LogStatus.INFO, "broeser launched");
		LaunchPage launchpag = new LaunchPage(driver, test);
	
		PageFactory.initElements(driver, launchpag);
		
		Loginpage lpage=launchpag.Launchgoibibo(ibiboconstants.ibibourl);
		test.log(LogStatus.INFO, "url launched");
		Flightspage flightpag = lpage.doLogin("8977688776", " suresh267");
		test.log(LogStatus.INFO, "logged in  to goibibo");
		test.log(LogStatus.INFO, "logged in with username/password");
		
	
		String despath= screenshottaker();
		
		test.log(LogStatus.INFO, test.addScreenCapture(despath));
		System.out.println("titke is   -- "+driver.getTitle());
		
		Thread.sleep(10000);
		
		flightpag.flightsearch("Hyderabad (HYD)","Pune (PNQ)");
		
		
		List<WebElement> li= driver.findElements(By.xpath(ibiboconstants.allflightstitle_xpath));
		if(li.size()==0)
		{
		failtest("all fights text not there");
		}
		
	
		
		
		
	}
	
	
	
@AfterMethod
	
	public void quit()
	{
		if(extent!=null)
		{
		extent.endTest(test);
		extent.flush();
		}
	}
	

}
