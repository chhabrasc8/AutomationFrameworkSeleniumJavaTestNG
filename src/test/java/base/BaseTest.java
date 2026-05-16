package base;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.ConfigReader;
import utils.ExtentReportUtil;
import utils.ScreenshotUtil;
import utils.WebDriverFactory;

public class BaseTest {

    public WebDriver driver;
    public ExtentTest test;

    @BeforeMethod
    public void setup(Method method)
            throws IOException {

        ConfigReader.readpropfile();

        System.out.println(
                "Browser = "
                + ConfigReader.getBrowser());

        System.out.println(
                "URL = "
                + ConfigReader.getURL());

        driver =
                WebDriverFactory.initDriver(
                        ConfigReader.getBrowser());

        System.out.println(
                "Driver = "
                + driver);

        driver.get(
                ConfigReader.getURL());

        ExtentReportUtil.setupreport();

        test =
                ExtentReportUtil.starttest(
                        method.getName());
    }


    @AfterMethod
    public void tearDown(
            ITestResult result)
            throws IOException {

        if(result.getStatus()
                == ITestResult.FAILURE)
        {
            test.log(
                    Status.FAIL,
                    "Test Failed");

            if(driver != null)
            {
                ScreenshotUtil
                    .getScreenshot(
                            driver,
                            result.getName());
            }
        }

        if(result.getStatus()
                == ITestResult.SUCCESS)
        {
            test.log(
                    Status.PASS,
                    "Test Passed");
        }

        ExtentReportUtil.flushReport();

        if(driver != null)
        {
            driver.quit();
        }
    }
}