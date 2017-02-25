package TestNGSelenium.SeleniumTestNG.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.LogStatus;

import TestNGSelenium.SeleniumTestNG.BaseClass.BaseClass;
import TestNGSelenium.SeleniumTestNG.HelperClass.ExcelHandler;
import TestNGSelenium.SeleniumTestNG.HelperClass.TakeScreenshot;

public class Test1 extends BaseClass{
	
	@Test(groups={"Regression"},dataProvider="GetExcelInputs")
	public void testSteps(Map<String,String> test) throws InterruptedException, IOException{
		
		/*for (Entry<String, String> entry1 : test.entrySet()) {
  		System.out.println(entry1.getKey());
  		System.out.print(entry1.getValue());
    	}*/
		logger=report.startTest(this.getClass().getSimpleName());
		
		wshpObj.clickLoginLink();
		logger.log(LogStatus.PASS, "Clicked on SignIn button");
		SignInSignUpPageObj.enterCredsSubmit(test.get("LoginId"),test.get("Password"));
		logger.log(LogStatus.PASS, "Entered Login Credentials");
		Thread.sleep(5000);
		
		String loginID=driver.findElement(By.xpath("//a[@class='account']")).getText();
		System.out.println(loginID);		
		try{		
			Assert.assertTrue(false);
		}catch(AssertionError e){
			//Assert.fail();
			System.out.println(e.getMessage());
			screenshotObj.takeScreenshots(driver, this.getClass().toString());
		}
		
		System.out.println("I am out of catch block");
	}
	
	@DataProvider(name="GetExcelInputs")
	public Object[][] getDataFromDataprovider() throws IOException{
		
		Map <String, Map<String, String>> arrayExcelReader=BaseClass.arrayExcelReader;		
		Map<String,String> test =new HashMap <String,String>() ;
		System.out.println(this.getClass().toString());
		test=arrayExcelReader.get("Test1");
		return new Object[][] {
		      new Object[] { test },
		};
		
	}
	
	@AfterMethod
	public void tearDown( ITestResult result) throws IOException{
		
		TakeScreenshot screenshotObj=new TakeScreenshot();
		
		if (result.getStatus()==ITestResult.FAILURE){
			screenshotObj.takeScreenshots(driver, this.getClass().toString());
			}
		driver.quit();		
		report.endTest(logger);
		report.flush();
	}
	

}
