package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	
	public static void getScreenshot(WebDriver driver,String testname) throws IOException
	{
		
		TakesScreenshot shot = (TakesScreenshot)driver;
		File scrFile = shot.getScreenshotAs(OutputType.FILE);
		File targetFile = new File("C:\\Users\\chhab\\eclipse-workspaceshammi\\AutomationFramwork\\Screenshots\\" +testname +".png");
		FileUtils.copyFile(scrFile, targetFile);
		
	}
}
