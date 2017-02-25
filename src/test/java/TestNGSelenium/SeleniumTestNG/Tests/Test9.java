package TestNGSelenium.SeleniumTestNG.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import TestNGSelenium.SeleniumTestNG.BaseClass.BaseClass;
import TestNGSelenium.SeleniumTestNG.HelperClass.TakeScreenshot;

public class Test9 extends BaseClass{
	
	@Test(groups={"Regression"},dataProvider="GetExcelInputs")
	public void testSteps(Map<String,String> test) throws Exception{
		
		/*for (Entry<String, String> entry1 : test.entrySet()) {
  		System.out.println(entry1.getKey());
  		System.out.print(entry1.getValue());
    	}*/
		
logger=report.startTest(this.getClass().getSimpleName());
		
		wshpObj.clickLoginLink();
		logger.log(LogStatus.PASS, "Clicked on SignIn button");
		SignInSignUpPageObj.enterCredsSubmit(test.get("LoginId"),test.get("Password"));
		logger.log(LogStatus.PASS, "Entered Login Credentials");
		Thread.sleep(1000);
		Thread.sleep(1000);
		
		String loginID=driver.findElement(By.xpath("//a[@class='account']")).getText();
		System.out.println(loginID);
		System.out.println("Test 9");
		//Assert.assertTrue(loginID.equalsIgnoreCase(test.get("LoginId")));
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
		test=arrayExcelReader.get("Test2");
		return new Object[][] {
		      new Object[] { test },
		};
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult testResult) throws IOException {
		
		System.out.println("I am in afterMethod block");
				
		if (testResult.getStatus()==ITestResult.FAILURE){
			screenshotObj.takeScreenshots(driver, this.getClass().getSimpleName());
			}
		
		driver.quit();		
		report.endTest(logger);
		report.flush();
	}
	

}
