package TestNGSelenium.SeleniumTestNG.Tests;

import org.testng.annotations.Test;

import TestNGSelenium.SeleniumTestNG.BaseClass.BaseClass;

public class Test3 extends BaseClass {
  @Test
  public void testSteps() {
	  
	  wshpObj.clickRegisterlink();
	  registrationPageObj.populateFields();
	  
  }
}
