package goibibo.com.pages;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import goibibo.com.TestsUtility.BaseTest;
import goibibo.com.constants.ibiboconstants;
import goibibo.com.pagesutility.Basepage;


public class Flightspage extends Basepage {
	
	
	
	
	public Flightspage(WebDriver driver,ExtentTest test)
	{
		
		super(driver,test);
		
		
	}

	
	
	
	public Flightfarepage flightsearch(String Source,String Destination) throws Exception
	{
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		inputtext(ibiboconstants.flightsearchfrom_xpath, Source);
		Thread.sleep(3000);
		driver.findElement(By.xpath(ibiboconstants.flightsearchfrom_xpath)).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath(ibiboconstants.flightsearchfrom_xpath)).sendKeys(Keys.ENTER);
		test.log(LogStatus.INFO, "source city entered");
		
		inputtext(ibiboconstants.flightsearchto_xpath,Destination );
		
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(ibiboconstants.flightsearchto_xpath)).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath(ibiboconstants.flightsearchto_xpath)).sendKeys(Keys.ENTER);
		
		test.log(LogStatus.INFO, "destination city entered");
		Thread.sleep(6000);
		clicker("//div[@class='col-md-12 col-sm-12 col-xs-12 pad0']/input[1]");
		
		Thread.sleep(6000);
		
		
		selectDate("26/12/2017");
		//clicker(ibiboconstants.startdate_xpath);
		
		test.log(LogStatus.INFO, "travel date entered");
		selectoptionfromdropdown(ibiboconstants.dropdflightclass, "visibletext","Economy");
		test.log(LogStatus.INFO, "type of class selected");
		
		clicker(ibiboconstants.getsetgobutton_xpath);
		
		
		List<WebElement> title = driver.findElements(By.xpath(ibiboconstants.allflightstitle_xpath));
		
		if(title.size()>0)
		{
			assertEquals("a", "a");		
		}
		
		else
		{
			assertEquals("a", "b");		
		}
		
		Flightfarepage farepage = new Flightfarepage(driver, test);
		
		PageFactory.initElements(driver, farepage);
		
		
		return farepage;
		
	}
	

}
