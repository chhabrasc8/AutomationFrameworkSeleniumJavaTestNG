package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {
	
	static WebDriver driver;
	
	public static WebDriver initDriver(String browser) 
	{
		switch(browser)
		{
		case "chrome":
		WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();// ye line chrome par password popup na aaye us liye hai 
        
        options.addArguments("--incognito");// ye line chrome par password popup na aaye us liye hai 
        options.addArguments("--disable-notifications");// ye line chrome par password popup na aaye us liye hai 
        
        driver = new ChromeDriver(options);// ye line chrome par password popup na aaye us liye hai 
		//driver = new ChromeDriver(); // commented
		break;
		
		case "firefox":
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		break;
		
		case "edge":
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		break;
		
		}
		
		return driver;
		
		
	}

}
