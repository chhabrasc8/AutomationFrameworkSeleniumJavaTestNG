package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter
        .ExtentSparkReporter;

public class ExtentReportUtil {

    static ExtentReports report;
    static ExtentSparkReporter reporter;

    public static void setupreport()
    {
        if(report == null)   // IMPORTANT
        {
            reporter =
             new ExtentSparkReporter(
             System.getProperty("user.dir")
             + "/Reports/Report.html");

            report =
             new ExtentReports();

            report.attachReporter(
                    reporter);
        }
    }


    public static ExtentTest
      starttest(String testname)
    {
        return report.createTest(
                testname);
    }


    public static void flushReport()
    {
        if(report != null)
        {
            report.flush();
        }
    }
}