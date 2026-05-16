package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductListPage;

public class CartTest extends BaseTest {
  @Test
  public void verifyAddToCart() {
	  LoginPage loginpage = new LoginPage(driver);
	  loginpage.enterUserName("standard_user");
	  loginpage.enterPassword("secret_sauce");
	  loginpage.clickLoginButton();
	  
	  ProductListPage productlistpage = new ProductListPage(driver);
	  productlistpage.clickAddToCart();
	  productlistpage.clickViewCart();
	  
	  CartPage cartpage = new CartPage(driver);
	  String actualProductTitle= cartpage.getProductTitle();
	  String expectedProductTitle = "Sauce Labs Backpack";
	  Assert.assertEquals(expectedProductTitle, actualProductTitle);
	  
	  String actualCartTitle = cartpage.getCartPageHeading();
	  String expectedCartTitle = "Your Cart";
	  Assert.assertEquals(expectedCartTitle, actualCartTitle);
	   
  }
}
