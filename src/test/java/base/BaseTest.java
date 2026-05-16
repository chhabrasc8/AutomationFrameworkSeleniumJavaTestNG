package base;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.ConfigReader;
import utils.ExtentReportUtil;
import utils.ScreenshotUtil;
import utils.WebDriverFactory;

public class BaseTest {

    public WebDriver driver;
    public ExtentTest test;


    @BeforeSuite
    public void startReport()
    {
        ExtentReportUtil.getReport();
    }


    @BeforeMethod
    public void setup(Method method)
            throws IOException
    {

        ConfigReader.readpropfile();

        driver =
          WebDriverFactory.initDriver(
            ConfigReader.getBrowser());

        driver.get(
            ConfigReader.getURL());

        test =
          ExtentReportUtil.starttest(
            method.getName());
    }


    @AfterMethod
    public void tearDown(
            ITestResult result)
            throws IOException
    {

        if(result.getStatus()
                == ITestResult.SUCCESS)
        {
            test.log(
              Status.PASS,
              "Test Passed");
        }

        if(result.getStatus()
                == ITestResult.FAILURE)
        {
            test.log(
              Status.FAIL,
              "Test Failed");

            ScreenshotUtil.getScreenshot(
                    driver,
                    result.getName());
        }

        if(driver != null)
        {
            driver.quit();
        }
    }


    @AfterSuite
    public void closeReport()
    {
        ExtentReportUtil.flushReport();
    }

}