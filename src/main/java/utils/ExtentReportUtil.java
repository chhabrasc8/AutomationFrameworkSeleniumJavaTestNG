package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtil {

    private static ExtentReports report;
    private static ExtentSparkReporter reporter;

    public static ExtentReports getReport() {

        if(report == null)
        {
            reporter =
              new ExtentSparkReporter(
                System.getProperty("user.dir")
                + "/Reports/Report.html");

            report = new ExtentReports();

            report.attachReporter(reporter);

            report.setSystemInfo(
                "Tester", "Chhagan");
        }

        return report;
    }


    public static ExtentTest starttest(
            String testname)
    {
        return getReport()
               .createTest(testname);
    }


    public static void flushReport()
    {
        if(report != null)
        {
            report.flush();
        }
    }
}