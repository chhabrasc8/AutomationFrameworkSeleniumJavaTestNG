package tests;

import org.testng.Assert;
//auto build test
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest{
	//WebDriver driver;
	
 @Test(priority = 1)
public void validatePageTitle() {
		  
	 String actualResult = driver.getTitle();
	 String expectedResult = "Swag Labs";
	 Assert.assertEquals(expectedResult,actualResult);
 }
	
  @Test(priority = 2)
  public void validateLogin() {
	  
	 LoginPage loginpage = new LoginPage(driver);
	 loginpage.enterUserName("standard_user");
	 loginpage.enterPassword("secret_sauce");
	 loginpage.clickLoginButton();
	 String actualResult = driver.getCurrentUrl();
	 String expectedResult = "https://www.saucedemo.com/inventory.html";
	 Assert.assertEquals(expectedResult, actualResult);
	 
  }
}
