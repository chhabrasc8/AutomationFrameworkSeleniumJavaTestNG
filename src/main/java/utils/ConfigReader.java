package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	static Properties proprty = new Properties();
	
	public static void readpropfile() throws IOException {

	    FileReader reader = new FileReader(System.getProperty("user.dir") + "/src/test/resources/config.properties");

	    proprty.load(reader);
	}
	
     public static String getURL() 
     {
		return proprty.getProperty("url");
    	 
    	 }
     //below code is for taking browser from jenkin permetraized
     public static String getBrowser()
     {
         String browser =
                 System.getProperty("browser");

         if(browser == null)
         {
             browser =
             proprty.getProperty("browser");
         }

         return browser;
     }
}
