package goibibo.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import goibibo.com.pagesutility.Basepage;
import goibibo.com.pagesutility.topmenu;

public class Loginpage extends Basepage {

	@FindBy(xpath="//input[@id='authMobile']") public WebElement usernamein;
	@FindBy(xpath="//button[@id='mobileSubmitBtn']") public WebElement usercontinuebutton;
	@FindBy(xpath="//input[@id='authCredentialPassword']") public WebElement passwordin;
	@FindBy(xpath="//button[@id='authCredentialPasswordSignInBtn']") public WebElement passcontinuebutton;
	
	
	public Loginpage(WebDriver driver, ExtentTest test)
	{
		super(driver,test);
	}
	
	
	
	public Flightspage doLogin(String username, String Password)
	{
		
		
		
		
		driver.switchTo().frame("authiframe");
		
		usernamein.sendKeys(username);
		
		test.log(LogStatus.INFO, "username entered");
		usercontinuebutton.click();
		test.log(LogStatus.INFO, "usercontinue button clicked entered");
		passwordin.sendKeys(Password);
		test.log(LogStatus.INFO, "password entered");
		passcontinuebutton.click();
		test.log(LogStatus.INFO, "passconntinue entered");
		
		driver.switchTo().defaultContent();
		

		Flightspage flightpag = new Flightspage(driver, test);
		PageFactory.initElements(driver, flightpag);
		
		
		//Landingpage landpage= new Landingpage(driver, test);
		//PageFactory.initElements(driver, landpage);
		
		
		return flightpag;
		

		
	}
	
}



