package TestNGSelenium.SeleniumTestNG.HelperClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot {
	
	String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		for (int i = 0; i < length; i++) {
			int index = (int) (Math.random() * characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}
	
	public void takeScreenshots(WebDriver driver, String fileName) throws IOException{
		
			String fileNameFinal = fileName+"_"+getRandomString(10) + ".png";
			String directory = "C:\\Users\\Prithviraj\\SeleniumExecutionResults\\Screenshots\\class Grp1.testCases.CompleteSingleTransaction\\";
			
			File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(sourceFile, new File(directory + fileNameFinal));
		}
		

}
