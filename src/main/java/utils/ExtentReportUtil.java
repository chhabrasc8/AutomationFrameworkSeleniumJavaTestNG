package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtil {
	
	static ExtentReports report;    //It provide report's template
	static ExtentSparkReporter reporter; // It write report in the report
	static ExtentTest test; // It represent our information in test
	
	public static void setupreport()  // to setup the report
	{
		report = new ExtentReports();
		reporter = new ExtentSparkReporter("C:\\Users\\chhab\\eclipse-workspaceshammi\\AutomationFramwork\\Reports\\Report.html");
		report.attachReporter(reporter);
	}
	
	public static ExtentTest starttest(String testname) // to create test
	{
		test = report.createTest(testname);
		return test;
	}
	
	public static void flushReport()  // to flush the report
	{  
		report.flush();
	}
	

}
