package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

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

			FirefoxOptions firefoxOptions =
			        new FirefoxOptions();

			firefoxOptions.addArguments("-headless");

			driver =new FirefoxDriver(firefoxOptions);

			break;
			
		case "edge":

			System.setProperty(
			"webdriver.edge.driver",
			"C:\\DRIVER\\edgedriver_win64\\msedgedriver.exe");

			EdgeOptions edgeOptions =
			        new EdgeOptions();

			edgeOptions.addArguments("--headless=new");
			edgeOptions.addArguments("--disable-gpu");
			edgeOptions.addArguments("--no-sandbox");
			edgeOptions.addArguments("--remote-allow-origins=*");
			edgeOptions.addArguments("--disable-dev-shm-usage");

			driver =
			      new EdgeDriver(edgeOptions);

			break;
		}
		
		
		return driver;
		
		
	}

}
