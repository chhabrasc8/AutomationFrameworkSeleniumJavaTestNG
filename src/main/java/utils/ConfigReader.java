package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	static Properties proprty = new Properties();
	
	public static void readpropfile() throws IOException {
		
		FileReader reader = new FileReader("C:\\Users\\chhab\\eclipse-workspaceshammi\\AutomationFramwork\\src\\test\\resources\\config.properties");
		proprty.load(reader);
	
	}
	
     public static String getURL() 
     {
		return proprty.getProperty("url");
    	 
    	 }
     public static String getBrowser()
     {
    	 return proprty.getProperty("browser");
     }
}
