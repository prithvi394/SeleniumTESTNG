package ExtentReport;

import com.relevantcodes.extentreports.*;

public class ExtentManager {
	
	 static ExtentReports extent;
	    final static String filePath = "C:\\Users\\Prithviraj\\SeleniumExecutionResults\\ExtentReports\\TestNGGrid.html";
	    
	    public synchronized static ExtentReports getReporter() {
	        if (extent == null) {
	            extent = new ExtentReports(filePath, true);
	        }
	        
	        return extent;
	    }
}
