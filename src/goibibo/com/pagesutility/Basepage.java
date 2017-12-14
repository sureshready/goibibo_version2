package goibibo.com.pagesutility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import goibibo.com.constants.ibiboconstants;
import goibibo.com.utility.ExtentManager;


public class Basepage {

	
	public WebDriver driver;
	public ExtentReports extent = ExtentManager.getInstance();
	public ExtentTest test;
	public topmenu menu;
	
	
	public Basepage()
	{
	
	}
	
	public Basepage(WebDriver driver,ExtentTest test )
	{
	
		this.driver=driver;
		this.test=test;
		menu= new topmenu(driver, test);
		
		
		PageFactory.initElements(driver, menu);
		
	}
	
	
	public void jsclicker(String xpathlocatorkey)
	{
		
		WebElement el = driver.findElement(By.xpath(xpathlocatorkey));
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("arguments[0].click()", el);
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
	
	public void selectoptionfromdropdown(String xpath, String using,String value)
	{
		WebElement elm = driver.findElement(By.xpath(xpath));
		
		Select s= new Select(elm);
		
		if(using.equals("value")){
		s.selectByValue(value);
		}else if(using.equals("visibletext"))
		{
			s.selectByVisibleText(value);
		}
		
		else	
		{
			s.selectByIndex(Integer.parseInt(value));
		}
	}
	
	public WebElement elementfinder(String xpath){
		
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
		
		
	}
	
	
	

	public void selectDate(String date) throws ParseException, Exception
	{
		
		SimpleDateFormat df =  new SimpleDateFormat("dd/MM/yyyy");
		Date dateToBeSelected = df.parse(date);
		System.out.println("date seleccted is"+dateToBeSelected);
		Date currentdate= new Date();
		
		driver.findElement(By.xpath("//div[@class='shCalenderBox col-md-5 col-sm-5 col-xs-12 pad0 marginTB10 marginAdjust']/div[1]/div[1]/input[1]")).click();
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(10000);
		
		String firstmonthyeardisplayed = driver.findElement(By.xpath(ibiboconstants.calendercurrentmonth_xpath)).getText();
		String secondmonthyeardisplayed = driver.findElement(By.xpath(ibiboconstants.calendersecondmonth_xpath)).getText();
		
		
		String month= new SimpleDateFormat("MMMM").format(dateToBeSelected);
		String year = new SimpleDateFormat("yyyy").format(dateToBeSelected);
		String day = new SimpleDateFormat("d").format(dateToBeSelected);
		
		String monthyeartobeselected =month+" "+year;
		
		
		System.out.println("day is"+day);
		
		
		
		while(true){
		
		
		
		if(firstmonthyeardisplayed.equals(monthyeartobeselected))
		{
			
			driver.findElement(By.xpath("//div[@class='DayPicker DayPicker--en']/div[2]//div[text()='"+day+"']")).click();
		
			break;
		}
		
		else if(secondmonthyeardisplayed.equals(monthyeartobeselected))
		{
			
			driver.findElement(By.xpath("//div[@class='DayPicker DayPicker--en']/div[3]//div[text()='"+day+"']")).click();
			break;
		}
		
		
		
			
		else if(dateToBeSelected.after(currentdate)){
			
			driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
		}
			
			
		
		
		firstmonthyeardisplayed = driver.findElement(By.xpath(ibiboconstants.calendercurrentmonth_xpath)).getText();
		 secondmonthyeardisplayed = driver.findElement(By.xpath(ibiboconstants.calendersecondmonth_xpath)).getText();
		
		
		
			        }
		
		
		
	}

	
}
