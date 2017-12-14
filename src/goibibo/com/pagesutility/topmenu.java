package goibibo.com.pagesutility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import goibibo.com.constants.ibiboconstants;

public class topmenu extends utilityfuncs{

	
	
	
	public topmenu(WebDriver driver, ExtentTest test)
	{
	this.driver=driver;
	
	this.test = test;
	}
	
	
	

	
	
	public void logout()
	{
		
		jsclicker(ibiboconstants.ibibosignout_xpath);
		
		
		/*WebElement el = driver.findElement(By.xpath(ibiboconstants.ibibosignout_xpath));
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("arguments[0].click()", el);
		
*/
		
	}
	
	
	

}
