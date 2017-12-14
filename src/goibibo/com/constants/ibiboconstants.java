package goibibo.com.constants;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ibiboconstants {

	
		//*******************************url's***********************
	public static final String ibibourl= "https://www.goibibo.com";
	
		
		
		//****************************login xpath's*******************************
	public static final String signinlink_xpath = "//a[@id='get_sign_in']";
	
	public static final String username_xpath  = "//input[@id='authMobile']";
	
	public static final String usercontinuebutton_xpath =  "//button[@id='mobileSubmitBtn']";
	
	
	public static final String passwordin_xpath ="//input[@id='authCredentialPassword']";
	
	public static final String passcontinuebutton_xpath  = "//button[@id='authCredentialPasswordSignInBtn']";


	public static final String ibibosignout_xpath="//span[text()=' SignOut']";
	

	//*******************************driver paths***********************
	
	public static final String chromedriver_path="C:\\Users\\SGONDESI\\Downloads\\chromedriver.exe";
	
	
	
	
	
	
	
	//*******************************Flightspagexpath's******************************
	public static final String flightsearchfrom_xpath= "//input[@id='gosuggest_inputSrc']";
	
	public static final String flightsearchto_xpath=" //input[@id='gosuggest_inputDest']";
	
	public static final String getsetgobutton_xpath="//button[text()='Get Set Go']";
	
	public static final String startdate_xpath  ="//span[@id='price_20171214']";
	
	
	public static final String allflightstitle_xpath  = "//a[contains(text(),'All flights')]";
	
	
	                  //************calenderxpath's***************
	
	
	public static final String calendercurrentmonth_xpath = "//div[@class='fare-calFlt  fltHmCal']/div[1]/div[2]/div[1]";
	
	public static final String calendersecondmonth_xpath ="//div[@class='fare-calFlt  fltHmCal']/div[1]/div[3]/div[1]";
	
	
	//******************************dropdown values*********************************
	
	
	public static final String dropdflightclass ="//select[@id='gi_class']";
	
	
	
	
	

	}


