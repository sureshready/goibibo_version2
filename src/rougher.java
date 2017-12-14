import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import goibibo.com.constants.ibiboconstants;
import goibibo.com.pagesutility.utilityfuncs;

public class rougher extends utilityfuncs {

	
	
	@Test
	public void roughtest() throws Exception
	{
		
		System.setProperty("webdriver.chrome.driver", ibiboconstants.chromedriver_path);
		
		
		driver = new ChromeDriver();
		
		driver.get("https:www.goibibo.com");
		
		clicker(ibiboconstants.signinlink_xpath);
		
		
		driver.switchTo().frame("authiframe");
		inputtext(ibiboconstants.username_xpath, "8977688776");
		clicker(ibiboconstants.usercontinuebutton_xpath);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		inputtext(ibiboconstants.passwordin_xpath, "ssuresh267");
		clicker(ibiboconstants.passcontinuebutton_xpath);
		
		
		Thread.sleep(10000);
	
	String date= "23/02/2019";
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
		
		
		
		
		System.out.println("the monthtbd "+firstmonthyeardisplayed);
		
		
		Thread.sleep(20000);
		
		
		
		jsclicker(ibiboconstants.ibibosignout_xpath);
		
		
		
		
		
		
		
		
		
	}
}
