package TestNGSelenium.SeleniumTestNG.BaseClass;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import TestNGSelenium.SeleniumTestNG.HelperClass.ExcelHandler;
import TestNGSelenium.SeleniumTestNG.HelperClass.TakeScreenshot;
import TestNGSelenium.SeleniumTestNG.POM.RegistrationPage;
import TestNGSelenium.SeleniumTestNG.POM.SignInSignUpPage;
import TestNGSelenium.SeleniumTestNG.POM.WebshopHomePage;
import TestNGSelenium.SeleniumTestNG.HelperClass.ExcelHandler;

public class BaseClass {
	
	protected  WebDriver  driver=null;
	public String baseURL="http://demowebshop.tricentis.com/";
	protected WebshopHomePage wshpObj;
	protected RegistrationPage registrationPageObj;
	protected SignInSignUpPage SignInSignUpPageObj;
	
	public TakeScreenshot screenshotObj=new TakeScreenshot();
	public static final String USERNAME = "prithvi5";
	public static final String ACCESS_KEY = "EGRjajz2xLJ7zXbJCPon";
	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	public static Map <String, Map<String, String>> arrayExcelReader=new HashMap<String, Map<String, String>>();
	protected  ExtentReports report;
	protected ExtentTest logger;
	
	@BeforeSuite
	public void testExcelHelper() throws IOException{		
		ExcelHandler obj=new ExcelHandler();		
		obj.setExcelFile();		
		arrayExcelReader=obj.getCellData();		
		System.out.println("Read Excel Sheet!!");
		}

	@Parameters("browser")
	@BeforeClass
	public synchronized void  projectDeclaration(String browser) throws MalformedURLException{
		
		driver=BaseClass.declareDriver(browser);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseURL);
		System.out.println("Browser invoked!!");
		synchronized(this){
		report=new ExtentReports("C:\\Users\\Prithviraj\\SeleniumExecutionResults\\ExtentReports\\TestNGGrid.html",false);
		}
		wshpObj=PageFactory.initElements(driver, WebshopHomePage.class);
		registrationPageObj=PageFactory.initElements(driver, RegistrationPage.class);
		SignInSignUpPageObj=PageFactory.initElements(driver, SignInSignUpPage.class);
	}
	

	public synchronized static WebDriver declareDriver(String browser) throws MalformedURLException{
		System.out.println(browser);
		 //WebDriver driver;
		 //DesiredCapabilities capability = null;
		 
		 if(browser.equalsIgnoreCase("FireFox")){
			 	return new FirefoxDriver();
		 }
		 else if (browser.equalsIgnoreCase("Chrome")){
			 	System.setProperty("webdriver.chrome.driver", "C:\\Selenium Training\\Practice\\Chrome Driver\\chromedriver.exe");
			 	return new ChromeDriver();
		 }
		 else {
		    
		 	return new ChromeDriver();
		 }
	}
		 
	public synchronized static WebDriver griddeclareDriver(String browser) throws MalformedURLException {
			 
				DesiredCapabilities capability=null;
				
				 System.out.println(browser);
				 if(browser.equalsIgnoreCase("FireFox")){
					 	 capability= new DesiredCapabilities();
					 	 capability.setCapability("os", "Windows");
					 	 capability.setCapability("os_version", "8");
					 	 capability.setCapability("browser", "Firefox");
					 	 capability.setCapability("browser_version", "50.0");
					 	 
					 	 
				 }
				 else if(browser.equalsIgnoreCase("Chrome")){
					 capability= new DesiredCapabilities();
				 	 capability.setCapability("os", "Windows");
				 	 capability.setCapability("os_version", "8");
				 	 capability.setCapability("browser", "Chrome");
				 	 capability.setCapability("browser_version", "52.0");
				 }
				 
				 	return new RemoteWebDriver(new URL(URL),capability);
	}
	
	
}


