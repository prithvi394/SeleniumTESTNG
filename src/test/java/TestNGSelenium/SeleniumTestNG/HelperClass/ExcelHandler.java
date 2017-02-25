package TestNGSelenium.SeleniumTestNG.HelperClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

import org.apache.poi.xssf.*;
import org.apache.poi.xssf.usermodel.*;

import TestNGSelenium.SeleniumTestNG.BaseClass.ConfigurationClass;


public class ExcelHandler {
	
	public static XSSFSheet XLWSheet;
	public static XSSFWorkbook XLWbook;
	public static XSSFCell xLCell1;
	public static XSSFCell xLCell2;
	public static XSSFCell xLCell3;
	public static XSSFCell xLCell;
	
	public void setExcelFile() throws IOException {	
		
		FileInputStream excelFile= new FileInputStream(ConfigurationClass.XLPath);
		//System.out.println(ConfigurationClass.XLPath);
		XLWbook=new XSSFWorkbook(excelFile);
		XLWSheet=XLWbook.getSheet(ConfigurationClass.XLSheetName);
		//System.out.println(XLWSheet.getSheetName());
		//System.out.println(className);
	}
	
	
	//@SuppressWarnings("null")
	//@SuppressWarnings("null")
	public  Map<String, Map<String, String>> getCellData(){
		int lastRow=XLWSheet.getLastRowNum();
		//System.out.println(lastRow);
		int rowCounter=1;
		//Map <String,String> loginCreds=new HashMap<String,String>();
				
		Map<String,Map<String,String>> arrayExcelReader =new HashMap <String,Map<String,String>>() ;
		
			while(rowCounter<=lastRow){
				
				Map<String,String> testParameters =new HashMap <String,String>() ;
				
				int colCounter=1;
				
				while(XLWSheet.getRow(0).getCell(colCounter)!=null){
						testParameters.put(XLWSheet.getRow(0).getCell(colCounter).getStringCellValue(),checkNullReturnString(XLWSheet.getRow(rowCounter).getCell(colCounter)));
						colCounter+=1;
				}	
				
						arrayExcelReader.put(XLWSheet.getRow(rowCounter).getCell(0).getStringCellValue(), testParameters);

				rowCounter+=1;
			}
			
			
		return arrayExcelReader;
		 
	}
	
	public String checkNullReturnString(XSSFCell xssfCell){
		
		if(xssfCell!=null){
			
			return xssfCell.getStringCellValue();
		}
		
		return null;
		
	}
	
	public  void setCellData(String data,int rownum,int colnum ){
		XSSFRow Row=XLWSheet.getRow(rownum);
		xLCell=Row.getCell(colnum,Row.RETURN_BLANK_AS_NULL);
			if(xLCell==null){
				xLCell=Row.createCell(colnum);
				xLCell.setCellValue(data);
			}
			else{
				xLCell.setCellValue(data);
			}
	}
		
		
		
		
	}
	
	
	
	
