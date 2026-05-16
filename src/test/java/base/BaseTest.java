package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import java.lang.reflect.Method;

import utils.ConfigReader;
import utils.ExtentReportUtil;
import utils.ScreenshotUtil;
import utils.WebDriverFactory;

public class BaseTest {
	
	public WebDriver driver;
	public ExtentTest test;
	
	@BeforeTest
	public void setup() throws IOException{
		  
		 ConfigReader.readpropfile();
		
		 driver = WebDriverFactory.initDriver(ConfigReader.getBrowser());
		
		 //WebDriverManager.chromedriver().setup();
		 //driver=new ChromeDriver();
		 //driver.get("https://www.saucedemo.com/");
		 
		 driver.get(ConfigReader.getURL());
		 
		 ExtentReportUtil.setupreport();
	}
	@BeforeMethod
	public void starttest(Method method)
	{
		test = ExtentReportUtil.starttest(method.getName());
		
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL,"Test Case is Failed");
			ScreenshotUtil.getScreenshot(driver,result.getName());
		}
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS,"Test Case is Pass");
		}
		
	} 
	@AfterTest
	public void tearDown()
	{
		ExtentReportUtil.flushReport();
	}
}

