package TestNGSelenium.SeleniumTestNG.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.*;
import org.testng.annotations.Test;

import TestNGSelenium.SeleniumTestNG.HelperClass.ExcelHandler;

public class ScratchPad {
	
	public static Map <String, Map<String, String>> arrayExcelReader=new HashMap<String, Map<String, String>>();
	
	@BeforeSuite
	public void testExcelHelper() throws IOException{
		
		ExcelHandler obj=new ExcelHandler();
		
		obj.setExcelFile();
		
		arrayExcelReader=obj.getCellData();
		
		System.out.println("ScratchPadDone");
		
		}

}
