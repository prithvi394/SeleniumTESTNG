package TestNGSelenium.SeleniumTestNG.Tests;

import org.testng.Reporter;
import org.testng.annotations.*;

import junit.framework.Assert;

public class TestNG_Grouping {
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("This method runs before class");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println();
		System.out.println("This method runs before every method");
		
	}
	
	@BeforeTest
	public void BeforeTest() {
		System.out.println("This method runs before Test");
	}
	
	@BeforeGroups(groups = { "Sedan", "Audi" })
	public void BeforeGroups() {
		System.out.println("This method runs before Groups");
	}
	
	@Test(groups = { "Sedan", "BMW" })
	public void BMW3Series() {
		System.out.println("Running Test - BMW 3 Series");
		Assert.assertEquals(true, false);
	}
	@Test(groups = { "SUV", "BMW" })
	public void BMWX3() {
		Reporter.log("Reporting from BMW class", true);
		Assert.assertEquals(true, true);
		System.out.println("Running Test - BMW X3");
	}
	@Test(groups = {  "Audi" })
	public void AudiA6() {
		Reporter.log("Reporting from Audi A6 class", true);
		System.out.println("Running Test - Audi A6");
	}
	@Test(groups = { "Sedan", "Honda" })
	public void HondaAccord() {
		Reporter.log("Reporting from Honda class", true);
		System.out.println("Running Test - Honda Accord");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("This method runs after every method");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("This method runs after class");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("This method runs after Test");
	}
	
	@AfterGroups(groups = { "Audi" })
	public void AfterGroups() {
		System.out.println("This method runs after Groups");
	}

}
