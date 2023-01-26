package atulpracticecompany.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	
	
	public static ExtentReports getReportObject()
	{
		// ExtendReport ,,ExtendsSparkReporter
				String path = System.getProperty("user.dir") + "\\reports\\index.html";

				ExtentSparkReporter reporter = new ExtentSparkReporter(path); // is responsible to create html file and do some
																				// configuration
				reporter.config().setReportName("Web Automation Result");
				reporter.config().setDocumentTitle("Test Results");
				
				ExtentReports 	 extent = new ExtentReports();
				extent.attachReporter(reporter);
				extent.setSystemInfo("Tester", "Atul");
				return extent;
	}

}
